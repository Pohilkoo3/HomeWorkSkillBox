import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class Connection {
    private final List<Station> connections;
    public static List<Connection> staticListConnections = new ArrayList<>();

    public Connection() {
        this.connections = new ArrayList<>();
        staticListConnections.add(this);
    }
    public void addStationToConnections(Station station){
        connections.add(station);
    }

    public List<Station> getConnections() {
        return new ArrayList<>(connections);
    }

    public static void createConnections (Document doc){
        Elements stationList = doc.select("p");
        for (int i = 0; i < stationList.size(); i++) {

            if (stationList.get(i).childNodeSize() > 2 && stationList.get(i).childNodeSize() <= 4 ){//дает пересадки

                if (Station.getStation(stationList.get(i).childNode(2)) != null){
                    Connection connection = new Connection();
                    connection.addStationToConnections(Station.mapStations.get(i));
                    connection.addStationToConnections(Station.getStation(stationList.get(i).childNode(2)));
                }
            }else if (stationList.get(i).childNodeSize() > 4) {
                Connection connection = new Connection();
                connection.addStationToConnections(Station.mapStations.get(i));
                for (int j = 2; j < stationList.get(i).childNodeSize() - 1; j++) {
                    connection.addStationToConnections(Station.getStation(stationList.get(i).childNode(j)));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Connection  " + connections;
    }
}
