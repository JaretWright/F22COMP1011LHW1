package com.example.f22comp1011lhw1;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Beer extends Product{
    private String type, countryOfOrigin, bottleType;
    private float alcoholPercentage;
    private float rating;

    public Beer(String name, String manufacturer, String description, double price, String type, String countryOfOrigin, String bottleType, float alcoholPercentage, int rating) {
        super(name, manufacturer, description, price);
        setType(type);
        setCountryOfOrigin(countryOfOrigin);
        setBottleType(bottleType);
        setAlcoholPercentage(alcoholPercentage);
        setRating(rating);
    }

    public String getType() {
        return type;
    }

    /**
     * The beer store will only support certain types of beer.  This method returns a list with all the valid types
     */
    public List<String> getBeerTypes()
    {
        return Arrays.asList("Lager","IPA","Stout","Ale");
    }

    /**
     * This method will validate that the type provided matches one of the valid types and set the instance
     * variable
     * @param type
     */
    public void setType(String type) {
        if (getBeerTypes().contains(type))
            this.type = type;
        else
            throw new IllegalArgumentException(type + " is not valid, use one of " + getBeerTypes());
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * Checks if the argument is 3 capital letters to represent a country
     * code.  Actual validation of the 3 letters is not performed
     * @param countryOfOrigin
     */
    public void setCountryOfOrigin(String countryOfOrigin) {
        if (countryOfOrigin.matches("[A-Z]3"))
            this.countryOfOrigin = countryOfOrigin;
        else
            throw new IllegalArgumentException("country of origin must be the 3 letter country code");
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
        bottlesTypes.put("Molson crazy can",740);
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
}
