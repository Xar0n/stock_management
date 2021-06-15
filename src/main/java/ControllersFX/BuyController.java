package ControllersFX;

import Base.ControllerFX;
import ControllersHIbernate.ManageVIEWRECEVE;
import POJO.Suppliers;
import POJO.VIEW_RECEVE;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BuyController extends ControllerFX {

    @FXML
    private TableView<VIEW_RECEVE> tableBuy;

    @FXML
    private TableColumn<VIEW_RECEVE, Integer> colId;

    @FXML
    private TableColumn<VIEW_RECEVE, String> colName;

    @FXML
    private TableColumn<VIEW_RECEVE, String> colReceiver;

    @FXML
    private TableColumn<VIEW_RECEVE, Integer> colAmount;

    @FXML
    private TableColumn<VIEW_RECEVE, Float> colPrice;

    @FXML
    private TableColumn<VIEW_RECEVE, LocalDate> colDate;

    @FXML
    private TableColumn<VIEW_RECEVE, Boolean> colStatus;

    private static int id;
    private ManageVIEWRECEVE view_receve_model;
    private ObservableList<VIEW_RECEVE> view_receves;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        view_receve_model = new ManageVIEWRECEVE();
        colId.setCellValueFactory(new PropertyValueFactory<VIEW_RECEVE,Integer>("id_receve"));
        colName.setCellValueFactory(new PropertyValueFactory<VIEW_RECEVE,String>("name_prod"));
        colReceiver.setCellValueFactory(new PropertyValueFactory<VIEW_RECEVE,String>("name_recev"));
        colAmount.setCellValueFactory(new PropertyValueFactory<VIEW_RECEVE,Integer>("ammount_rec"));
        colPrice.setCellValueFactory(new PropertyValueFactory<VIEW_RECEVE,Float>("price_in_sale"));
        colDate.setCellValueFactory(new PropertyValueFactory<VIEW_RECEVE,LocalDate>("date_rec"));
        colStatus.setCellValueFactory(new PropertyValueFactory<VIEW_RECEVE,Boolean>("processed"));
        view_receves = view_receve_model.selectByIdStorage(id);
        tableBuy.setItems(view_receves);
    }

    public static void setId(int id) {
        BuyController.id = id;
    }


}
