package AttendanceChecker.GUI.Controllers;

import AttendanceChecker.Be.Student;
import AttendanceChecker.GUI.Model.StudentModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherLoginViewController implements Initializable {
    
    private ObservableList<Student> studentObservableList;
    private static Student selectedStudent;
    private static String studentInfoName;
    private static String studentInfoMostAbsentDay;
    private static int studentInfoDaysAbsent;
    private static int studentInfoTotalDays;
    private static int studentInfoPercentageAbsence;
    private StudentModel studentModel;

    @FXML
    public ChoiceBox teacherCourseSelect;
    @FXML
    public Button showInfo;
    @FXML
    public Button correctErrorButton;
    @FXML
    public Button logoutTeacher;
    @FXML
    public TableView<Student> studentList;
    @FXML
    public TableColumn<Student, String> studentNameColumn;
    @FXML
    public TableColumn<Student, Integer> studentAttendanceColumn;
    @FXML
    public TableColumn<Student, Integer> studentDaysAbsentColumn;



    public TeacherLoginViewController() throws IOException {
        studentList = new TableView<>();
        studentModel = new StudentModel();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            studentObservableList = studentModel.getAllStudents();
        } catch (IOException e) {
            e.printStackTrace();
        }
        studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        //studentAttendanceColumn.setCellValueFactory(cellData -> cellData.getValue().absentPercentProperty());
        studentDaysAbsentColumn.setCellValueFactory(cellData -> cellData.getValue().absentDaysProperty());
        studentList.setItems(studentObservableList);
    }
    public void handleShowInfo(ActionEvent actionEvent) throws IOException {
        selectedStudent = studentList.getSelectionModel().getSelectedItem();
        studentInfoName = selectedStudent.getName();
        //studentInfoMostAbsentDay = selectedStudent.getMostAbsentDay();
        studentInfoDaysAbsent = selectedStudent.getAbsentDays();
        //studentInfoTotalDays = selectedStudent.getTotalDays();
        //studentInfoPercentageAbsence = selectedStudent.getAbsentPercent();
        if (selectedStudent != null) {
            URL urlMoreInfo = new File("src/AttendanceChecker/GUI/Views/MoreInfoView.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(urlMoreInfo);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("More Student Info");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }

    public static Student getSelectedStudent() {
        return selectedStudent;
    }

    public static String getStudentInfoName() {
        return studentInfoName;
    }

    public static String getStudentInfoMostAbsentDay() {
        return studentInfoMostAbsentDay;
    }

    public static int getStudentInfoDaysAbsent() {
        return studentInfoDaysAbsent;
    }

    public static int getStudentInfoTotalDays() {
        return studentInfoTotalDays;
    }

    public static int getStudentInfoPercentageAbsence() {
        return studentInfoPercentageAbsence;
    }

    public void handleLogoutTeacher(ActionEvent actionEvent) {
        Stage stage = (Stage) logoutTeacher.getScene().getWindow();
        stage.close();
    }

    public void handleCorrectErrorButton(ActionEvent actionEvent) {
        try {
            URL url = new File("src/AttendanceChecker/GUI/Views/CorrectErrorView.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Correct Attendance Error");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
