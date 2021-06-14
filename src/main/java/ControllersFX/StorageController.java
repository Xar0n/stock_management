package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class StorageController extends ControllerFX {
    @FXML
    private TextField tfName;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField tfAddress;

    private ManageStorage storage_model;
    private static int id;

    @FXML
    void add(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        storage_model.addStorage(name, address);
    }

    @FXML
    void edit(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storage_model = new ManageStorage();
    }

    public static void setId(int id) {
        StorageController.id = id;
    }
}


