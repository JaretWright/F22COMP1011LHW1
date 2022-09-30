package com.example.f22comp1011lhw1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.converter.CurrencyStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.text.NumberFormat;
import java.util.*;

public class CreateBeerController implements Initializable {

    @FXML
    private Label outputLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private TextField alchoholTextField;

    @FXML
    private ComboBox<String> bottleTypeComboBox;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ComboBox<Manufacturer> manufacturerComboBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private Spinner<Integer> ratingSpinner;

    @FXML
    private ComboBox<String> typeOfBeerComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //update the ComboBox objects with a collection
        manufacturerComboBox.getItems().addAll(DBUtility.getManufacturersFromDB());

        typeOfBeerComboBox.getItems().addAll(Beer.getBeerTypes());

        bottleTypeComboBox.getItems().addAll(Beer.getBottleTypes().keySet());

        outputLabel.setText("");

        //setup a change listener for the price
//        PriceChangeListener pcl = new PriceChangeListener();
//        priceTextField.textProperty().addListener(pcl);

        //Anonymous inner class
//        priceTextField.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
//                priceTextField.setText(newValue.replaceAll("[^(0-9)]*",""));
//            }
//        });

        //as a lambda expression
//        priceTextField.textProperty().addListener((obs, oldValue, newValue)->{
//            System.out.printf("oldValue: '%s' newValue: '%s'%n",oldValue, newValue);
//            try{
//                double value = Double.parseDouble(newValue);
//                CurrencyStringConverter nsc = new CurrencyStringConverter(Locale.CANADA);
//                priceLabel.setText(nsc.toString(value));
//            }catch(Exception e)
//            {
//                    priceTextField.setText(oldValue);
//            }
//        });

        //configure the alcohol % to only accept doubles
        alchoholTextField.textProperty().addListener((obs, oldValue, newValue)->{
            try{
                Double.parseDouble(newValue);
            }
            catch (Exception e)
            {
                alchoholTextField.setText(oldValue);
            }
        });

        //configure our spinner to accept a range of integers
        //configured with a min of 0, max of 5 and default of 3
        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory
                                            .IntegerSpinnerValueFactory(0,5,3);
        ratingSpinner.setValueFactory(spinnerValueFactory);
        ratingSpinner.setEditable(true);
        TextField ratingTextField = ratingSpinner.getEditor();
        ratingTextField.textProperty().addListener((obs, oldValue, newValue)->{
            try{
                Integer.parseInt(newValue);
            }catch(Exception e)
            {
                ratingTextField.setText(oldValue);
            }
        });
    }

    /**
     * This method will read from the user inputs and create a Beer object
     */
    @FXML
    private void createBeer()
    {
        //check if the fields have been populated
        if (allFieldsHaveValues()) {

            try {
                Beer beer = new Beer(nameTextField.getText(),
                        manufacturerComboBox.getValue(),
                        descriptionTextArea.getText(),
                        Double.parseDouble(priceTextField.getText()),
                        typeOfBeerComboBox.getValue(),
                        bottleTypeComboBox.getValue(),
                        Float.parseFloat(alchoholTextField.getText()),
                        ratingSpinner.getValue());

                outputLabel.setText(beer.toString());
            } catch (Exception e) {
                outputLabel.setText(e.getMessage());
            }
        }
    }

    /**
     * This method will check if all the input fields have values
     * @return
     */
    private boolean allFieldsHaveValues() {
        String message = "Enter values for: ";

        if (nameTextField.getText().isBlank())
        {
            message = message.concat("name, ");
            nameTextField.getStyleClass().add("error");
        }
        else
        {
            nameTextField.getStyleClass().remove("error");
        }

        if (manufacturerComboBox.getValue() == null)
        {
            message = message.concat("manufacturer, ");
            manufacturerComboBox.getStyleClass().add("error");
        }
        else
        {
            manufacturerComboBox.getStyleClass().remove("error");
        }

        if (descriptionTextArea.getText().isBlank())
            message = message.concat("description, ");

        if (priceTextField.getText().isBlank())
            message = message.concat("price, ");

        if (typeOfBeerComboBox.getValue() == null)
            message = message.concat("type, ");

        if (bottleTypeComboBox.getValue()==null)
            message = message.concat("bottle type, ");

        if (alchoholTextField.getText().isBlank())
            message = message.concat("alcohol, ");

        //all the fields are populated
        if (message.equals("Enter values for: "))
            return true;

        message = message.substring(0,message.length()-2);
        outputLabel.setText(message);

        return false;
    }

    @FXML
    private void priceFieldUpdated()
    {
        String text = priceTextField.getText();
        if (text.length()==0)
            priceLabel.setText("$");
        try{
            double value = Double.parseDouble(text);
            CurrencyStringConverter nsc = new CurrencyStringConverter(Locale.CANADA);
            priceLabel.setText(nsc.toString(value));
        }catch(Exception e){
            priceLabel.setText("only #'s for price");
        }
    }
}
