package Model;

import DataStracture.Document;
import DataStracture.Tag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SearchTagsModel implements ISearchTagsModel{


    @Override
    public List<Document> getRelevantDocuments(List<Tag> tags) {
        ObservableList list = FXCollections.observableList(tags);
        return list;
    }
}
