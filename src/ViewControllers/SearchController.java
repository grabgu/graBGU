package ViewControllers;

import Controller.Controller;
import DataStracture.Document;
import DataStracture.Tag;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;
import javafx.stage.Stage;
import DataStracture.ShowQueryResult;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchController implements IView, ISearchController, Initializable {
    public TextField txtfld_tags;
    private Controller controller;
    public Button btn_search;
    public CheckComboBox ccb_years;
    public CheckComboBox ccb_courses;
    public CheckComboBox ccb_departments;
    //public CheckComboBox ccb_tags;
    public TableView<ShowQueryResult> tv_results;
    public TableColumn<ShowQueryResult,String> tc_lecturer;
    public TableColumn<ShowQueryResult, Number> tc_year;
    public TableColumn<ShowQueryResult, String> tc_type;
    public TableColumn<ShowQueryResult,String> tc_course;
    public TableColumn<ShowQueryResult,String> tc_department;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        tv_results.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Main.getInstance().getHostServices().showDocument(getClass().getClassLoader().getResource(tv_results.getSelectionModel().getSelectedItem().getDocLinkProperty().toString()).getPath());
                }
            }
        });


    }

    public void initializeComboBox(){
        fillCheckComboBox(ccb_courses,controller.getAllCourses());
        fillCheckComboBox(ccb_departments,controller.getAllDepartments());
        //fillCheckComboBox(ccb_tags,controller.getAllTags());
        fillCheckComboBox(ccb_years,controller.getAllYears());
        txtfld_tags.setEditable(true);
        TextFields.bindAutoCompletion(txtfld_tags,new String[]{"Tal","Alon","Dani"}/*controller.getAllTags()*/);
        //txtfld_tags.
    }

    public List<String> getRelevantCoursesList() {
        return getSelected(ccb_courses);
    }

    public List<Integer> getRelevantYearsList(){return getSelected(ccb_years);}

    public List<Tag> getRelevantTagsList(){
        return null;
        /*return getSelected(ccb_tags);*/
    }

    public List<String> getRelevantDepartmentsList(){return getSelected(ccb_departments);}

    private void fillCheckComboBox(CheckComboBox toFill, ObservableList list){
        ArrayList<String> all = new ArrayList<>();
        all.add("All");
        ObservableList allos = FXCollections.observableArrayList(all);
        allos.sort(String.CASE_INSENSITIVE_ORDER);
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

    private void showQueryResults(ObservableList<ShowQueryResult> results) {
        if(results != null){
            tc_department.setCellValueFactory(cellData -> cellData.getValue().getDepartmentProperty());
            tc_course.setCellValueFactory(cellData -> cellData.getValue().getCourseProperty());
            tc_lecturer.setCellValueFactory(cellData -> cellData.getValue().getLecturerProperty());
            tc_type.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
            tc_year.setCellValueFactory(cellData -> cellData.getValue().getYearProperty());
            tv_results.setItems(results);
        }
    }

    @Override
    public void setCurrentStage(Stage primaryStage) {

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void handleSearch() {
        ObservableList<ShowQueryResult> relevantDocuments = controller.getRelevantDocument();
        showQueryResults(relevantDocuments);
    }
}
