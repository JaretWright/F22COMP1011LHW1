package com.example.f22comp1011lhw1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableColumn<Beer, Integer> beerIDColumn;

    @FXML
    private TableColumn<Beer, String> brandColumn;

    @FXML
    private TableColumn<Beer, String> countryColumn;

    @FXML
    private TableColumn<Beer, String> nameColumn;

    @FXML
    private TableColumn<Beer, Double> priceColumn;

    @FXML
    private TableView<Beer> tableView;

    @FXML
    private TableColumn<Beer, Integer> volumeColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
