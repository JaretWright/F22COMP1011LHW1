package com.example.f22comp1011lhw1;

public class BeerType {
    private int beerTypeID;
    private String name;
    private String description;

    public BeerType(int beerTypeID, String name, String description) {
        this.beerTypeID = beerTypeID;
        this.name = name;
        this.description = description;
    }

    public int getBeerTypeID() {
        return beerTypeID;
    }

    public void setBeerTypeID(int beerTypeID) {
        this.beerTypeID = beerTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString()
    {
        return name;
    }
}

