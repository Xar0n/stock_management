package Controller;

import Base.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InterfaceController extends Controller {

    //Main
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

    //Storage
    @FXML
    private Button btnViewStorage;

    @FXML
    private TextField tfIdStorage;

    @FXML
    private Button btnAddStorage;

    @FXML
    private TableColumn<?, ?> colIdStorage;

    @FXML
    private TableColumn<?, ?> colNameStorage;

    @FXML
    private TableColumn<?, ?> colAddressStorage;

    @FXML
    private TableView<?> tableStorage;

    @FXML
    private Button btnEditStorage;

    @FXML
    private Button btnDeleteStorage;

    //Product



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlMain.setStyle("-fx-background-color : #02030A");
        pnlMain.toFront();
    }

    //Переключение вкладок и занесение данных в таблицы
    @FXML
    public void handleClicks(ActionEvent event) {
        if (event.getSource() == btnMain) {
            pnlMain.setStyle("-fx-background-color : #02030A");
           pnlMain.toFront();
        }
        if (event.getSource() == btnMenus) {

           pnlMenus.toFront();
        }
        if (event.getSource() == btnStorage) {

            pnlStorage.setStyle("-fx-background-color : #02030A");
            pnlStorage.toFront();
        }
        if (event.getSource() == btnSignout) {
            Stage stage = (Stage) btnSignout.getScene().getWindow();
            stage.close();
        }
    }

    //Поиск записи в таблице
    @FXML
    public void handleFind(ActionEvent event) {

    }

    //Добавление записи в таблицу
    @FXML
    void handleAdd(ActionEvent event) {
        if (event.getSource() == btnAddStorage) {
            StorageController.createWindow(event, "Добавить ", "/View/Storage/add.fxml", true);
        }
    }

    //Удаление записи из таблицы
    @FXML
    void handleDelete(ActionEvent event) {
        if (event.getSource() == btnDeleteStorage) {

        }
    }

    //Редактирование записи в таблице
    @FXML
    void handleEdit(ActionEvent event) {
        if (event.getSource() == btnEditStorage) {

        }
    }

    //Просмотр записи в таблице
    @FXML
    void handleView(ActionEvent event) {
        if (event.getSource() == btnViewStorage) {

        }
    }
}
