import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static Logger logger;
    private static final int NEW_WIDTH = 500;

    public static void main(String[] args)
    {
        logger = LogManager.getRootLogger();
        int amountCores = Runtime.getRuntime ().availableProcessors();
        String srcFolder = "C:\\Users\\Домашний\\Desktop\\ForHomeWork";
        String dstFolder = "C:\\Users\\Домашний\\Desktop\\Copy";
        try {
            startTreadsWriteFiles(srcFolder, amountCores, dstFolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void startTreadsWriteFiles(String src, int amountCores, String dstFolder){
        File[] files = new File[0];
        try {
            files = getFilesFromDirectory(src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ExecutorService service = Executors.newFixedThreadPool(amountCores);
        Arrays.stream(files).filter(f -> f.getName().endsWith("jpg"))
                .forEach(f -> service.submit(new FilesWriter(f, dstFolder, NEW_WIDTH)));
        service.shutdown();
    }

    static File[] getFilesFromDirectory(String srs) throws FileNotFoundException {
        File file = new File(srs);
        if (!file.exists()){
            throw new FileNotFoundException("File does not exist");
        }
        return file.listFiles();
    }
}
