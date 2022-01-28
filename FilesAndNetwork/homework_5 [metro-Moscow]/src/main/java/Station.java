import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Station {
    private final Line line;
    private final String name;
    public static Map<Integer, Station> mapStations = new TreeMap<>();
    public static List<Station> listStations = new ArrayList<>();

    public Station(Line line, String name, Integer i) {
        this.line = line;
        this.name = name;
        listStations.add(this);
        line.addStationToLine(this);
        mapStations.put(i, this);
    }


    public Line getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return line.getName() + " " + name;
    }

    public static void createStations(Document doc){
        Elements stationList = doc.select("p");
        Line line = null;
        int countLine = -1;
        for (int i = 0; i < stationList.size(); i++) {
            if(stationList.get(i).child(0).text().equals("1.")){
                countLine++;
                line = Line.getLinesList().get(countLine);
            }
            String nameStation = stationList.get(i).child(1).text().trim();
            Station station = new Station(line, nameStation, i);
        }
    }

    static Station getStation(Node node){
        if (!node.attr("title").isBlank())
        {
            String[] regexString = node.attr("class").split("-");
            String idLine = regexString[3];
            String regex = "(«[А-яё]+\\s*[А-яё]*\\s*[А-яё]*)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(node.attr("title"));
            matcher.find();
            String result = matcher.group(0).replaceAll("«","").trim();
            return Line.getLinesList().stream().filter(l -> l.getId().equals(idLine)).map(Line::getListStations)
                    .findFirst().get().stream().filter(e -> e.getName().equals(result)).findFirst().orElse(null);
        }
        return null;
    }

}
