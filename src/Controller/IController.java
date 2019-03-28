package Controller;

import DataStracture.Document;
import javafx.collections.ObservableList;

public interface IController {

    ObservableList getAllCourses();
    ObservableList getAllDepartments();
    ObservableList getAllTags();
    ObservableList getAllYears();
    ObservableList<Document> getRelevantDocument();






}
