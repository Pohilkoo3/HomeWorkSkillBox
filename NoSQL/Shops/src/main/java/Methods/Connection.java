package Methods;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection
{
    private MongoDatabase database;
    private MongoCollection collectionGoods;
    private MongoCollection collectionShops;

    public Connection() {
        initDB();
    }

    public void initDB(){
        MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
        database = mongoClient.getDatabase("Shop");
        collectionGoods = database.getCollection("Товары");
        collectionShops = database.getCollection("Test");
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection getCollectionGoods() {
        return collectionGoods;
    }

    public MongoCollection getCollectionShops() {
        return collectionShops;
    }
}
