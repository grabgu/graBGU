package DataStracture;

import java.time.Year;
import java.util.Date;

public class Document {
    private int ID;
    private SourceType Type;
    private int Year;
    private String LecturerName;
    private String DepartmentName;
    private String CourseName;
    private String Link;

    public enum SourceType { מבחן,עבודה }


    public Document(int Id,SourceType type, int Year, String lecturerName, String departmentName, String courseName, String link) {
        ID = Id;
        Type = type;
        this.Year = Year;
        LecturerName = lecturerName;
        DepartmentName = departmentName;
        CourseName = courseName;
        Link = link;
    }

    public int getID() {
        return ID;
    }

    public SourceType getType() {
        return Type;
    }

    public void setType(SourceType type) {
        Type = type;
    }

    public int getYear() {
        return Year;
    }

    public void setDate(int Year) {
        this.Year = Year;
    }

    public String getLecturerName() {
        return LecturerName;
    }

    public void setLecturerName(String lecturerName) {
        LecturerName = lecturerName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}


