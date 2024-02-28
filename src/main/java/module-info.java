module com.example.portafolioud6joel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.portafolioud6joel to javafx.fxml;
    exports com.example.portafolioud6joel;
}