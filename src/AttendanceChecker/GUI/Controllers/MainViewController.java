package AttendanceChecker.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private BackgroundImage background = new BackgroundImage(new Image("AttendanceChecker/Resources/Background.png",800,600,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    public BorderPane bPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bPane.setBackground(new Background(background));
    }
}
