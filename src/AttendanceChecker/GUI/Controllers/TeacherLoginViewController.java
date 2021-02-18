package AttendanceChecker.GUI.Controllers;

import AttendanceChecker.BLL.Be.Student;
import AttendanceChecker.BLL.BllClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherLoginViewController implements Initializable {
    private ObservableList<Student> studentObservableList;
    private BllClass bll;
    @FXML
    public Button showInfo;
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


    public TeacherLoginViewController() {
        bll = new BllClass();
        studentList = new TableView<>();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentObservableList = bll.getListOfStudents();
        studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        studentAttendanceColumn.setCellValueFactory(cellData -> cellData.getValue().absentPercentProperty());
        studentDaysAbsentColumn.setCellValueFactory(cellData -> cellData.getValue().totalDaysProperty());
        studentList.setItems(studentObservableList);
    }
    public void handleShowInfo(ActionEvent actionEvent) {

    }

    public void handleLogoutTeacher(ActionEvent actionEvent) {
        Stage stage = (Stage) logoutTeacher.getScene().getWindow();
        stage.close();
    }
}
