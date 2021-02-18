package AttendanceChecker.GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherLoginViewController implements Initializable {
    @FXML
    public Button showInfo;
    @FXML
    public Button logoutTeacher;
    @FXML
    public TableColumn studentNameColumn;
    @FXML
    public TableColumn studentAttendanceColumn;
    @FXML
    public TableColumn studentDaysAbsentColumn;

    public void handleShowInfo(ActionEvent actionEvent) {

    }

    public void handleLogoutTeacher(ActionEvent actionEvent) {
        Stage stage = (Stage) logoutTeacher.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
