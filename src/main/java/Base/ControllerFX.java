package Base;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ControllerFX implements Initializable {
    public static Parent getResource(String resource) throws IOException
    {
        return FXMLLoader.load(ControllerFX.class.getResource(resource));
    }

    public static void createWindow(ActionEvent event, String title, String resource, boolean modal)
    {
        try{
            Stage stage = new Stage();
            Parent root = ControllerFX.getResource(resource);
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            if(modal)
            {
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(
                        ((Node)event.getSource()).getScene().getWindow() );
            }
            stage.show();
        } catch(IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Исключение");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
