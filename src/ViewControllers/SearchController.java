package ViewControllers;

import Controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;
import javafx.stage.Stage;
import DataStracture.ShowQueryResult;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class SearchController implements IView, ISearchController, Initializable {

    public ListView<CheckBox> lv_checkedtags;
    private Controller controller;

    public TextField txtfld_tags;
    public Button btn_search;
    public CheckComboBox ccb_years;
    public CheckComboBox ccb_courses;
    public CheckComboBox ccb_departments;
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
                    Main.getInstance().getHostServices().showDocument(getClass().getClassLoader().getResource(tv_results.getSelectionModel().getSelectedItem().getDocLinkProperty().getValue()).getPath());
                }
            }
        });
    }

    public void initializeComboBox(){
        fillCheckComboBox(ccb_courses,controller.getAllCourses());
        fillCheckComboBox(ccb_departments,controller.getAllDepartments());
        fillCheckComboBox(ccb_years,controller.getAllYears());
        txtfld_tags.setEditable(true);
        TextFields.bindAutoCompletion(txtfld_tags,controller.getAllTags())
                .setOnAutoCompleted(event -> updateTextArea());
    }

    private void updateTextArea() {

        boolean toAdd = true;
        for (int i = 0; i< lv_checkedtags.getItems().size() && toAdd; i++){
            toAdd = !(lv_checkedtags.getItems().get(i).getText().equals(txtfld_tags.getText()));
        }
        if (toAdd) {
            CheckBox cb = new CheckBox(txtfld_tags.getText());
            cb.setSelected(true);
            lv_checkedtags.getItems().add(cb);
            cb.selectedProperty().addListener((observable, oldValue, newValue) -> {
                lv_checkedtags.getItems().remove(cb);
            });
        }
        txtfld_tags.clear();
    }

    public List<String> getRelevantCoursesList() {
        return getSelected(ccb_courses);
    }

    public List<Integer> getRelevantYearsList(){return getSelected(ccb_years);}

    public List<String> getRelevantTagsList(){
        List<String> currentSearch = new ArrayList<>();
        for (CheckBox cb : lv_checkedtags.getItems())
            currentSearch.add(cb.toString());
        return currentSearch;
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
                else {
                    toFill.getCheckModel().checkAll();
                    toFill.setStyle("color: red;");
                }

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
        lv_checkedtags.getItems().clear();
    }
}
