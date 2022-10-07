package com.example.f22comp1011lhw1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Beer extends Product{
    private BottleType bottleType;
    private BeerType beerType;
    private float alcoholPercentage;
    private float rating;

    public Beer(String name, Manufacturer manufacturer, String description, double price, BeerType beerType, String bottleType, float alcoholPercentage, int rating) {
        super(name, manufacturer, description, price);
        setBeerType(beerType);
        setBottleType(bottleType);
        setAlcoholPercentage(alcoholPercentage);
        setRating(rating);
    }

    public BeerType getBeerType() {
        return beerType;
    }

    public void setBeerType(BeerType beerType) {
        this.beerType = beerType;
    }

    /**
     * The beer store will only support certain types of beer.  This method returns a list with all the valid types
     */
    public static List<String> getBeerTypes()
    {
        List<String> beerTypes = Arrays.asList("Lager","IPA","Stout","Ale","Amber");
        Collections.sort(beerTypes);
        return beerTypes;
    }

    public String getCountryOfOrigin() {
        return super.getManufacturer().getCountryCode();
    }


    public String getBottleType() {
        return bottleType;
    }

    /**
     * Maps define key -> value pairs, much like a dictionary in C#
     *
     * @return
     */
    public static TreeMap<String, Integer> getBottleTypes()
    {
        TreeMap<String, Integer> bottlesTypes = new TreeMap<>();
        bottlesTypes.put("can", 355);
        bottlesTypes.put("tall can", 473);
        bottlesTypes.put("bottle", 355);
        bottlesTypes.put("mini keg", 5000);
        bottlesTypes.put("crazy can",740);
        return bottlesTypes;
    }

    /**
     * Validates that the bottle type is one of the following: can, tall can, bottle, keg
     * @param bottleType
     */
    public void setBottleType(String bottleType) {

        bottleType = bottleType.trim().toLowerCase();
        if (getBottleTypes().keySet().contains(bottleType))
            this.bottleType = bottleType;
        else
            throw new IllegalArgumentException(bottleType + " is not valid, use one of "
                                +getBottleTypes());
    }

    public float getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(float alcoholPercentage) {
        if (alcoholPercentage>=2 && alcoholPercentage<=15)
            this.alcoholPercentage = alcoholPercentage;
        else
            throw new IllegalArgumentException("alcohol percentage must be in the " +
                                                        "range of 2-15");

    }

    public int getVolume() {
        return getBottleTypes().get(bottleType);
    }


    public float getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    public String toString()
    {
        return String.format("%s - $%.2f" , getName(), getPrice());
    }
}
