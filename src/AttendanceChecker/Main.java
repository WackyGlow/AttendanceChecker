package AttendanceChecker;

import AttendanceChecker.BLL.RunnableTimeManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    /**
     * Creates the application window.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        RunnableTimeManager rTM = new RunnableTimeManager();
        Thread thread = new Thread(rTM);
        thread.start();
        Parent root = FXMLLoader.load(getClass().getResource("GUI/Views/MainView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    /**
     * Launches the program.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
