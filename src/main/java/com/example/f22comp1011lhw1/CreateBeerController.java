package com.example.f22comp1011lhw1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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
    }

    /**
     * This method will read from the user inputs and create a Beer object
     */
    @FXML
    private void createBeer()
    {
        Beer beer = new Beer(nameTextField.getText(),
                manufacturerComboBox.getValue(),
                descriptionTextArea.getText(),
                Double.parseDouble(priceTextField.getText()),
                typeOfBeerComboBox.getValue(),
                countryTextField.getText(),
                bottleTypeComboBox.getValue(),
                Float.parseFloat(alchoholTextField.getText()),
                3);

        outputLabel.setText(beer.toString());
    }
}
