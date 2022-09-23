package com.example.f22comp1011lhw1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.NumberFormat;
import java.util.*;

public class CreateBeerController implements Initializable {

    @FXML
    private Label outputLabel;

    @FXML
    private TextField alchoholTextField;

    @FXML
    private ComboBox<String> bottleTypeComboBox;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ComboBox<String> manufacturerComboBox;

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
        List<String> manufacturers = Arrays.asList("Molson Coors","Modello",
                "Anheimer Bush","Heineken","Budweiser","Moosehead");
        Collections.sort(manufacturers);
        manufacturerComboBox.getItems().addAll(manufacturers);

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
        priceTextField.textProperty().addListener((obs, oldValue, newValue)->{
            newValue = newValue.replaceAll("[^(0-9.)]*","");
            try{
//                Double money = Double.parseDouble(newValue);
//                NumberFormat formatter = NumberFormat.getCurrencyInstance();
//                String moneyString = formatter.format(money);
//                System.out.println(moneyString);
              priceTextField.setText(newValue);
            }
            catch (Exception e)
            {
                priceTextField.setText(oldValue);
            }
        });

        //configure the country textfield to only accept 3 letter country codes.
        countryTextField.textProperty().addListener((obs, oldValue, newValue)->{
            newValue = newValue.replaceAll("[^(a-zA-Z)*]","");
            countryTextField.setText(newValue);
            if (newValue.length()>3)
            {  System.out.println(oldValue);
                countryTextField.setText(oldValue);}
        });

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
                        countryTextField.getText(),
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

        if (countryTextField.getText().isBlank())
            message = message.concat("country, ");

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
}
