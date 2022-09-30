package com.example.f22comp1011lhw1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("create-beer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wright Way Beer Co.");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        ArrayList<Manufacturer> manufacturers = DBUtility.getManufacturersFromDB();
        launch();
    }
}