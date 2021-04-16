package AttendanceChecker.GUI.Controllers;

import AttendanceChecker.Be.Student;
import AttendanceChecker.GUI.Model.StudentModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherLoginViewController implements Initializable {
    
    private ObservableList<Student> studentObservableList;
    private static Student selectedStudent;
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
    public TableColumn<Student, Integer> studentDaysAbsentColumn;
    @FXML
    public TableColumn<Student, Integer> studentAttendanceColumn;




    public TeacherLoginViewController() throws IOException {
        studentList = new TableView<>();
        studentModel = new StudentModel();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            studentObservableList = studentModel.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        studentDaysAbsentColumn.setCellValueFactory(cellData -> cellData.getValue().absentDaysProperty().asObject());
        studentAttendanceColumn.setCellValueFactory(cellData -> {
            int totalDays = 0;
            try {
                totalDays = studentModel.getTotalDays();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            int absentDays = cellData.getValue().absentDaysProperty().getValue();
            ObservableValue<Integer> absentPercent = new SimpleIntegerProperty((absentDays/totalDays) * 100).asObject();
            return absentPercent;
        });
        studentList.setItems(studentObservableList);
    }
    public void handleShowInfo(ActionEvent actionEvent) throws IOException {
        selectedStudent = studentList.getSelectionModel().getSelectedItem();
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
