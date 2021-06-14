package Controller;

import Base.ControllerFX;
import Controllers.ManageStorage;
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

    @FXML
    void add(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        ManageStorage storage_model = new ManageStorage();
        storage_model.addStorage(name, address);
    }

    @FXML
    void edit(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


