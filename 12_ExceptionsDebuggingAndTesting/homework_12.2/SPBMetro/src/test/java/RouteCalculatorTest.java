import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator;
    List<Station> route;
    List<Station> route2;

    @Override
    protected void setUp() throws Exception {
        stationIndex.addLine(new Line(1, "First Line"));
        stationIndex.addLine(new Line(2, "Second Line"));
        stationIndex.addLine(new Line(3, "Third Line"));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                String name = "Station " + (i + 1) + "." + (j + 1);
                switch (i) {
                    case 0:
                        stationIndex.addStation(new Station(name, stationIndex.getLine(1)));
                        stationIndex.getLine(1).addStation(stationIndex.getStation(name));
                        break;
                    case 1:
                        stationIndex.addStation(new Station(name, stationIndex.getLine(2)));
                        stationIndex.getLine(2).addStation(stationIndex.getStation(name));
                        break;
                    case 2:
                        stationIndex.addStation(new Station(name, stationIndex.getLine(3)));
                        stationIndex.getLine(3).addStation(stationIndex.getStation(name));
                        break;
                }
            }
        }

     List<Station> connectionsLine1Line2 = new ArrayList<>();
     connectionsLine1Line2.add(stationIndex.getStation("Station 1.2"));
     connectionsLine1Line2.add(stationIndex.getStation("Station 2.3"));
        List<Station> connectionsLine1Line3 = new ArrayList<>();
        connectionsLine1Line3.add(stationIndex.getStation("Station 1.5"));
        connectionsLine1Line3.add(stationIndex.getStation("Station 3.4"));

        stationIndex.addConnection(connectionsLine1Line2);
        stationIndex.addConnection(connectionsLine1Line3);
        routeCalculator = new RouteCalculator(stationIndex);

        route = new ArrayList<>();
        route.add(stationIndex.getStation("Station 1.1"));
        route.add(stationIndex.getStation("Station 1.2"));
        route.add(stationIndex.getStation("Station 1.3"));
        route.add(stationIndex.getStation("Station 1.4"));

        route2 = new ArrayList<>();
        route2.add(stationIndex.getStation("Station 2.2"));
        route2.add(stationIndex.getStation("Station 2.3"));
        route2.add(stationIndex.getStation("Station 1.2"));
        route2.add(stationIndex.getStation("Station 1.3"));
        route2.add(stationIndex.getStation("Station 1.4"));

    }
    public void testCalculateDuration(){ //определение длительности поездки по одной ветке
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 7.5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationTwoLines(){ //определение длительности поездки с переходом на другую линию
        double actual = RouteCalculator.calculateDuration(route2);
        double expected = 11;
        assertEquals(expected, actual);
    }
    public void testGetRouteOneStation(){ //кратчайщий маршрут с одной станции на эту же станцию
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Station 1.1"),
                stationIndex.getStation("Station 1.1"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Station 1.1"));
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine(){ //кратчайщий маршрут по одной ветке
       List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Station 1.1"),
               stationIndex.getStation("Station 1.5"));
       List<Station> expected = new ArrayList<>();
       expected.add(stationIndex.getStation("Station 1.1"));
       expected.add(stationIndex.getStation("Station 1.2"));
       expected.add(stationIndex.getStation("Station 1.3"));
       expected.add(stationIndex.getStation("Station 1.4"));
       expected.add(stationIndex.getStation("Station 1.5"));
       assertEquals(expected, actual);
    }
    public void testGetRouteTwoLines(){ //кратчайщий маршрут с переходом на другую ветку
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Station 1.1"),
                stationIndex.getStation("Station 2.1"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Station 1.1"));
        expected.add(stationIndex.getStation("Station 1.2"));
        expected.add(stationIndex.getStation("Station 2.3"));
        expected.add(stationIndex.getStation("Station 2.2"));
        expected.add(stationIndex.getStation("Station 2.1"));
        assertEquals(expected, actual);
    }
    public void testGetRouteThreeLines(){ //кратчайщий маршрут с двумя переходами на другие ветки
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Station 2.1"),
                stationIndex.getStation("Station 3.5"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Station 2.1"));
        expected.add(stationIndex.getStation("Station 2.2"));
        expected.add(stationIndex.getStation("Station 2.3"));
        expected.add(stationIndex.getStation("Station 1.2"));
        expected.add(stationIndex.getStation("Station 1.3"));
        expected.add(stationIndex.getStation("Station 1.4"));
        expected.add(stationIndex.getStation("Station 1.5"));
        expected.add(stationIndex.getStation("Station 3.4"));
        expected.add(stationIndex.getStation("Station 3.5"));
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

