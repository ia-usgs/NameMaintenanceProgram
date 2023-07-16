package com.example.namemaintenanceprogram;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class nameMaintenanceController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}