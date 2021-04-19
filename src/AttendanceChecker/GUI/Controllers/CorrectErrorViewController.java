package AttendanceChecker.GUI.Controllers;

import AttendanceChecker.BLL.AttendanceManager;
import AttendanceChecker.Be.Student;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class CorrectErrorViewController implements Initializable {

    @FXML
    private Button cancelCorrectDate;
    @FXML
    private Button confirmCorrectDate;
    @FXML
    private DatePicker correctDateSelect;

    private LocalDate selectedDate;
    private AttendanceManager attendanceManager;
    private Student selectedStudent;
    private String day;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            attendanceManager = new AttendanceManager();
            selectedStudent = TeacherLoginViewController.getSelectedStudent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleConfirmCorrectDate(ActionEvent actionEvent) throws SQLException {
        selectedDate = correctDateSelect.getValue();
        day = attendanceManager.localDateToDayOfWeek(selectedDate);
        if (day != null) {
            attendanceManager.removefromAbsentDays(selectedStudent);
            attendanceManager.removeFromMostDayAbsentDay(selectedStudent,day);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("");
            alert.setContentText("You attendance has been marked.");
            alert.showAndWait();
            Stage stage = (Stage) confirmCorrectDate.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("Please select a valid date.");
            alert.showAndWait();
        }
    }

    public void handleCancelCorrectDate(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelCorrectDate.getScene().getWindow();
        stage.close();
    }
}
