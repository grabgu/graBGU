package ViewControllers;

import java.util.List;

public interface ISearchController {

    List<String> getRelevantCoursesList();

    List<Integer> getRelevantYearsList();

    List<String> getRelevantTagsList();

    List<String> getRelevantDepartmentsList();

    void initializeComboBox();

}
