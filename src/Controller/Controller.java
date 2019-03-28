package Controller;

import Model.ISearchTagsModel;
import ViewControllers.ISearchController;
import ViewControllers.IView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.chrono.IsoChronology;

public class Controller {
    ISearchTagsModel model;
    IView view;
    ISearchController iSearchController;

    public void setModel(ISearchTagsModel model){
        this.model = model;
    }

    public void setView(IView view){
        this.view = view;
    }


    public void getRelevantDocument(){
        iSearchController.getRelevantCourseList();
        iSearchController.getRelevantCourseList();
        iSearchController.getRelevantCourseList();
        iSearchController.getRelevantCourseList();
    }


    public ObservableList getAllCourses() {
        return FXCollections.observableList(this.model.getAllCourses());
    }

    public ObservableList getAllDepartments() {
        return FXCollections.observableList(this.model.getAllDepartments());
    }

    public ObservableList getAllTags() {
        return FXCollections.observableList(this.model.getAllTags());
    }

    public ObservableList getAllYears() {
        return FXCollections.observableList(this.model.getAllYears());
    }
}
