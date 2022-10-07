package com.example.f22comp1011lhw1;

public class BottleType {
    private int bottleTypeID, volume;
    private String name;

    public BottleType(int bottleTypeID, int volume, String name) {
        setBottleTypeID(bottleTypeID);
        setVolume(volume);
        setName(name);
    }

    public int getBottleTypeID() {
        return bottleTypeID;
    }

    public void setBottleTypeID(int bottleTypeID) {
        if (bottleTypeID>0)
            this.bottleTypeID = bottleTypeID;
        else
            throw new IllegalArgumentException("BottleTypeID must be greater than 0");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume>0 && volume < 30000)
            this.volume = volume;
        else
            throw new IllegalArgumentException("volumen must be in the range of 1-30000");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank())
            this.name = name;
        else
            throw new IllegalArgumentException("name cannot be blank");
    }
}
