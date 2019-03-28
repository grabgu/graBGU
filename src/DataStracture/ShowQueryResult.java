package DataStracture;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowQueryResult {

    private StringProperty sp_Department;
    private StringProperty sp_Course;
    private StringProperty sp_Type;
    private IntegerProperty sp_Year;
    private StringProperty sp_Lecturer;
    private StringProperty sp_docLink;


    ShowQueryResult(Document doc) {
        sp_Department = new SimpleStringProperty(doc.getDepartmentName());
        sp_Course = new SimpleStringProperty(doc.getCourseName());
        sp_Type = new SimpleStringProperty(doc.getType().toString());
        sp_Year = new SimpleIntegerProperty(doc.getYear());
        sp_Lecturer = new SimpleStringProperty(doc.getLecturerName());
        sp_docLink = new SimpleStringProperty(doc.getLink());
    }

    public StringProperty getDepartmentProperty() {
        return sp_Department;
    }


    public StringProperty getCourseProperty() {
        return sp_Course;
    }

    public StringProperty getTypeProperty() {
        return sp_Type;
    }

    public IntegerProperty getYearProperty() {
        return sp_Year;
    }

    public StringProperty getLecturerProperty() {
        return sp_Lecturer;
    }


    public StringProperty getDocLinkProperty() {
        return sp_docLink;
    }

}
