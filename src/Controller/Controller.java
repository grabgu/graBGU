package Controller;

import DataStracture.Document;
import DataStracture.ShowQueryResult;
import DataStracture.Tag;
import Model.ISearchTagsModel;
import ViewControllers.ISearchController;
import ViewControllers.IView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

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

    public void setiSearchController(ISearchController searchController){
        this.iSearchController = searchController;
    }

    public ObservableList<ShowQueryResult> getRelevantDocument(){
        List<Document> docs = model.getRelevantDocument(iSearchController.getRelevantTagsList(),iSearchController.getRelevantCoursesList(),iSearchController.getRelevantYearsList(),iSearchController.getRelevantDepartmentsList());
        ObservableList<ShowQueryResult> result = FXCollections.observableList(new ArrayList<ShowQueryResult>());
        for (Document doc : docs){
            result.add(new ShowQueryResult(doc));
        }
        return result;
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
