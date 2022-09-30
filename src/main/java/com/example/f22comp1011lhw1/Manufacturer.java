package com.example.f22comp1011lhw1;

public class Manufacturer {
    private int manufacturerID;
    private String name, countryCode;

    public Manufacturer(int manufacturerID, String name, String countryCode) {
        setManufacturerID(manufacturerID);
        setName(name);
        setCountryCode(countryCode);
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
