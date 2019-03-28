package ViewControllers;

import Controller.Controller;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Main instance;

    public static Main getInstance(){
        if (instance ==null)
            instance = new Main();
        return instance;
    }

    public HostServices hostServices = getHostServices();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        primaryStage.setTitle("GraBGU");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getClassLoader().getResource("LogInWindow.fxml").openStream());
        IView logInWindow = fxmlLoader.getController();
        logInWindow.setCurrentStage(primaryStage);
        logInWindow.setController(controller);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
