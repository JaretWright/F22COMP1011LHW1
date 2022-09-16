package com.example.f22comp1011lhw1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.TreeMap;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Product product = new Product("foofoo","Molsons","tasty stuff",1.00);
        product.setName("Canadian");

        TreeMap bottleTypes = Beer.getBottleTypes();
        System.out.println("Types of bottles: " + bottleTypes.keySet());
        System.out.println("volumes: " + bottleTypes.values());
        System.out.println(bottleTypes);
        System.out.println("Volume in a tall can: "+bottleTypes.get("tall can"));


        launch();
    }
}