package ViewControllers;

import Controller.Controller;
import DataStracture.ShowQueryResult;
import javafx.scene.control.Button;
import org.controlsfx.control.CheckComboBox;
import javafx.stage.Stage;

public class SearchController implements IView{
    private Controller controller;
    public Button btn_search;
    public CheckComboBox ccb_years;
    public CheckComboBox ccb_courses;
    public CheckComboBox ccb_departments;
    public CheckComboBox ccb_tags;
    public TableView<ShowQueryResult> tv_results;
    public TableColumn<> tc_lecturer;
    public TableColumn<> tc_year;
    public TableColumn<> tc_type;
    public TableColumn<> tc_course;
    public TableColumn<> tc_department;

    @Override
    public void setCurrentStage(Stage primaryStage) {

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

}
