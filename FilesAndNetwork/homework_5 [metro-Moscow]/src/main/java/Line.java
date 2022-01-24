import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private String id;
    private static List<Line> linesList = new ArrayList<>();
    private List<Station> listStations;



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
    public static Line getLinesToPath(String nameOfLine){
        return linesList.stream().filter(line -> line.getName().equals(nameOfLine)).findFirst().orElse(null);
    }


    @Override
    public String toString() {
        return id + " => " + name;
    }
}


