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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {
    private Student selectedStudent;
    private StudentModel studentModel;
    private int totalDays;
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
        try {
            studentModel = new StudentModel();
            totalDays = studentModel.getTotalDays();
            selectedStudent = MainViewController.getSelectedStudent();
            selectedStudentName.setText(selectedStudent.getName());
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("Absent", selectedStudent.getAbsentDays()),
                            new PieChart.Data("Present", (totalDays-selectedStudent.getAbsentDays())));
            absencePieChart.setData(pieChartData);
            absencePieChart.setTitle("Absence chart:");
            //Mangler implementering
            selectedStudentMostAbsentDay.setText(selectedStudent.getAbsentDays() + "");
            selectedStudentTotalAbsenceDays.setText(selectedStudent.getAbsentDays() + "");
            selectedStudentPercentageAbsence.setText((selectedStudent.getAbsentDays()/studentModel.getTotalDays()) * 100 + "%");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
