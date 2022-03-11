import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String path = "data/mongo.csv";
        MongoCollection<Document> collection = initDB();
        try {
            addFileToCollection (path, collection);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Oбщее количество студентов в базе: " + collection.countDocuments() + " человек.");
        System.out.println("Имя самого молодого студента: "
                + collection.find().sort(BsonDocument.parse("{age: 1}")).first().get("name"));
        System.out.println("Cписок курсов самого старого студента: "
                + collection.find().sort(BsonDocument.parse("{age: -1}")).first().get("courses"));
        FindIterable<Document> listGreater40 = collection.find(BsonDocument.parse("{age: {$gt: 40}}"));
        System.out.println("Количество студентов старше 40 лет: " + getCountDocuments(listGreater40));



    }

    private static MongoCollection<Document> initDB(){
        MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("Oleg");
        MongoCollection<Document> collection = database.getCollection("students");
        collection.drop();
        return collection;
    }

    private static void addFileToCollection(String path, MongoCollection<Document> collection) throws IOException {
        for (String element : Files.readAllLines(Paths.get(path))) {
            String[] massiveString = element.split(",");
            String name = massiveString[0];
            int age = Integer.parseInt(massiveString[1]);
            List<String> listCourses = Arrays.stream(massiveString).skip(2)
                    .map(e -> e.replace("\"",""))
                    .collect(Collectors.toList());
            Document document = new Document()
                    .append("name", name)
                    .append("age", age)
                    .append("courses", listCourses);
            collection.insertOne(document);
        }
    }

    private static int getCountDocuments(FindIterable<Document> list){
        int count = 0;
        for (Document document : list) {
            count++;
        }
        return count;
    }
}
