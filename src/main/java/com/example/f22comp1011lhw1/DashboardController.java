package com.example.f22comp1011lhw1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private ComboBox<Integer> yearComboBox;

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    private PieChart pieChart;

    @FXML
    void viewTable(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
//        pieChartData.add(new PieChart.Data("Molsons",6581));
//        pieChartData.add(new PieChart.Data("Labbat  s",5906));
//        pieChartData.add(new PieChart.Data("HEINEKEN",6163));
//        pieChartData.add(new PieChart.Data("Double Trouble",13091));
        pieChart.getData().addAll(DBUtility.getUnitsSoldByManufacturer());
        pieChart.setLabelsVisible(false);

        barChart.setLegendVisible(false);


        yearComboBox.getItems().addAll(DBUtility.getSalesYears());
        yearComboBox.valueProperty().addListener((obs, oldValue, newValue)->{
            barChart.getData().clear();
            barChart.getData().addAll(DBUtility.getSalesByYear(newValue));
        });

        yearComboBox.setValue(LocalDate.now().getYear());
    }
}
