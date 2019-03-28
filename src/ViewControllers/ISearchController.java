package ViewControllers;

import java.util.List;

public interface ISearchController {

    List<String> getRelevantCourseList();

    List<Integer> getRelevantYearsList();

    List<String> getRelevantTagsList();

    List<String> getRelevantDepartmentsList();

}
