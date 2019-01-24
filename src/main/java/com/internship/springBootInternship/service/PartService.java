package com.internship.springBootInternship.service;


import com.internship.springBootInternship.DAO.Part;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("partService")
@Transactional
public class PartService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Part> getPage(int page, String filter) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Query query;
            switch (filter) {
                case "all":  query = session.createQuery("FROM Part"); break;
                case "optional": query = session.createQuery("FROM Part WHERE IsNecessary = 0"); break;
                case "necessary": query = session.createQuery("FROM Part WHERE IsNecessary = 1"); break;
                default: query = session.createQuery("FROM Part");
            }
            query.setFirstResult((page - 1) * 10);
            query.setMaxResults(10);
            return query.list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public int getNumberOfPages(String filter) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Query query;
            switch (filter) {
                case "optional": query = session.createQuery("SELECT COUNT(*) FROM Part WHERE IsNecessary = 0"); break;
                case "necessary": query = session.createQuery("SELECT COUNT(*) FROM Part WHERE IsNecessary = 1"); break;
                default: query = session.createQuery("SELECT COUNT(*) FROM Part");
            }
            Long result = (Long)(query.uniqueResult()) / 10 + 1;
            return result.intValue();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(long id) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Part toDelete = session.load(Part.class, id);
            session.delete(toDelete);
            session.flush();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Part getPart(long id) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM Part WHERE id=" + id);

            return (Part) query.list().get(0);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void editPart(Part part) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(part);
            session.flush();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Part> getByName(String nameQuery) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM Part WHERE PartName = :param1");
            query.setParameter("param1", nameQuery);
            return query.list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Part> getAll() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM Part");
            return query.list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
