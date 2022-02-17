import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Node
{
    public static List<Node> listNodes = new ArrayList<>();
    private Logger loggerStaticAttr = LogManager.getLogger("StaticAttribute");
    private Logger loggerNods = LogManager.getLogger("LoggerNods");
    private static ConcurrentSkipListSet<String> staticListAllRefs = new ConcurrentSkipListSet<>();
    private String address;
    HashSet<String> childNodeRefs;


    public Node(String address) {
        this.address = address;
        this.childNodeRefs = new HashSet<>();
        listNodes.add(this);
        loggerNods.info(this);

    }

    protected void makeChildren() {
        Document doc = null;
        try {
            doc = Jsoup.connect(address).maxBodySize(0).get();
        } catch (IOException e) {
            return;
        }
        if (doc == null){
            System.out.println("Нет такого адреса");
            return;
        }

        Elements elements = doc.select("a");
        if (elements.size() == 0){
            return;
        }
        for (Element element : elements) {
            if ((element.attr("href").startsWith("/") || element.attr("href")
                    .startsWith(address)) && !element.attr("href").contains("?")) {
                String attr = element.attr("href").replaceAll("https://skillbox.ru", "").trim();
                if (attr.length() > 1 && !staticListAllRefs.contains(attr)){

                    String absoluteAddress = attr.startsWith("https") ? attr : address + attr;
                    String linkChildren = absoluteAddress.endsWith("/") ? absoluteAddress.substring(0, absoluteAddress.length()-1) : absoluteAddress;
                    childNodeRefs.add(linkChildren);
                    loggerStaticAttr.info(address + attr);
                    staticListAllRefs.add (attr);
                }
            }
        }
    }



    public static ConcurrentSkipListSet<String> getStaticListAllNodes() {
        return staticListAllRefs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getNodesChild() {
        return childNodeRefs;
    }


    @Override
    public String toString() {
        return "Node → " +address;
    }

    static public Node getNodeByName(String path) {
        return listNodes.stream().filter(e -> e.address.equals(path)).findFirst().orElse(null);
    }
}


/*
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Node
{
    public static List<Node> listNodes = new ArrayList<>();
    private Logger loggerStaticAttr = LogManager.getLogger("StaticAttribute");
    private Logger loggerNods = LogManager.getLogger("LoggerNods");
    private static ConcurrentSkipListSet<String> staticListAllRefs = new ConcurrentSkipListSet<>();
    private String address;
    HashSet<String> childNodeRefs;


    public Node(String address) {
        this.address = address;
        this.childNodeRefs = new HashSet<>();
        listNodes.add(this);
        loggerNods.info(this);

    }

    protected void makeChildren() {
        Document doc = null;
        try {
            doc = Jsoup.connect(address).maxBodySize(0).get();
        } catch (IOException e) {
            return;
        }
        if (doc == null){
            System.out.println("Нет такого адреса");
            return;
        }

        Elements elements = doc.select("a");
        if (elements.size() == 0){
            return;
        }
        for (Element element : elements) {
            if ((element.attr("href").startsWith("/") || element.attr("href")
                    .startsWith(address)) && !element.attr("href").contains("?")) {
                String attr = element.attr("href").replaceAll("https://skillbox.ru", "").trim();
                if (attr.length() > 1 && !staticListAllRefs.contains(attr)){

                    String absoluteAddress = attr.startsWith("https") ? attr : address + attr;
                    String linkChildren = absoluteAddress.endsWith("/") ? absoluteAddress.substring(0, absoluteAddress.length()-1) : absoluteAddress;
                    childNodeRefs.add(linkChildren);
                    loggerStaticAttr.info(address + attr);
                    staticListAllRefs.add (attr);
                }
            }
        }
    }



    public static ConcurrentSkipListSet<String> getStaticListAllNodes() {
        return staticListAllRefs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getNodesChild() {
        return childNodeRefs;
    }


    @Override
    public String toString() {
        return "Node → " +address;
    }

    static public Node getNodeByName(String path) {
        return listNodes.stream().filter(e -> e.address.equals(path)).findFirst().orElse(null);
    }
}

 */




/*
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class Node
{
//    private Logger loggerStaticAttr = LogManager.getLogger("StaticAttribute");
    private Logger loggerNods = LogManager.getLogger("LoggerNods");

    private static ConcurrentHashMap<String, Node> staticListNods = new ConcurrentHashMap<>();
    private static HashSet<String> repeatRefs = new HashSet<>();
    private Node parentNode;
    private final List<Node> listChildes;
    private final String address;
    private int level = 0;

    public Node(Node parent, String address) {
        this.address = address;
        this.parentNode = parent;
        listChildes = new ArrayList<>();
        this.level = parent == null ? 0 : (parent.level + 1);
        staticListNods.put(address, this);

    }

    public void makeChildren() {
        Document doc = null;
        try {
            doc = Jsoup.connect(address).maxBodySize(0).get();
        } catch (IOException e) {
            return;
        }
        if (doc == null){
            System.out.println("Нет такого адреса");
            return;
        }

        Elements elements = doc.select("a");
        if (elements.size() == 0){
            return;
        }

        for (Element element : elements) {
            System.out.println(element.attr("href"));
            if ((element.attr("href").startsWith("/") && element.attr("href").length() > 1) ) {
                loggerNods.info(element.attr("href"));
                String[] partAttr = element.attr("href").split("/");
                String attr = partAttr[1];

                if (!repeatRefs.contains(attr)){
                    repeatRefs.add(attr);
                }
            }

//                if (attr.length() > 1 && !repeatRefs.contains(attr)){
//                    String absoluteAddress = attr.startsWith("https") ? attr : address + attr;
//                    String linkChildren = absoluteAddress.endsWith("/") ? absoluteAddress.substring(0, absoluteAddress.length()-1) : absoluteAddress;
//                    repeatRefs.add (attr);
//                    URL url;
//                    HttpURLConnection huc;
//                    int responseCode = 0;
//                    try {
//                        url = new URL(linkChildren);
//                        huc = (HttpURLConnection) url.openConnection();
//                        huc.setRequestMethod("HEAD");
//                        responseCode = huc.getResponseCode();
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    if (responseCode == 404){
//                        continue;
//                    }
//
//                    Node node = new Node(this, linkChildren);
//                    listChildes.add(node);
////                    loggerStaticAttr.info(attr);
//                }
//            }
        } repeatRefs.forEach(System.out::println);
    }
    public String getAddress() {
        return address;
    }

    public static ConcurrentHashMap<String, Node> getStaticListNods() {
        return staticListNods;
    }

    public static HashSet<String> getRepeatRefs() {
        return repeatRefs;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public List<Node> getListChildes() {
        return listChildes;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Node{" +
                "address='" + address + '\'' +
                ", level=" + level +
                '}';
    }
}
 */