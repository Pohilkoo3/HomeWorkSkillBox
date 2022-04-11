import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Loader {

    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1572M.xml";

        long start = System.currentTimeMillis();
        parseFileSAX(fileName);

        long result = System.currentTimeMillis() - start;
        String commitForSearch = "Ограничение памяти нет. ОП Джава SAX. Файл на 1572мб. " +
                "Сохраняем в БД. Без индексов, c визитами.";
        DBConnection.saveResultsMeasure(result, commitForSearch);
    }

    private static void parseFileSAX(String fileName) throws Exception {
        SAXParserFactory factory =SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        DocHandler handler = new DocHandler();
        parser.parse(new File(fileName), handler);
        DBConnection.executeMultiInsert();
        DBConnection.executeMultiInsertStationTimeWork();

    }


}