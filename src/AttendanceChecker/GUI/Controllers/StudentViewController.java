package AttendanceChecker.GUI.Controllers;

import AttendanceChecker.BLL.StudentManager;
import AttendanceChecker.Be.Student;
import AttendanceChecker.GUI.Model.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {
    private Student selectedStudent;
    @FXML
    public Label selectedStudentName;
    @FXML
    public PieChart absencePieChart;
    @FXML
    public Label selectedStudentMostAbsentDay;
    @FXML
    public Label selectedStudentTotalAbsenceDays;
    @FXML
    public Button closeStudentInfo;
    @FXML
    public Label selectedStudentPercentageAbsence;

    public void handleCloseStudentInfo(ActionEvent actionEvent) {
        Stage stage = (Stage) closeStudentInfo.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedStudent = MainViewController.getSelectedStudent();
        selectedStudentName.setText(selectedStudent.getName());
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Absent", selectedStudent.getAbsentDays()),
                        // (Total Days - Days Absent) skal stå herunder i stedet for 100
                        new PieChart.Data("Present", (100-selectedStudent.getAbsentDays())));
        absencePieChart.setData(pieChartData);
        absencePieChart.setTitle("Absence chart:");
        selectedStudentMostAbsentDay.setText(selectedStudent.getAbsentDays() + "");
        selectedStudentTotalAbsenceDays.setText(selectedStudent.getAbsentDays() + "");
        selectedStudentPercentageAbsence.setText(selectedStudent.getAbsentDays() +"%");
    }
}