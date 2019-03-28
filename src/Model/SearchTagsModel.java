package Model;

import Controller.Controller;
import DataStracture.Document;
import DataStracture.Tag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchTagsModel implements ISearchTagsModel{
    private Controller controller;
    private DBConnection con = new DBConnection();

    public void setController(Controller controller){
        this.controller = controller;
    }

    @Override
    public List<String> getAllCourses() {
        String sql = "SELECT DISTINCT Course From Documents ";
        List<String> allCourses= new ArrayList<>();
        try (Connection conn = con.getSQLLiteDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                allCourses.add(rs.getString("Course"));
            }

        } catch (SQLException e) {
            System.out.println("dsasad");
        }

        return allCourses;
    }

    @Override
    public List<String> getAllDepartments() {

        String sql = "SELECT DISTINCT Department From Documents ";
        List<String> allDepart= new ArrayList<>();
        try (Connection conn = con.getSQLLiteDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                allDepart.add(rs.getString("Department"));
            }

        } catch (SQLException e) {
        }

        return allDepart;
    }

    @Override
    public List<Tag> getAllTags() {
        String sql = "SELECT * From Tags ";
        List<Tag> allTags= new ArrayList<>();
        try (Connection conn = con.getSQLLiteDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            Tag tag;
            while(rs.next()){
                tag = new Tag(rs.getInt("TagID"), rs.getString("TagName"), rs.getString("Discription"));
                allTags.add(tag);
            }
        } catch (SQLException e) {
        }
        return allTags;
    }

    @Override
    public List<Integer> getAllYears() {
        String sql = "SELECT DISTINCT Year  From Documents ";
        List<Integer> allYears = new ArrayList<>();
        try (Connection conn = con.getSQLLiteDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                allYears.add(rs.getInt("Year"));
            }

        } catch (SQLException e) {
        }

        return allYears;
    }


    @Override
    public List<Document> getRelevantDocument(List<String> tags, List<String> Courses, List<Integer> Years, List<String> Departments) {
        List<Integer> TagIDList= new ArrayList<>();
//        for (Tag tag: tags) {
//            TagIDList.add(getTagID(tag.getName()));
//        }
        for (String tag: tags) {
            TagIDList.add(getTagID(tag));
        }
        List<Integer> DocIDList = new ArrayList<>();
        for (int TagID: TagIDList){
            DocIDList.add(getDocumentID(TagID));
        }

        List<Document> Documents = new ArrayList<>();
        for (int DocID: TagIDList){
            Document doc = getDocument(DocID);
            if(Courses.contains(doc.getCourseName())&& Years.contains(doc.getYear()) && Departments.contains(doc.getDepartmentName()))
                Documents.add(doc);
        }

        ObservableList list = FXCollections.observableList(Documents);

        return list;
    }

    private int getDocumentID(int TagID){
            String sql = "SELECT DocumentID From DocumentsTags WHERE TagID=?";
        int docID = -1;
        try (Connection conn = con.getSQLLiteDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,TagID);
            ResultSet rs = pstmt.executeQuery();

            docID=rs.getInt("ID");


        } catch (SQLException e) {
        }
        return docID;
    }

    private int getTagID(String TagName){
        String sql = "SELECT TagID From Tags WHERE Tags.TagName=?" ;
        int TagID = -1;
        try (Connection conn = con.getSQLLiteDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,TagName);
            ResultSet rs = pstmt.executeQuery();
            TagID= rs.getInt("TagID");

        } catch (SQLException e) {
        }
        return TagID;

    }

    private Document getDocument(int DocID){
        String sql = "SELECT * From Documents WHERE Documents.ID = ? ";
        Document document = null;
        try (Connection conn = con.getSQLLiteDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,DocID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                document= new Document(rs.getInt("ID"),Document.SourceType.valueOf(rs.getString("Type")),rs.getInt("Year"),
                        rs.getString("Lecturer"),rs.getString("Department"),rs.getString("Course"),rs.getString("Link"));
            }


        } catch (SQLException e) {
        }
        return document;
    }


}
