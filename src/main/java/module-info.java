module org.example.cleanarchitecturejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.cleanarchitecturejavafx to javafx.fxml;
    exports org.example.cleanarchitecturejavafx;
}