package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageRecevier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceiverController extends ControllerFX {
    @FXML
    private TextField tfName;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField tfAddress;
    private static int id;
    private static InterfaceController interfaceController;
    private ManageRecevier recevier_model;

    @FXML
    void add(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        recevier_model.addRecevier(name, address);
        interfaceController.updateTableReceivers();
    }

    @FXML
    void edit(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recevier_model = new ManageRecevier();
    }

    public static void setId(int id) {
        ReceiverController.id = id;
    }

    public static void setController(InterfaceController interfaceController) {
        ReceiverController.interfaceController = interfaceController;
    }
}
