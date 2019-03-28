package Model;

import DataStracture.Document;
import DataStracture.Tag;

import java.util.List;

public interface ISearchTagsModel {

    public List<Document> getRelevantDocuments(List<Tag> tags);
}
