package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageSuppliers;
import POJO.Suppliers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierController extends ControllerFX {
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
    private ManageSuppliers suppliers_model;
    private static boolean edit;

    @FXML
    void add(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        suppliers_model.addSuppliers(name, address);
        interfaceController.updateTableSuppliers();
    }

    @FXML
    void edit(ActionEvent event) {
        String name = tfName.getText();
        String address = tfAddress.getText();
        suppliers_model.updateSuppliers(id, name, address);
        interfaceController.updateTableSuppliers();
        Stage stage = (Stage) btnEdit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suppliers_model = new ManageSuppliers();
        if(edit) {
            Suppliers suppliers = suppliers_model.findById(id);
            tfName.setText(suppliers.getName_sup());
            tfAddress.setText(suppliers.getAddress_sup());
            edit = false;
        }
    }

    public static void setId(int id) {
        edit = true;
        SupplierController.id = id;
    }

    public static void setController(InterfaceController interfaceController) {
        SupplierController.interfaceController = interfaceController;
    }

}
