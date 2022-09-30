package com.example.f22comp1011lhw1;

public class Product {
    private String name, description;
    private Manufacturer manufacturer;
    private double price;

    public Product(String name, Manufacturer manufacturer, String description, double price) {
        setName(name);
        setManufacturer(manufacturer);
        setDescription(description);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    /**
     * setName receives a String as an argument, validates that it contains only letters or spaces
     * and sets the instance variable
     * @param name
     */
    public void setName(String name) {
        if (name.matches("[a-zA-Z\\s]*"))
            this.name = name;
        else
            throw new IllegalArgumentException("name can only contain letters a-Z");
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
            this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.trim().length()<=250)
            this.description = description.trim();
        else
            throw new IllegalArgumentException("description must be a max of 250 characters");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price>=0 && price<=1000)
            this.price = price;
        else
            throw new IllegalArgumentException("price must be in the range of 0-1000");
    }
}
