package Model;

import Controller.Controller;
import DataStracture.Document;
import DataStracture.Tag;

import java.util.List;

public interface ISearchTagsModel {

    List<Document> getRelevantDocuments(List<Tag> tags);


    void setController(Controller controller);
}
