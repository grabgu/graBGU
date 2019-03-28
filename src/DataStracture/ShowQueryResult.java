package DataStracture;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowQueryResult {

    private StringProperty sp_Dipartment;
    private StringProperty sp_Course;
    private StringProperty sp_Type;
    private StringProperty sp_Year;
    private StringProperty sp_Lectuarer;
    private StringProperty sp_docLink;


    ShowQueryResult(String docInfo) {
        String [] docInfos= new String [6];
        sp_Dipartment = new SimpleStringProperty(docInfos[0]);
        sp_Course = new SimpleStringProperty(docInfos[1]);
        sp_Type = new SimpleStringProperty(docInfos[2]);
        sp_Year = new SimpleStringProperty(docInfos[3]);
        sp_Lectuarer = new SimpleStringProperty(docInfos[4]);
        sp_docLink = new SimpleStringProperty(docInfos[5]);
    }

    public StringProperty getDipartmentProperty() {
        return sp_Dipartment;
    }


    public StringProperty getCourseProperty() {
        return sp_Course;
    }

    public StringProperty getTypeProperty() {
        return sp_Type;
    }

    public StringProperty getYearProperty() {
        return sp_Year;
    }

    public StringProperty getLectuarerProperty() {
        return sp_Lectuarer;
    }


    public StringProperty sp_docLinkProperty() {
        return sp_docLink;
    }

}
