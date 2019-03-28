package ViewControllers;

import Controller.Controller;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LogInController implements IView{
    public Button btn_open;
    private Controller controller;
    private Stage primaryStage;
    public TextField txtfld_username;
    public TextField txtfld_password;

    @Override
    public void setCurrentStage(Stage primaryStage){
        this.primaryStage=primaryStage;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void handleLogIn() {
        //CHECK IF USER EXISTS

        //IF USER EXISTS
        //GO TO SEARCH WINDOW
        FXMLLoader loader = new FXMLLoader();

        try {
            Parent root = loader.load(getClass().getClassLoader().getResource("SearchWindow.fxml").openStream());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("GraBGU Search");
            stage.setResizable(false);
            this.primaryStage.hide();
            StageHolder.getInstance().holdStage(stage);
            SearchController searchController = loader.getController();
            controller.setiSearchController(searchController);
            searchController.setController(controller);
            searchController.initializeComboBox();
            stage.showAndWait();
        } catch (IOException e) {
            e.getCause();
            e.printStackTrace();
        }
    }

}
