package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InterfaceController implements Initializable {

    @FXML
    private VBox pnItemsStorage = null;
    @FXML
    private Button btnMain;

    @FXML
    private Button btnStorage;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlStorage;

    @FXML
    private Pane pnlMain;

    @FXML
    private Pane pnlMenus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlMain.setStyle("-fx-background-color : #02030A");
        pnlMain.toFront();
    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnMain) {
            pnlMain.setStyle("-fx-background-color : #02030A");
           pnlMain.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {

           pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnStorage) {
            pnItemsStorage.getChildren().clear();
            Node[] nodes = new Node[2];
            for (int i = 0; i < nodes.length; i++) {
                try {

                    final int j = i;
                    nodes[i] = FXMLLoader.load(getClass().getResource("../View/Item.fxml"));

                    //give the items some effect

                    nodes[i].setOnMouseEntered(event -> {
                        nodes[j].setStyle("-fx-background-color : #0A0E3F");
                    });
                    nodes[i].setOnMouseExited(event -> {
                        nodes[j].setStyle("-fx-background-color : #02030A");
                    });
                    pnItemsStorage.getChildren().add(nodes[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            pnlStorage.setStyle("-fx-background-color : #02030A");
            pnlStorage.toFront();
        }
        if (actionEvent.getSource() == btnSignout) {
            Stage stage = (Stage) btnSignout.getScene().getWindow();
            stage.close();
        }

    }
}
