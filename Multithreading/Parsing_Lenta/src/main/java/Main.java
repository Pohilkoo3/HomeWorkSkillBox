import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private Logger loggerroot = LogManager.getRootLogger();
    static Set<Node> result = new HashSet<>();

    public static void main(String[] args) {
        String path = "https://skillbox.ru";
        Node root = new Node(null, path);

       result = new ForkJoinPool().invoke(new NodeGetChild(root));
       printResult(root);
    }

    static void printResult(Node node){
        System.out.println("\t".repeat(node.getLevel()) + node.getAddress() + " → " + node.getLevel());
       try {
        Files.writeString((Paths.get("D:\\skillBox\\java_basics\\Multithreading\\Parsing_Lenta\\data\\map_site.txt")),
                ("\t".repeat(node.getLevel()) + node.getAddress() + " → " + node.getLevel() + "\n"),
                StandardOpenOption.APPEND);
    } catch (IOException e) {
        e.printStackTrace();
    }
    if (Node.staticListAllNods.get(node.getAddress()).getChildNods().size() == 0){
            return;
        }
        for (Node element : Node.staticListAllNods.get(node.getAddress()).getChildNods()) {
            printResult(element);
        }
    }
}

