module di.portafolioud6joel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens di.portafolioud6joel to javafx.fxml;
    exports di.portafolioud6joel;
}