import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String name;
    private final String id;
    private final static List<Line> linesList = new ArrayList<>();
    private final List<Station> listStations;



    public Line(String id, String name) {
        this.name = name;
        this.id = id;
        listStations = new ArrayList<>();
        addLinesList(this);
    }

    public static void addLinesList(Line e) {
        linesList.add(e);
    }

    public void addStationToLine(Station station){
        listStations.add(station);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Station> getListStations() {
        return new ArrayList<>(listStations);
    }

    public static List<Line> getLinesList() {
        return new ArrayList<>(linesList);
    }



    public static void createLines(Document doc){
        Elements linesListSource = doc.select("div > span");//TODO создаем все линии код готов
        for (Element element : linesListSource) {
            String nameLine = element.text();
            String[] resultSplit = element.toString().split("\"");
            Line line = new Line(resultSplit[3], nameLine);
        }
    }

    @Override
    public String toString() {
        return id + " => " + name;
    }
}
