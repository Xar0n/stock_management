package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageVIEWRECEVE;
import ControllersHIbernate.ManageVIEWSTORAGENUM;
import POJO.VIEW_RECEVE;
import POJO.VIEW_STORAGE_NUM;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StocksController extends ControllerFX {

    @FXML
    private TableView<VIEW_STORAGE_NUM> tableStock;

    @FXML
    private TableColumn<VIEW_STORAGE_NUM, Integer> colId;

    @FXML
    private TableColumn<VIEW_STORAGE_NUM, String> colName;

    @FXML
    private TableColumn<VIEW_STORAGE_NUM, Integer> colAmount;

    @FXML
    private TableColumn<VIEW_STORAGE_NUM, Float> colPriceBuy;

    @FXML
    private TableColumn<VIEW_STORAGE_NUM, Float> colPriceSell;

    private static int id;
    private ManageVIEWSTORAGENUM view_receve_model;
    private ObservableList<VIEW_STORAGE_NUM> view_storage_nums;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        view_receve_model = new ManageVIEWSTORAGENUM();
        colId.setCellValueFactory(new PropertyValueFactory<VIEW_STORAGE_NUM,Integer>("id_product"));
        colName.setCellValueFactory(new PropertyValueFactory<VIEW_STORAGE_NUM,String>("name_prod"));
        colAmount.setCellValueFactory(new PropertyValueFactory<VIEW_STORAGE_NUM,Integer>("amount"));
        colPriceBuy.setCellValueFactory(new PropertyValueFactory<VIEW_STORAGE_NUM,Float>("price_in_sup"));
        colPriceSell.setCellValueFactory(new PropertyValueFactory<VIEW_STORAGE_NUM,Float>("price_in_sale"));
        view_storage_nums = view_receve_model.selectByIdStorage(id);
        tableStock.setItems(view_storage_nums);
    }

    public static void setId(int id) {
        StocksController.id = id;
    }


}
