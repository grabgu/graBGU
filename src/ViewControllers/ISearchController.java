package ViewControllers;

import DataStracture.Tag;

import java.util.List;

public interface ISearchController {

    List<String> getRelevantCoursesList();

    List<Integer> getRelevantYearsList();

    List<Tag> getRelevantTagsList();

    List<String> getRelevantDepartmentsList();

}
