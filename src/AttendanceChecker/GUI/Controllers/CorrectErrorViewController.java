package AttendanceChecker.GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CorrectErrorViewController implements Initializable {

    @FXML
    public BorderPane correctErrorPane;
    @FXML
    public Button cancelCorrectDate;
    @FXML
    public Button confirmCorrectDate;
    @FXML
    public DatePicker correctDateSelect;
    @FXML
    public TextField correctStudentId;

    @FXML
    private BackgroundImage background = new BackgroundImage(new Image("AttendanceChecker/Resources/Background.png",
            800,600,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void handleConfirmCorrectDate(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("");
        alert.setContentText("You attendance has been marked.");
        alert.showAndWait();
        Stage stage = (Stage) confirmCorrectDate.getScene().getWindow();
        stage.close();
    }

    public void handleCancelCorrectDate(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelCorrectDate.getScene().getWindow();
        stage.close();
    }
}
