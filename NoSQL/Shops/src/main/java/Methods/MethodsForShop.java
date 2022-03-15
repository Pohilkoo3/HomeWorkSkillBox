package Methods;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.BsonDocument;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.mongodb.client.model.Aggregates.out;
import static com.mongodb.client.model.Aggregates.sort;

public class MethodsForShop
{
    private final MongoDatabase database;
    private MongoCollection collectionShops;
    private MongoCollection collectionGoods;

    public MethodsForShop(MongoDatabase database, MongoCollection collectionShops, MongoCollection collectionGoods) {
        this.database = database;
        this.collectionShops = collectionShops;
        this.collectionGoods = collectionGoods;
    }

    public void switchShop(String command){
        String name = command.replaceAll("ПОДКЛЮЧИТЬ_МАГАЗИН", "").trim();
        collectionShops = database.getCollection(name);
    }

    public void printStatisticGoodsAtShop(){
        FindIterable<Document> listGoodsInShop = collectionShops.find();
        int sum = 0;

       List<Document> goods = new ArrayList<>();
        for (Document element : listGoodsInShop) {
            String name = element.get("name").toString();
          Document document = getGoodByName(name);
            goods.add(document);
        }

        System.out.println("Oбщее количество наименований товаров в каталоге " + goods.size()
                + " шт.");
        System.out.println("Количество товаров меньше 100 руб.: " +
                goods.stream().filter((e) -> ((int)(e.get("price")) <= 100)).count());
        System.out.println("Средняя цена товара = " + goods.stream().mapToInt(e -> (int)(e.get("price"))).average() + " руб./шт.");

        Document documentMaxPrice = goods.stream().max(Comparator.comparing(e -> e.getInteger("price"))).get();
        Document documentMinPrice = goods.stream().min(Comparator.comparing(e -> e.getInteger("price"))).get();
        System.out.println("Самый дешевый товар: " + documentMinPrice.get("name")
                + " => " + documentMinPrice.get("price") + " руб.");
        System.out.println("Самый дорогой товар: " + documentMaxPrice.get("name")
                + " => " + documentMaxPrice.get("price") + " руб.");

    }

    public Document getGoodByName(String command){
        String name = command.replaceAll("ПОЛУЧИТЬ_ТОВАР", "").trim();
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);
        return (Document) collectionGoods.find(searchQuery).first();

    }

    public void addGoods(String command){
        String addGood = command.replaceAll("ДОБАВИТЬ_ТОВАР", "").trim();
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(addGood);
        matcher.find();
        int priceGood = Integer.parseInt(matcher.group(0));
        String nameGood = addGood.replaceAll("\\d", "").trim();
        Document document = new Document()
                .append("name", nameGood)
                .append("price", priceGood);
        collectionGoods.insertOne(document);
        System.out.println("Товар добавлен.");
    }

    public void deleteShop(String command) {
        String nameShop = command.replaceAll("УДАЛИТЬ_МАГАЗИН", "").trim();
        MongoCollection collection = database.getCollection(nameShop);
        collection.drop();
        System.out.println("Магазин успешно удален.");
    }

    public void addShop(String command) {
        String nameShop = command.replaceAll("ДОБАВИТЬ_МАГАЗИН", "").trim();
        database.createCollection(nameShop);
        MongoCollection collection = database.getCollection(nameShop);
        System.out.println("Магазин успешно добавлен." + collection.getNamespace());
    }

    public void putGoodsInShop(String command){
        String addGood = command.replaceAll("ВЫСТАВИТЬ_ТОВАР", "").trim();
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(addGood);
        matcher.find();
        int amountGood = Integer.parseInt(matcher.group(0));
        String nameGood = addGood.replaceAll("\\d", "").trim();
        Document document = new Document()
                .append("name", nameGood)
                .append("amount", amountGood);
        collectionShops.insertOne(document);
        System.out.println("Товар выставлен.");
    }

    public void printStatisticGoods(){
        collectionGoods.aggregate(Arrays.asList(
                sort(Sorts.descending("price")),
                out("sorted_Goods"))).toCollection();
        MongoCollection sortedGoods = database.getCollection("sorted_Goods");
        int amountGoods = (int) collectionGoods.countDocuments();
        Document documentMinPrice = (Document) sortedGoods.find().first();
        Document documentMaxPrice = (Document) sortedGoods.find().skip((int) (sortedGoods.countDocuments() - 1)).first();

        System.out.println("Oбщее количество наименований товаров в каталоге " + amountGoods
                + " шт.");

        System.out.println("Самый дешевый товар: " + documentMinPrice.get("name")
                + " => " + documentMinPrice.get("price") + " руб.");
        System.out.println("Самый дорогой товар: " + documentMaxPrice.get("name")
                + " => " + documentMaxPrice.get("price") + " руб.");
        FindIterable<Document> listGoodsLess100RUB = collectionGoods.find(BsonDocument.parse("{price: {$lt: 100}}"));
        System.out.println("Количество товаров меньше 100 руб.: " + getCountDocuments(listGoodsLess100RUB) + " шт.");
        FindIterable<Document> listGoods = collectionGoods.find();
        int sum = 0;
        for (Document good : listGoods) {
            sum += (int) good.get("price");
        }
        System.out.println("Средняя цена товара = " + sum / amountGoods + " руб./шт.");

    }

    private static int getCountDocuments(FindIterable<Document> list){
        int count = 0;
        for (Document document : list) {
            count++;
        }
        return count;
    }

}
