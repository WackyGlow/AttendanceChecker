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
    public Label selectedStudentPercentageAbsence;
    private Student selectedStudent;
    private int totalDays;
    private StudentManager studentManager;
    private ObservableList<Student> students;
    private StudentModel studentModel;

    /**
     * handles closing the stage
     * @param actionEvent
     */
    public void handleCloseMoreInfo(ActionEvent actionEvent) {
        Stage stage = (Stage) closeMoreInfo.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            studentModel = new StudentModel();
            totalDays = studentModel.getTotalDays();
            selectedStudent = TeacherLoginViewController.getSelectedStudent();
            selectedStudentName.setText(selectedStudent.getName());
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("Absent", selectedStudent.getAbsentDays()),
                            new PieChart.Data("Present", (totalDays-selectedStudent.getAbsentDays())));
            absencePieChart.setData(pieChartData);
            absencePieChart.setTitle("Absence chart:");
            selectedStudentMostAbsentDay.setText(studentModel.getValueFromDay(selectedStudent));
            selectedStudentTotalAbsenceDays.setText(selectedStudent.getAbsentDays() + "");
            selectedStudentPercentageAbsence.setText(((double)selectedStudent.getAbsentDays()/(double)studentModel.getTotalDays()) * 100 + "%");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
