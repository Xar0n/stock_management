package ControllersFX;

import Base.ControllerFX;
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

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void edit(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static void setId(int id) {
        SupplierController.id = id;
    }


}
