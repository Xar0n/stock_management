package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageRecevier;
import POJO.Recevier;
import POJO.Suppliers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceiverController extends ControllerFX {
    @FXML
    private TextField tfName;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private TextField tfAddress;
    private static int id;
    private static InterfaceController interfaceController;
    private ManageRecevier recevier_model;
    private static boolean edit;

    @FXML
    void add(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        recevier_model.addRecevier(name, address);
        interfaceController.updateTableReceivers();
    }

    @FXML
    void edit(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        recevier_model.updateRecevier(id, name, address);
        interfaceController.updateTableReceivers();
        Stage stage = (Stage) btnEdit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recevier_model = new ManageRecevier();
        if(edit) {
            Recevier recevier = recevier_model.findById(id);
            tfName.setText(recevier.getName_recev());
            tfAddress.setText(recevier.getAddress_recev());
            edit = false;
        }
    }

    public static void setId(int id) {
        edit = true;
        ReceiverController.id = id;
    }

    public static void setController(InterfaceController interfaceController) {
        ReceiverController.interfaceController = interfaceController;
    }
}
