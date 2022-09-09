module com.example.f22comp1011lhw1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f22comp1011lhw1 to javafx.fxml;
    exports com.example.f22comp1011lhw1;
}