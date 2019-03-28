package ViewControllers;

import Controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.control.CheckComboBox;
import javafx.stage.Stage;

public class SearchController implements IView{
    private Controller controller;
    public Button btn_search;
    public CheckComboBox ccb_years;
    public CheckComboBox ccb_courses;
    public CheckComboBox ccb_departments;
    public TableView tv_results;
    public TableColumn tc_lecturer;
    public TableColumn tc_year;
    public TableColumn tc_type;
    public TableColumn tc_course;
    public TableColumn tc_department;
    public CheckComboBox ccb_tegs;



    @Override
    public void setCurrentStage(Stage primaryStage) {

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
