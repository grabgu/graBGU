package ViewControllers;

import Controller.Controller;
import javafx.stage.Stage;

public class SearchController implements IView{
    private Controller controller;

    @Override
    public void setCurrentStage(Stage primaryStage) {
        
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
