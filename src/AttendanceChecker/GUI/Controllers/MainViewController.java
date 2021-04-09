package AttendanceChecker.GUI.Controllers;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initClock();
    }

    private void initClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - HH:mm:ss");
            currentDate.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void handleConfirmAttendance(ActionEvent actionEvent) {
        try {
            URL url = new File("src/AttendanceChecker/GUI/Views/MoreInfoViewController.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Correct Attendance Error");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            loginIdField.clear();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
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
}
