package Model;

import Controller.Controller;
import DataStracture.Document;
import DataStracture.Tag;

import java.util.List;

public interface ISearchTagsModel {

    List <Document> getRelevantDocument(List<String> tags, List<String> Courses, List<Integer> Years, List<String> Departments);

    void setController(Controller controller);

    List<String> getAllCourses();

    List<String> getAllDepartments();

    List<Tag> getAllTags();

    List<Integer> getAllYears();
}
