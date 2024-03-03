module com.hrmanagement_lavanya {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.hrmanagement_lavanya to javafx.fxml;
    exports com.hrmanagement_lavanya;
}