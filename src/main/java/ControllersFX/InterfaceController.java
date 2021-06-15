package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.*;
import POJO.Recevier;
import POJO.Storage;
import POJO.Suppliers;
import POJO.Supply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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
    private ComboBox<Recevier> cbReceiverN;

    @FXML
    private ComboBox<Storage> cbStorageN;

    @FXML
    private ComboBox<Storage> cbStorageE;

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
    private ComboBox<Storage> cbStorageSell;

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
    private ComboBox<Suppliers> cbSupplierSell;


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
    ManageReceve receve_model;
    ManageSupply supply_model;
    ManageStorageJor storageJor_model;
    ManageProduct product_model;
    ObservableList<Storage> storages;
    ObservableList<Recevier> receivers;
    ObservableList<Suppliers> suppliers;


    public void updateTableStorage() {
        storages = storage_model.selectAll();
        tableStorage.setItems(storages);
    }

    public void updateTableReceivers() {
        receivers = receiver_model.selectAll();
        tableReceiver.setItems(receivers);
    }

    public void updateTableSuppliers() {
        suppliers = supplier_model.selectAll();
        tableSupplier.setItems(suppliers);
    }
    @FXML
    void choseCbStorageE (ActionEvent event) {

    }

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
        cbStorageN.setConverter(new StringConverter<Storage>() {
            @Override
            public String toString(Storage storage) {
                return storage.getId_storage() + " | " + storage.getName() + " | " + storage.getAddress();
            }

            @Override
            public Storage fromString(String string) {
                return cbStorageN.getItems().stream().filter(ap ->
                        ap.getName().equals(string)).findFirst().orElse(null);
            }
        });
        cbStorageE.setConverter(new StringConverter<Storage>() {
            @Override
            public String toString(Storage storage) {
                return storage.getId_storage() + " | " + storage.getName() + " | " + storage.getAddress();
            }

            @Override
            public Storage fromString(String string) {
                return cbStorageE.getItems().stream().filter(ap ->
                        ap.getName().equals(string)).findFirst().orElse(null);
            }
        });
        cbReceiverN.setConverter(new StringConverter<Recevier>() {
            @Override
            public String toString(Recevier recevier) {
                return recevier.getId_recevier() + " | " + recevier.getName_recev() + " | " + recevier.getAddress_recev();
            }

            @Override
            public Recevier fromString(String string) {
                return cbReceiverN.getItems().stream().filter(ap ->
                        ap.getName_recev().equals(string)).findFirst().orElse(null);
            }
        });
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
            Storage storage = cbStorageN.getSelectionModel().getSelectedItem();
            Recevier recevier = cbReceiverN.getSelectionModel().getSelectedItem();
            String name = tfNameN.getText();
            int count = Integer.parseInt(tfCountPN.getText());
            float price = Float.parseFloat(tfPriceN.getText());
            LocalDate date = dateBuyN.getValue();
            int id_product = product_model.addProduct(name);
            int id_storageJor = storageJor_model.addStorageJor(id_product, storage.getId_storage(), count, price, 0);
            receve_model.addReceve(recevier.getId_recevier(), id_storageJor, count, date, 0);
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
            updateTableStorage();
            pnlStorage.setStyle(backgroundColor);
            pnlStorage.toFront();
        } else if (event.getSource() == btnSupplier) {
            updateTableSuppliers();
            pnlSupplier.setStyle(backgroundColor);
            pnlSupplier.toFront();
        } else if (event.getSource() == btnReceiver) {
            updateTableReceivers();
            pnlReceiver.setStyle(backgroundColor);
            pnlReceiver.toFront();
        } else if (event.getSource() == btnBuyPage) {
            storages = storage_model.selectAll();
            cbStorageN.setItems(storages);
            receivers = receiver_model.selectAll();
            cbReceiverN.setItems(receivers);
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

    //Добавление записи в таблицу
    @FXML
    void handleAdd(ActionEvent event) {
        if (event.getSource() == btnAddStorage) {
            StorageController.setController(this);
            StorageController.createWindow(event, "Добавить склад", "/View/Storage/add.fxml", true);
        } else if (event.getSource() == btnAddSupplier) {
            SupplierController.setController(this);
            SupplierController.createWindow(event, "Добавить покупателя", "/View/Supplier/add.fxml", true);
        } else if (event.getSource() == btnAddReceiver) {
            ReceiverController.setController(this);
            ReceiverController.createWindow(event, "Добавить поставщика", "/View/Receiver/add.fxml", true);
        }
    }

    //Удаление записи из таблицы
    @FXML
    void handleDelete(ActionEvent event) {
        if (event.getSource() == btnDeleteStorage) {
            int id = Integer.parseInt(tfIdStorage.getText());
            storage_model.deleteStorage(id);
            updateTableStorage();
        } else if (event.getSource() == btnDeleteReceiver) {
            int id = Integer.parseInt(tfIdReceiver.getText());
            receiver_model.deleteRecevier(id);
            updateTableReceivers();
        } else if (event.getSource() == btnDeleteSupplier) {
            int id = Integer.parseInt(tfIdSupplier.getText());
            supplier_model.deleteSuppliers(id);
            updateTableSuppliers();
        }
    }

    //Редактирование записи в таблице
    @FXML
    void handleEdit(ActionEvent event) {
        if (event.getSource() == btnEditStorage) {
            int id = Integer.parseInt(tfIdStorage.getText());
            StorageController.setId(id);
            StorageController.setController(this);
            StorageController.createWindow(event, "Редактировать склад", "/View/Storage/edit.fxml", true);
        } else if (event.getSource() == btnEditReceiver) {
            int id = Integer.parseInt(tfIdReceiver.getText());
            ReceiverController.setId(id);
            ReceiverController.setController(this);
            ReceiverController.createWindow(event, "Редактировать поставщика", "/View/Receiver/edit.fxml", true);
        } else if (event.getSource() == btnEditSupplier) {
            int id = Integer.parseInt(tfIdSupplier.getText());
            SupplierController.setId(id);
            SupplierController.setController(this);
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