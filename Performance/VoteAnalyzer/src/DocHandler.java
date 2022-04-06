import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class DocHandler extends DefaultHandler
{
    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private HashMap<Voter, Integer> listVoters;


    public DocHandler() {
        listVoters = new HashMap<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       try {
            if (qName.equals("voter") && voter == null){
          String name = attributes.getValue("name");
          Date birthDate = birthDayFormat.parse(attributes.getValue("birthDay"));
          voter = new Voter(name, birthDate);
          int countVote = listVoters.getOrDefault(voter,0);
          listVoters.put(voter, countVote + 1);
      }
            else if (qName.equals("visit") && voter != null){
                Integer station = Integer.parseInt(attributes.getValue("station"));
                Date time = visitDateFormat.parse(attributes.getValue("time"));
                WorkTime workTime = voteStationWorkTimes.get(station);
                if (workTime == null) {
                    workTime = new WorkTime();
                    voteStationWorkTimes.put(station, workTime);
                }
                workTime.addVisitTime(time.getTime());
            }
       } catch (ParseException e) {
    e.printStackTrace();
}
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")){
            voter = null;
        }

    }

    public void printVotesDuplicate(){
        listVoters.entrySet().stream().filter(v -> v.getValue()>1)
                .forEach(v -> System.out.println(v.getKey() + " → " + v.getValue()));
    }

    public static void printStationsTimeWork(){
        System.out.println("Voting station work times: ");
        for (Integer votingStation : voteStationWorkTimes.keySet()) {
            WorkTime workTime = voteStationWorkTimes.get(votingStation);
            System.out.println("\t" + votingStation + " - " + workTime);
        }
    }

}
