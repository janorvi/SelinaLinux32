module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires okhttp;
    requires java.net.http;
    requires jackson.databind;
    opens org.example;
    exports org.example;
}