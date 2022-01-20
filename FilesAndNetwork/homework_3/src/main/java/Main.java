import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String PATH_TO_COPY_DIRECTORY = "D:\\skillBox\\java_basics\\FilesAndNetwork\\homework_3\\images\\";
    public static void main(String[] args) {
        String path = "https://lenta.ru";
        Document doc = null;
        Elements elements = new Elements();
        try {
            doc = Jsoup.connect(path).get();
            elements = doc.select("img");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> address = elements.stream().map(e -> e.attr("abs:src")).distinct().collect(Collectors.toList());
        System.out.println("Список скопированных элементов: \n");
        for (String element : address) {
            String[] splitElement =element.split("/");
            String nameOfFile = splitElement[splitElement.length -1];
            if ( !nameOfFile.endsWith(".jpg") && !nameOfFile.endsWith(".jpeg")){
                continue;
            }
            try {
                String pathElement = PATH_TO_COPY_DIRECTORY + nameOfFile;
                downloadUsingNIO(element, pathElement);
                System.out.println(nameOfFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


        private static void downloadUsingNIO(String urlStr, String file) throws IOException {
            URL url = new URL(urlStr);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(file);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        }
}



/*
 Movements movements = new Movements("D:\\skillBox\\java_basics\\FilesAndNetwork\\files\\movementList.csv");
        List<Operation> listTest = movements.getList();

        System.out.println("Сумма доходов: " + movements.getIncomeSum() + " руб.");
        System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
        System.out.println("\n\n" + "Сумма расходов по организациям: ");

        listTest.forEach(m -> System.out.println(m.getName() + " \t " + m.getExpense() + " руб."));

 */

/*

        String path = "D:\\skillBox\\java_basics\\FilesAndNetwork\\homework_3\\data\\lenta.html";
        String code = parseHTMLFile(path);
        Document doc = Jsoup.parse(code);
*/

