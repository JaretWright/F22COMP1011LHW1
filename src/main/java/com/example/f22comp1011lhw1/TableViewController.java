package com.example.f22comp1011lhw1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        //connect the columns in the TableView with the Beer class
        beerIDColumn.setCellValueFactory(new PropertyValueFactory<>("beerID"));//this will call getBeerID()
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));//this will call getName()
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));//this will call getManufacturer()
        volumeColumn.setCellValueFactory(new PropertyValueFactory<>("volume"));//this will call getVolume()
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));//this will call getBeerID
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("countryCode"));//this will call getCountryCode()
        tableView.getItems().addAll(DBUtility.getBeerFromDB());
    }
}
