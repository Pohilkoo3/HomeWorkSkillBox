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
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String path = "data/mongo.csv";
        Collections collectionsList = initDB();
        MongoCollection<Document> collectionStudents = collectionsList.getListCollections().get(0);
        MongoCollection<Document> collectionCourses = collectionsList.getListCollections().get(1);
        try {
            addFileToCollection (path, collectionStudents);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] courses ={"Java", "Python", "ios", "Web", "Android"};
        for (String course : courses) {
            Document document = new Document()
                    .append("name", course);
            collectionCourses.insertOne(document);
        }


        BsonDocument bsonDocument = BsonDocument.parse("{age: 1}");
        System.out.println("Oбщее количество студентов в базе: " + collectionStudents.countDocuments() + " человек.");
        System.out.println("Имя самого молодого студента: "
                + collectionStudents.find().sort(bsonDocument).first().get("name"));
        System.out.println("Cписок курсов самого старого студента: "
                + collectionStudents.find().sort(BsonDocument.parse("{age: -1}")).first().get("courses"));
        FindIterable<Document> listGreater40 = collectionStudents.find(BsonDocument.parse("{age: {$gt: 40}}"));
        System.out.println("Количество студентов старше 40 лет: " + getCountDocuments(listGreater40));

        collectionStudents.find((new Document("courses", "Java"))).forEach((Consumer<Document>)System.out::println);



    }

    private static Collections initDB(){
        MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("Oleg");
        Collections collectionsTest = new Collections();
        MongoCollection<Document> collection = database.getCollection("students");
        MongoCollection<Document> collectionCourses = database.getCollection("courses");
        collection.drop();
        collectionCourses.drop();
        collectionsTest.addCollection(collection);
        collectionsTest.addCollection(collectionCourses);
        return collectionsTest;
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
//    private static void addCourses(String[] courses){
//        for (String course : courses) {
//            String name = course;
//            Document document = new Document().append("name":name);
//        }
//    }
}
