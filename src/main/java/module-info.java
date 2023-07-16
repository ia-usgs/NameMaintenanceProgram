module com.example.namemaintenanceprogram {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.namemaintenanceprogram to javafx.fxml;
    exports com.example.namemaintenanceprogram;
}