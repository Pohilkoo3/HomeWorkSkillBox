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
        parseFileSAX(fileName);//обрабатываем через SAX



//        parseFileDOM(fileName);//обрабатываем через DOM
        String commitForSearch = "Ограничение памяти 300мб. ОП Джава SAX. Файл на 18мб. " +
                "Сохраняем в БД. C индексом на имя и дату рождения, но без проверки на дупликаты";
        long result = System.currentTimeMillis() - start;

        DBConnection.saveResultsMeasure(result, commitForSearch);

//        DBConnection.printVoterCounts();
//        long usages = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//
//        System.out.println("Память после заполнения: → " +
//                (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usages));
//        System.out.println("Voting station work times: ");
//        for (Integer votingStation : voteStationWorkTimes.keySet()) {
//            WorkTime workTime = voteStationWorkTimes.get(votingStation);
//            System.out.println("\t" + votingStation + " - " + workTime);
//        }
//
//        System.out.println("Duplicated voters: ");
//        for (Voter voter : voterCounts.keySet()) {
//            Integer count = voterCounts.get(voter);
//            if (count > 1) {
//                System.out.println("\t" + voter + " - " + count);
//            }
//        }
    }

    private static void parseFileSAX(String fileName) throws Exception {
//        long usages = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        SAXParserFactory factory =SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        DocHandler handler = new DocHandler();
        parser.parse(new File(fileName), handler);
        DBConnection.executeMultiInsert();
//        System.out.println("Избирателей → " + handler.getListVoters().size());
//        System.out.println("Последний избиратель → ");
//        handler.getListVoters()
//                .entrySet().stream().map(v ->v.getKey())
//                .map(Voter::getName)
//                .filter(n -> n.equals("Курослепов Ветран"))
//                .forEach(System.out::println);


//        System.out.println("Память после заполнения: → " +
//                (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usages));

//        handler.printVotesDuplicate();//распечатать дупликаты голосов
//        DocHandler.printStationsTimeWork();
    }

    private static void parseFileDOM(String fileName) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(fileName));

        findEqualVoters(doc);
//        fixWorkTimes(doc);
    }

    private static void findEqualVoters(Document doc) throws Exception {
        NodeList voters = doc.getElementsByTagName("voter");
        int votersCount = voters.getLength();
        for (int i = 0; i < votersCount; i++) {
            Node node = voters.item(i);
            NamedNodeMap attributes = node.getAttributes();
            String name = attributes.getNamedItem("name").getNodeValue();
           String birthDay = attributes.getNamedItem("birthDay").getNodeValue();

            DBConnection.countVoter(name, birthDay);
            if (i == votersCount - 1){
                DBConnection.executeMultiInsert();
            }
        }
        DBConnection.executeMultiInsert();
    }

    private static void fixWorkTimes(Document doc) throws Exception {
        NodeList visits = doc.getElementsByTagName("visit");
        int visitCount = visits.getLength();
        for (int i = 0; i < visitCount; i++) {
            Node node = visits.item(i);
            NamedNodeMap attributes = node.getAttributes();
            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
            WorkTime workTime = voteStationWorkTimes.get(station);
            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(station, workTime);
            }
            workTime.addVisitTime(time.getTime());
        }
    }
}