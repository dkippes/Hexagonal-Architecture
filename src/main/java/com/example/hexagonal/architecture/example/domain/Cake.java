package com.example.hexagonal.architecture.example.domain;

import java.io.Serializable;

public class Cake implements Serializable {
    private static final long serialVersionUID
            = 100000000L;
    private String name;

    // Getters and setters for the name
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Cake [name=" + name + "]";
    }
}
