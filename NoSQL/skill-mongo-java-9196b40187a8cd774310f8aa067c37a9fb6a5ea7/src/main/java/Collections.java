import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Collections
{

    private List<MongoCollection<Document>> listCollections = new ArrayList<>();

    public void addCollection(MongoCollection<Document> collection){
        listCollections.add(collection);
    }



    public List<MongoCollection<Document>> getListCollections() {
        return listCollections;
    }
}
