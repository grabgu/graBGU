package ViewControllers;

import Controller.Controller;
import javafx.stage.Stage;

import java.util.List;

public interface IView {
    void setCurrentStage(Stage primaryStage);

    void setController(Controller controller);

}
