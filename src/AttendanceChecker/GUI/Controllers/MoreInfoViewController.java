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

public class MoreInfoViewController implements Initializable {
    @FXML
    public Label selectedStudentName;
    @FXML
    public PieChart absencePieChart;
    @FXML
    public Label selectedStudentMostAbsentDay;
    @FXML
    public Label selectedStudentTotalAbsenceDays;
    @FXML
    public Button closeMoreInfo;
    @FXML
    public Button loadChart;
    @FXML
    public Label selectedStudentPercentageAbsence;

    private StudentManager studentManager;
    private ObservableList<Student> students;
    private StudentModel studentModel;

    public void handleCloseMoreInfo(ActionEvent actionEvent) {
        Stage stage = (Stage) closeMoreInfo.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedStudentName.setText(TeacherLoginViewController.getStudentInfoName());
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Absent", TeacherLoginViewController.getStudentInfoDaysAbsent()),
                        new PieChart.Data("Present", (TeacherLoginViewController.getStudentInfoTotalDays()-TeacherLoginViewController.getStudentInfoDaysAbsent())));
        absencePieChart.setData(pieChartData);
        absencePieChart.setTitle("Absence chart:");
        selectedStudentMostAbsentDay.setText(TeacherLoginViewController.getStudentInfoMostAbsentDay());
        selectedStudentTotalAbsenceDays.setText(String.valueOf(TeacherLoginViewController.getStudentInfoDaysAbsent()));
        selectedStudentPercentageAbsence.setText(TeacherLoginViewController.getStudentInfoPercentageAbsence()+"%");
    }

    public ObservableList<Student> getAllStudents() throws IOException {
        students = studentModel.getAllStudents();
        return students;
    }
}
