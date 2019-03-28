package Controller;

import DataStracture.Tag;
import Model.ISearchTagsModel;
import ViewControllers.ISearchController;
import ViewControllers.IView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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


    public Object getRelevantDocument(){
        return model.getRelevantDocument(iSearchController.getRelevantTagsList(),iSearchController.getRelevantCoursesList(),iSearchController.getRelevantYearsList(),iSearchController.getRelevantDepartmentsList());
    }


    public ObservableList<String> getAllCourses() {
        return FXCollections.observableList(this.model.getAllCourses());
    }

    public ObservableList<String> getAllDepartments() {
        return FXCollections.observableList(this.model.getAllDepartments());
    }

    public ObservableList<Tag> getAllTags() {
        return FXCollections.observableList(this.model.getAllTags());
    }

    public ObservableList<Integer> getAllYears() {
        return FXCollections.observableList(this.model.getAllYears());
    }
}
