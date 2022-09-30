package com.example.f22comp1011lhw1;

public class CountryCode {
    private String country, countryCode;

    public CountryCode(String country, String countryCode) {
        setCountry(country);
        setCountryCode(countryCode);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (!country.isBlank())
            this.country = country;
        else
            throw new IllegalArgumentException("country name cannot be blank");
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        countryCode = countryCode.trim().toUpperCase();
        if (countryCode.matches("[A-Z]{3}"))
            this.countryCode = countryCode;
        else
            throw new IllegalArgumentException("Country code must be 3 alphabetic characters");
    }
}
