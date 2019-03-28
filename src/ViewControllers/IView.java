package ViewControllers;

import Controller.Controller;
import javafx.stage.Stage;

public interface IView {
    void setCurrentStage(Stage primaryStage);

    void setController(Controller controller);
}
