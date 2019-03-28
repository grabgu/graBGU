package Controller;

import Model.ISearchTagsModel;
import ViewControllers.IView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller implements IController{
    ISearchTagsModel model;
    IView view;

    public void setModel(ISearchTagsModel model){
        this.model = model;
    }

    public void setView(IView view){
        this.view = view;
    }


    public void getRelevantDocument(){
        view.getRelevantCourseList();
        view.getRelevantDepartmentsList();
        view.getRelevantTagsList();
        view.getRelevantYearsList();

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
