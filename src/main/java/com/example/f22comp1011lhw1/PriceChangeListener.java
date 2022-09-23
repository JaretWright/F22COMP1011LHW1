package com.example.f22comp1011lhw1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PriceChangeListener implements ChangeListener<String> {
    @Override
    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
        try{
            Double.parseDouble(newValue);  //takes a String as an argument and tries
                                            // to convert it into a Double
        } catch (Exception e)
        {
            System.out.printf("Old value: %10s   New Value: %10s%n",oldValue,newValue);
        }
    }
}
