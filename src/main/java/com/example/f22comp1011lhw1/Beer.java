package com.example.f22comp1011lhw1;

import java.util.Arrays;
import java.util.List;

public class Beer extends Product{
    private String type, countryOfOrigin, bottleType;
    private float alcoholPercentage;
    private int volume, rating;

    public Beer(String name, String manufacturer, String description, double price, String type, String countryOfOrigin, String bottleType, float alcoholPercentage, int volume, int rating) {
        super(name, manufacturer, description, price);
        setType(type);
        setCountryOfOrigin(countryOfOrigin);
        setBottleType(bottleType);
        setAlcoholPercentage(alcoholPercentage);
        setVolume(volume);
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


    public List<String> getBottleTypes()
    {
        return Arrays.asList("can", "tall can", "bottle", "keg");
    }

    /**
     * Validates that the bottle type is one of the following: can, tall can, bottle, keg
     * @param bottleType
     */
    public void setBottleType(String bottleType) {

        this.bottleType = bottleType;
    }

    public float getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(float alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
