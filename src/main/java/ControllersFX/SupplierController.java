package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageSuppliers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierController extends ControllerFX {
    @FXML
    private TextField tfName;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField tfAddress;
    private static int id;
    private static InterfaceController interfaceController;
    private ManageSuppliers suppliers_model;

    @FXML
    void add(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        suppliers_model.addSuppliers(name, address);
        interfaceController.updateTableSuppliers();
    }

    @FXML
    void edit(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suppliers_model = new ManageSuppliers();
    }

    public static void setId(int id) {
        SupplierController.id = id;
    }

    public static void setController(InterfaceController interfaceController) {
        SupplierController.interfaceController = interfaceController;
    }

}
