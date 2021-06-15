package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageVIEWRECEVE;
import ControllersHIbernate.ManageVIEWSTORAGENUM;
import ControllersHIbernate.ManageVIEWSUPPLY;
import POJO.VIEW_RECEVE;
import POJO.VIEW_SUPPLY;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SellController extends ControllerFX {
    @FXML
    private TableView<VIEW_SUPPLY> tableBuy;

    @FXML
    private TableColumn<VIEW_SUPPLY, Integer> colId;

    @FXML
    private TableColumn<VIEW_SUPPLY, String> colName;

    @FXML
    private TableColumn<VIEW_SUPPLY, String> colSupplier;

    @FXML
    private TableColumn<VIEW_SUPPLY, Integer> colAmount;

    @FXML
    private TableColumn<VIEW_SUPPLY, Float> colPrice;

    @FXML
    private TableColumn<VIEW_SUPPLY, LocalDate> colDate;

    @FXML
    private TableColumn<VIEW_SUPPLY, Boolean> colStatus;

    private static int id;
    private ManageVIEWSUPPLY view_receve_model;
    private ObservableList<VIEW_SUPPLY> view_receves;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        view_receve_model = new ManageVIEWSUPPLY();
        colId.setCellValueFactory(new PropertyValueFactory<VIEW_SUPPLY,Integer>("id_supply"));
        colName.setCellValueFactory(new PropertyValueFactory<VIEW_SUPPLY,String>("name_prod"));
        colSupplier.setCellValueFactory(new PropertyValueFactory<VIEW_SUPPLY,String>("name_sup"));
        colAmount.setCellValueFactory(new PropertyValueFactory<VIEW_SUPPLY,Integer>("ammount_sup"));
        colPrice.setCellValueFactory(new PropertyValueFactory<VIEW_SUPPLY,Float>("price_in_sup"));
        colDate.setCellValueFactory(new PropertyValueFactory<VIEW_SUPPLY,LocalDate>("date_sup"));
        colStatus.setCellValueFactory(new PropertyValueFactory<VIEW_SUPPLY,Boolean>("processed"));
        view_receves = view_receve_model.selectByIdStorage(id);
        tableBuy.setItems(view_receves);
    }

    public static void setId(int id) {
        SellController.id = id;
    }
}
