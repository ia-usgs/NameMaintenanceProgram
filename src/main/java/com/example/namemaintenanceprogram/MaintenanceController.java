package com.example.namemaintenanceprogram;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

public class MaintenanceController {
    @FXML
    private ComboBox<String> comboBoxButton;

    @FXML
    private TextField nameTextField;
    private List<String> originalNames;
    @FXML
    private void loadNames() {
        try {
            originalNames = Files.readAllLines(Paths.get("names.txt")); // I am using this list on the root part to read the names
            comboBoxButton.getItems().addAll(originalNames);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error reading your file.");
            alert.showAndWait();
        }
    }
    @FXML
    private void addName() {
        String newName = nameTextField.getText();
        if (!newName.isEmpty()) {
            comboBoxButton.getItems().add(newName);
            nameTextField.clear();
        }
    }
    @FXML
    private void removeName() {
        String selectedName = comboBoxButton.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            comboBoxButton.getItems().remove(selectedName);
        }
    }
    @FXML
    private void selectName() {
        String selectedName = comboBoxButton.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("You have selected: " + selectedName);
            alert.showAndWait();
        }
    }
    @FXML
    private void resetNames() {
        comboBoxButton.getItems().clear();
        comboBoxButton.getItems().addAll(originalNames);
    }
    @FXML
    private void exitProgram() {
        Stage stage = (Stage) comboBoxButton.getScene().getWindow();
        stage.close();
    }
}