package ViewControllers;

import Controller.Controller;
import DataStracture.Tag;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;
import javafx.stage.Stage;
import DataStracture.ShowQueryResult;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchController implements IView, ISearchController, Initializable {
    private final String resourcesPath = "\\";
    private Controller controller;
    public Button btn_search;
    public CheckComboBox ccb_years;
    public CheckComboBox ccb_courses;
    public CheckComboBox ccb_departments;
    public CheckComboBox ccb_tags;
    public TableView<ShowQueryResult> tv_results;
    public TableColumn<ShowQueryResult,String> tc_lecturer;
    public TableColumn<ShowQueryResult,Integer> tc_year;
    public TableColumn<ShowQueryResult,Integer> tc_type;
    public TableColumn<ShowQueryResult,String> tc_course;
    public TableColumn<ShowQueryResult,String> tc_department;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        fillCheckComboBox(ccb_courses,controller.getAllCourses());
        fillCheckComboBox(ccb_departments,controller.getAllDepartments());
        fillCheckComboBox(ccb_tags,controller.getAllTags());
        fillCheckComboBox(ccb_years,controller.getAllYears());
        tv_results.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Main.getInstance().getHostServices().showDocument(getClass().getClassLoader().getResource(tv_results.getSelectionModel().getSelectedItem().getDocLinkProperty().toString()).getPath());
                }
            }
        });
    }

    public List<String> getRelevantCoursesList() {
        return getSelected(ccb_courses);
    }

    public List<Integer> getRelevantYearsList(){return getSelected(ccb_years);}

    public List<Tag> getRelevantTagsList(){return getSelected(ccb_tags);}

    public List<String> getRelevantDepartmentsList(){return getSelected(ccb_departments);}

    private void fillCheckComboBox(CheckComboBox toFill, ObservableList list){
        ArrayList<String> all = new ArrayList<>();
        all.add("All");
        ObservableList allos = FXCollections.observableArrayList(all);
        list.sort(String.CASE_INSENSITIVE_ORDER);
        toFill.getItems().addAll(allos);
        toFill.getItems().addAll(list);
        toFill.getItemBooleanProperty(0).addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (oldValue)
                    toFill.getCheckModel().clearChecks();
                else
                    toFill.getCheckModel().checkAll();
            }
        });
    }

    public List getSelected(CheckComboBox from){
        List relevantSelect = new ArrayList<>();
        from.getCheckModel().getCheckedIndices();
        for (Object o: from.getCheckModel().getCheckedIndices()){
            Integer integer = (Integer)o;
            if(integer!=0)
                relevantSelect.add(from.getCheckModel().getItem(integer));
        }
        return relevantSelect;
    }

    @Override
    public void setCurrentStage(Stage primaryStage) {

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

}
