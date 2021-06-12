package Controller;

import Base.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private Button btnSupplier;

    @FXML
    private Button btnReceiver;

    @FXML
    private Button btnBuyPage;

    @FXML
    private Button btnSellPage;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlStorage;

    @FXML
    private Pane pnlMain;

    @FXML
    private Pane pnlReceiver;

    @FXML
    private Pane pnlBuy;

    @FXML
    private Pane pnlSell;

    @FXML
    private Pane pnlSupplier;

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


    //Buy
    @FXML
    private TextField tfNameN;

    @FXML
    private TextField tfPriceN;

    @FXML
    private DatePicker dateBuyN;

    @FXML
    private TextField tfCountPN;

    @FXML
    private Button btnBuyNew;

    @FXML
    private ComboBox<?> cbReceiverN;

    @FXML
    private ComboBox<?> cbStorageN;

    @FXML
    private ComboBox<?> cbStorageE;

    @FXML
    private ComboBox<?> cbProductE;

    @FXML
    private TextField tfCountPE;

    @FXML
    private DatePicker dateBuyE;

    @FXML
    private Button btnBuyExist;

    @FXML
    private Pane pnlOrders;


    //Sell
    @FXML
    private ComboBox<?> cbStorageSell;

    @FXML
    private ComboBox<?> cbProductSell;

    @FXML
    private TextField tfCountSell;

    @FXML
    private DatePicker dateSell;

    @FXML
    private Button btnSell;

    @FXML
    private TextField tfPriceSell;

    @FXML
    private ComboBox<?> cbSupplierSell;


    //Supplier
    @FXML
    private TextField tfIdSupplier;

    @FXML
    private Button btnAddSupplier;

    @FXML
    private TableView<?> tableSupplier;

    @FXML
    private TableColumn<?, ?> colIdSupplier;

    @FXML
    private TableColumn<?, ?> colNameSupplier;

    @FXML
    private TableColumn<?, ?> colAddressSupplier;

    @FXML
    private Button btnEditSupplier;

    @FXML
    private Button btnDeleteSupplier;


    //Receiver
    @FXML
    private TextField tfIdReceiver;

    @FXML
    private Button btnAddReceiver;

    @FXML
    private TableView<?> tableReceiver;

    @FXML
    private TableColumn<?, ?> colIdReceiver;

    @FXML
    private TableColumn<?, ?> colNameReceiver;

    @FXML
    private TableColumn<?, ?> colAddressReceiver;

    @FXML
    private Button btnEditReceiver;

    @FXML
    private Button btnDeleteReceiver;

    private String backgroundColor = "-fx-background-color : #02030A";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlMain.setStyle("-fx-background-color : #02030A");
        pnlMain.toFront();
    }


    @FXML
    void handleSell(ActionEvent event) {

    }

    @FXML
    void handleBuy(ActionEvent event) {

    }

    //Переключение вкладок и занесение данных в таблицы
    @FXML
    public void handleClicks(ActionEvent event) {
        if (event.getSource() == btnMain) {
            pnlMain.setStyle(backgroundColor);
            pnlMain.toFront();
        } else if (event.getSource() == btnStorage) {
            pnlStorage.setStyle(backgroundColor);
            pnlStorage.toFront();
        } else if (event.getSource() == btnSupplier) {
            pnlSupplier.setStyle(backgroundColor);
            pnlSupplier.toFront();
        } else if (event.getSource() == btnReceiver) {
            pnlReceiver.setStyle(backgroundColor);
            pnlReceiver.toFront();
        } else if (event.getSource() == btnBuyPage) {
            pnlBuy.setStyle(backgroundColor);
            pnlBuy.toFront();
        } else if (event.getSource() == btnSellPage) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Исключение");
            alert.setContentText("Продажа");
            alert.showAndWait();
            pnlSell.setStyle(backgroundColor);
            pnlSell.toFront();
        } else if (event.getSource() == btnSignout) {
            Stage stage = (Stage) btnSignout.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void handleFind(ActionEvent event) {

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
