package com.internship.springBootInternship.service;


import com.internship.springBootInternship.DAO.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("partService")
@Transactional
public class PartService {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Part> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM part");
        return query.list();
    }
}
