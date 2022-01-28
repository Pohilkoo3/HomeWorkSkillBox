import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String pathToJsonFile = "data/map.json";
        String path = "https://skillbox-java.github.io/";
        Document doc = null;
        try {
            doc = Jsoup.connect(path).maxBodySize(0).get();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        Line.createLines(doc);
        Station.createStations(doc);
        Connection.createConnections(doc);
        writeJsonFile(pathToJsonFile, getJsonObject());
        System.out.printf("В московском метрополитене %d переходов.", Connection.staticListConnections.size());
    }

    static void writeJsonFile(String pathToJsonFile, JSONObject object){
        try {
            Files.write(Paths.get(pathToJsonFile), object.toJSONString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static JSONObject getJsonObject (){
        JSONObject jsonObjectResult = new JSONObject();
        JSONArray jsonArrayLines = new JSONArray();
        JSONObject stationsForTest = new JSONObject();
        JSONArray jsonArrayConnections = new JSONArray();
        for (Connection element : Connection.staticListConnections) {
            JSONArray connectionsArray = new JSONArray();
            for (Station elementConnection : element.getConnections()) {
                JSONObject connectionStation = new JSONObject();
                connectionStation.put("line", elementConnection.getLine().getId());
                connectionStation.put("station", elementConnection.getName());
                connectionsArray.add(connectionStation);
            }
            jsonArrayConnections.add(connectionsArray);
        }

        jsonObjectResult.put("connections", jsonArrayConnections);
        for (Line element : Line.getLinesList()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("number", element.getId());
            jsonObject.put("name", element.getName());
            jsonArrayLines.add(jsonObject);
            JSONArray jsonArrayStations = new JSONArray();
            element.getListStations().forEach(station -> jsonArrayStations.add(station.getName()));
            stationsForTest.put(element.getId(), jsonArrayStations);
        }
        jsonObjectResult.put("Lines: ", jsonArrayLines);
        jsonObjectResult.put("Stations: ", stationsForTest);
        return jsonObjectResult;
    }
}



