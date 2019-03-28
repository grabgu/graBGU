package Controller;

import DataStracture.Document;
import DataStracture.ShowQueryResult;
import DataStracture.Tag;
import javafx.collections.ObservableList;

public interface IController {

    ObservableList<String> getAllCourses();
    ObservableList<String> getAllDepartments();
    ObservableList<Tag> getAllTags();
    ObservableList<Integer> getAllYears();
    ObservableList<ShowQueryResult> getRelevantDocument();






}
