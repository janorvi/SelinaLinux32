module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires okhttp3;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires com.google.gson;
    requires kotlinx.coroutines.core.jvm;
    opens org.example;
    exports org.example;
}