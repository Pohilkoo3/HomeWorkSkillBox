import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private Logger loggerroot = LogManager.getRootLogger();
    static Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        String path = "https://skillbox.ru";

        result = new ForkJoinPool().invoke(new NodeGetChild(path));

    }
}


/*//       Node root = new Node(path);
//
//        System.out.println(root.getAddress() );
//        root.makeChildren();
//        root.getListChildes().forEach(System.out::println);
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Работает вторая нода");
//        String path2 ="https://skillbox.ru/media";
//        Node root2 = new Node(null, path2);
//
//        System.out.println(root2.getAddress() + "\n Детишки");
//        root2.makeChildren();
//        root2.getListChildes().forEach(System.out::println);
//
*/
