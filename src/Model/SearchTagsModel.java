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

    public void setController(Controller controller){
        this.controller = controller;
    }

    @Override
    public List<String> getAllCourses() {

        String sql = "SELECT Course From Documents ";
        List<Integer> allCourses= new ArrayList<>();
        try (Connection conn = con.getSQLLiteDBConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                allCourses.add(rs.getInt("TagID"));
            }




        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public List<String> getAllDepartments() {
        return null;
    }

    @Override
    public List<String> getAllTags() {
        return null;
    }

    @Override
    public List<String> getAllYears() {
        return null;
    }

    private DBConnection con;

    @Override
    public List<Document> getRelevantDocuments(List<Tag> tags) {
        List<Integer> TagIDList= new ArrayList<>();
        for (Tag tag: tags) {
            TagIDList.add(getTagID(tag.getName()));
        }
        List<Integer> DocIDList = new ArrayList<>();
        for (int TagID: TagIDList){
            DocIDList.add(getDocumentID(TagID));
        }

        List<Document> Documents = new ArrayList<>();
        for (int DocID: TagIDList){
            Documents.add(getDocument(DocID));
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
