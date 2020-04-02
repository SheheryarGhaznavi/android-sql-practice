package com.example.sherry.sql;

/**
 * Created by sherry on 10/20/17.
 */

public class Product {
    private int id;
    private String name;


    public Product()
    {

    }

    public Product(String name) {
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
