import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        String pathToJsonFile = "data/map.json";
//
//        String path = "https://skillbox-java.github.io/";
//        Document doc = null;
//        try {
//            URL url = new URL(path);
//            doc = Jsoup.connect(path).maxBodySize(0).get();
//        } catch (Exception ex){
//            ex.printStackTrace();
//        }
//        Elements linesListSource = doc.select("div > span");//TODO создаем все линии код готов
//        linesListSource.stream().forEach(element -> {
//            String nameStation = element.text();
//            String[] resultSplit = element.toString().split("\"");
//            Line line = new Line(resultSplit[3], nameStation);
//        }) ;
//        List<Line> lineList = Line.getLinesList();
//
//        Elements stationList = doc.select("p");
//        List<String> stationListWright = stationList.stream().map(Element::text).collect(Collectors.toList());
//        Line line = null;
//        int countLine = -1;
//        for (int i = 0; i < stationListWright.size(); i++) {
//            if(stationListWright.get(i).startsWith("1.")){
//                countLine++;
//                line = lineList.get(countLine);
//            }
//            String nameStation = stationListWright.get(i).substring(2, stationListWright.get(i).length())
//                    .replaceAll("\\.", "") .trim();
//            Station station = new Station(line, nameStation);
//        }
//        JSONObject jsonObjectResult = new JSONObject();
//        JSONArray jsonArrayLines = new JSONArray();
//        JSONObject stationsForTest = new JSONObject();
//        for (Line element : lineList) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("number", element.getId());
//            jsonObject.put("name", element.getName());
//            jsonArrayLines.add(jsonObject);
//            JSONArray jsonArrayStations = new JSONArray();
//            element.getListStations().forEach(station -> jsonArrayStations.add(station.getName()));
//            stationsForTest.put(element.getId(), jsonArrayStations);
//            System.out.println(element.getName() + " => " + element.getListStations().size() + " stations on the line.");
//
//        }
//       jsonObjectResult.put("Lines: ", jsonArrayLines); //создали объект линии
//        jsonObjectResult.put("Stations: ", stationsForTest);
//
//        try {
//            Files.write(Paths.get(pathToJsonFile), jsonObjectResult.toJSONString().getBytes());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
           writeJsonSimpleDemo("data/text.json");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void writeJsonSimpleDemo(String filename) throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("name", "Stackabuser");
        sampleObject.put("age", 35);

        JSONArray messages = new JSONArray();
        messages.add("Hey!");
        messages.add("What's up?!");

        sampleObject.put("massive", messages);
        System.out.println(sampleObject);
        Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
    }
}

