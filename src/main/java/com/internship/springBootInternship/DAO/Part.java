package com.internship.springBootInternship.DAO;

import javax.persistence.*;

@Entity
@Table(name = "part")
public class Part {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "IsNecessary")
    private boolean isNecessary;

    @Column(name = "PartName")
    private String partName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isNecessary() {
        return isNecessary;
    }

    public void setNecessary(boolean necessary) {
        isNecessary = necessary;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", amount=" + amount +
                ", isNecessary=" + isNecessary +
                ", partName='" + partName + '\'' +
                '}';
    }
}
