package com.lambdaschool.piggybank.models;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "coins")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coinid;

    private String name;
    private String nameplural;
    private double value;
    private long quantity;

    //constructor

    public Coin(String name, String nameplural, double value, long quantity) {
        this.name = name;
        this.nameplural = nameplural;
        this.value = value;
        this.quantity = quantity;
    }

    public Coin() {
        //required by the JPA
    }

    //Getters and setters
    public int getCoinid() {
        return coinid;
    }

    public void setCoinid(int coinid) {
        this.coinid = coinid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameplural() {
        return nameplural;
    }

    public void setNameplural(String nameplural) {
        this.nameplural = nameplural;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Quantity: " + quantity;
    }
}
