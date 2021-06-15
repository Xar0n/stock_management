package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageStorage;
import POJO.Storage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class StorageController extends ControllerFX {
    @FXML
    private TextField tfName;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private TextField tfAddress;

    private ManageStorage storage_model;
    private static int id;
    private static InterfaceController interfaceController;
    private static boolean edit;

    @FXML
    void add(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        storage_model.addStorage(name, address);
        interfaceController.updateTableStorage();
    }

    @FXML
    void edit(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        storage_model.updateStorages(id, name, address);
        interfaceController.updateTableStorage();
        Stage stage = (Stage) btnEdit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storage_model = new ManageStorage();
        if(edit) {
            Storage storage = storage_model.findById(id);
            tfName.setText(storage.getName());
            tfAddress.setText(storage.getAddress());
            edit = false;
        }
    }

    public static void setId(int id) {
        edit = true;
        StorageController.id = id;
    }

    public static void setController(InterfaceController interfaceController) {
        StorageController.interfaceController = interfaceController;
    }
}


