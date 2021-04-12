package AttendanceChecker.GUI.Controllers;
import AttendanceChecker.BLL.StudentManager;
import AttendanceChecker.Be.Student;
import AttendanceChecker.GUI.Model.StudentModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    private StudentModel studentModel;
    @FXML
    public Button confirmAttendance;
    @FXML
    public TextField loginIdField;
    @FXML
    public Label currentDate;
    @FXML
    public BorderPane bPane;
    @FXML
    public Label markAttendance;
    @FXML
    public Button teacherLogin;
    @FXML
    public PasswordField passwordField;
    private static String writtenLoginID;
    private static String writtenPassword;
    private static Student selectedStudent;
    private static String studentInfoName;
    private static String studentInfoMostAbsentDay;
    private static int studentInfoDaysAbsent;
    private static int studentInfoTotalDays;
    private static int studentInfoPercentageAbsence;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            studentModel = new StudentModel();
            initClock();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void initClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - HH:mm:ss");
            currentDate.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void handleConfirmAttendance(ActionEvent actionEvent) throws Exception {
        writtenLoginID = loginIdField.getText();
        writtenPassword = passwordField.getText();
        selectedStudent = studentModel.getStudentFromLogin(writtenLoginID,writtenPassword);
        if (selectedStudent != null){
            studentInfoName = studentModel.getStudentFromLogin(writtenLoginID,writtenPassword).getName();
            studentInfoDaysAbsent = studentModel.getStudentFromLogin(writtenLoginID,writtenPassword).getAbsentDays();
            URL urlMoreInfo = new File("src/AttendanceChecker/GUI/Views/StudentView.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(urlMoreInfo);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("More Student Info");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occured");
            alert.setHeaderText("Wrong Login");
            alert.setContentText("Please try again!");
            alert.showAndWait();
            loginIdField.clear();
            passwordField.clear();
        }
    }

    public void handleTeacherLogin(ActionEvent actionEvent) {
        try {
            URL urlTeacher = new File("src/AttendanceChecker/GUI/Views/TeacherLoginView.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(urlTeacher);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Hello Teacher");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
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
}
