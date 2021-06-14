package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageRecevier;
import ControllersHIbernate.ManageStorage;
import ControllersHIbernate.ManageSuppliers;
import POJO.Recevier;
import POJO.Storage;
import POJO.Suppliers;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class InterfaceController extends ControllerFX {

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
    private TableColumn<Storage, Integer> colIdStorage;

    @FXML
    private TableColumn<Storage, String> colNameStorage;

    @FXML
    private TableColumn<Storage, String> colAddressStorage;

    @FXML
    private TableView<Storage> tableStorage;

    @FXML
    private Button btnEditStorage;

    @FXML
    private Button btnDeleteStorage;

    @FXML
    private Button btnViewBuy;

    @FXML
    private Button btnViewSell;


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
    private ComboBox<String> cbReceiverN;

    @FXML
    private ComboBox<String> cbStorageN;

    @FXML
    private ComboBox<String> cbStorageE;

    @FXML
    private ComboBox<String> cbProductE;

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
    private ComboBox<String> cbStorageSell;

    @FXML
    private ComboBox<String> cbProductSell;

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
    private TableView<Suppliers> tableSupplier;

    @FXML
    private TableColumn<Suppliers, Integer> colIdSupplier;

    @FXML
    private TableColumn<Suppliers, String> colNameSupplier;

    @FXML
    private TableColumn<Suppliers, String> colAddressSupplier;

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
    private TableView<Recevier> tableReceiver;

    @FXML
    private TableColumn<Recevier, Integer> colIdReceiver;

    @FXML
    private TableColumn<Recevier, String> colNameReceiver;

    @FXML
    private TableColumn<Recevier, String> colAddressReceiver;

    @FXML
    private Button btnEditReceiver;

    @FXML
    private Button btnDeleteReceiver;

    private String backgroundColor = "-fx-background-color : #02030A";

    ManageStorage storage_model;
    ManageRecevier receiver_model;
    ManageSuppliers supplier_model;
    ObservableList<Storage> storages;
    ObservableList<Recevier> receivers;
    ObservableList<Suppliers> suppliers;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlMain.setStyle("-fx-background-color : #02030A");
        pnlMain.toFront();
        storage_model = new ManageStorage();
        receiver_model = new ManageRecevier();
        supplier_model = new ManageSuppliers();
        colIdStorage.setCellValueFactory(new PropertyValueFactory<Storage,Integer>("id_storage"));
        colNameStorage.setCellValueFactory(new PropertyValueFactory<Storage, String>("name"));
        colAddressStorage.setCellValueFactory(new PropertyValueFactory<Storage, String>("address"));
        colIdReceiver.setCellValueFactory(new PropertyValueFactory<Recevier,Integer>("id_recevier"));
        colNameReceiver.setCellValueFactory(new PropertyValueFactory<Recevier, String>("name_recev"));
        colAddressReceiver.setCellValueFactory(new PropertyValueFactory<Recevier, String>("address_recev"));
        colIdSupplier.setCellValueFactory(new PropertyValueFactory<Suppliers,Integer>("id_suppliers"));
        colNameSupplier.setCellValueFactory(new PropertyValueFactory<Suppliers, String>("name_sup"));
        colAddressSupplier.setCellValueFactory(new PropertyValueFactory<Suppliers, String>("address_sup"));
    }


    @FXML
    void handleSell(ActionEvent event) {
        if (event.getSource() == btnSell) {
            //cbStorageSell
            //cbProductSell
            //cbSupplierSell
            int count = Integer.parseInt(tfCountSell.getText());
            double price = Double.parseDouble(tfPriceSell.getText());
            LocalDate date = dateSell.getValue();
        }
    }

    @FXML
    void handleBuy(ActionEvent event) {
        if (event.getSource() == btnBuyNew) {
            //cbStorageN
            //cbReceiverN
            String name = tfNameN.getText();
            int count = Integer.parseInt(tfCountPN.getText());
            double price = Double.parseDouble(tfPriceN.getText());
            LocalDate date = dateBuyN.getValue();
        } else if (event.getSource() == btnBuyExist) {
            //cbStorageE
            //cbProductE
            int count = Integer.parseInt(tfCountPE.getText());
            LocalDate date = dateBuyE.getValue();
        }

    }

    //Переключение вкладок и занесение данных в таблицы
    @FXML
    public void handleClicks(ActionEvent event) {
        if (event.getSource() == btnMain) {
            pnlMain.setStyle(backgroundColor);
            pnlMain.toFront();
        } else if (event.getSource() == btnStorage) {
            storages = storage_model.selectAll();
            tableStorage.setItems(storages);
            pnlStorage.setStyle(backgroundColor);
            pnlStorage.toFront();
        } else if (event.getSource() == btnSupplier) {
            suppliers = supplier_model.selectAll();
            tableSupplier.setItems(suppliers);
            pnlSupplier.setStyle(backgroundColor);
            pnlSupplier.toFront();
        } else if (event.getSource() == btnReceiver) {
            receivers = receiver_model.selectAll();
            tableReceiver.setItems(receivers);
            pnlReceiver.setStyle(backgroundColor);
            pnlReceiver.toFront();
        } else if (event.getSource() == btnBuyPage) {
            cbStorageN.valueProperty().set(null);
            cbReceiverN.valueProperty().set(null);
            cbStorageE.valueProperty().set(null);
            cbProductE.valueProperty().set(null);


            pnlBuy.setStyle(backgroundColor);
            pnlBuy.toFront();
        } else if (event.getSource() == btnSellPage) {
            cbStorageSell.valueProperty().set(null);
            cbProductSell.valueProperty().set(null);
            cbSupplierSell.valueProperty().set(null);



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
            StorageController.createWindow(event, "Добавить склад", "/View/Storage/add.fxml", true);
        } else if (event.getSource() == btnAddSupplier) {
            SupplierController.createWindow(event, "Добавить покупателя", "/View/Supplier/add.fxml", true);
        } else if (event.getSource() == btnAddReceiver) {
            ReceiverController.createWindow(event, "Добавить поставщика", "/View/Receiver/add.fxml", true);
        }
    }

    //Удаление записи из таблицы
    @FXML
    void handleDelete(ActionEvent event) {
        if (event.getSource() == btnDeleteStorage) {
            int id = Integer.parseInt(tfIdStorage.getText());
            storage_model.deleteStorage(id);
        } else if (event.getSource() == btnDeleteReceiver) {
            int id = Integer.parseInt(tfIdReceiver.getText());
            receiver_model.deleteRecevier(id);
        } else if (event.getSource() == btnDeleteSupplier) {
            int id = Integer.parseInt(tfIdSupplier.getText());
            supplier_model.deleteSuppliers(id);
        }
    }

    //Редактирование записи в таблице
    @FXML
    void handleEdit(ActionEvent event) {
        if (event.getSource() == btnEditStorage) {
            int id = Integer.parseInt(tfIdStorage.getText());
            StorageController.setId(id);
            StorageController.createWindow(event, "Редактировать склад", "/View/Storage/edit.fxml", true);
        } else if (event.getSource() == btnEditReceiver) {
            int id = Integer.parseInt(tfIdReceiver.getText());
            ReceiverController.setId(id);
            ReceiverController.createWindow(event, "Редактировать поставщика", "/View/Receiver/edit.fxml", true);
        } else if (event.getSource() == btnEditSupplier) {
            int id = Integer.parseInt(tfIdSupplier.getText());
            SupplierController.setId(id);
            SupplierController.createWindow(event, "Редактировать покупателя", "/View/Supplier/edit.fxml", true);
        }
    }

    //Просмотр записи в таблице
    @FXML
    void handleView(ActionEvent event) {
        if (event.getSource() == btnViewStorage) {

        }
    }
}