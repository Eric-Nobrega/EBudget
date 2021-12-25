module com.example.ebudgetv1 {

    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ebudgetv1 to javafx.fxml;
    exports com.example.ebudgetv1;
}