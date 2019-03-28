package ViewControllers;

import Controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.control.CheckComboBox;
import javafx.stage.Stage;
import DataStracture.ShowQueryResult;

import java.util.ArrayList;
import java.util.List;

public class SearchController implements IView{
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

    public void initialize(){
        fillCheckComboBox(ccb_courses,controller.getAllCourses());
        fillCheckComboBox(ccb_departments,controller.getAllDepartments());
        fillCheckComboBox(ccb_tags,controller.getAllTags());
        fillCheckComboBox(ccb_years,controller.getAllYears());

    }

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
        List<String> relevantSelect = new ArrayList<>();
        from.getCheckModel().getCheckedIndices();
        for (Object o: from.getCheckModel().getCheckedIndices()){
            Integer integer = (Integer)o;
            if(integer!=0)
                relevantSelect.add(from.getCheckModel().getItem(integer).toString());
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
