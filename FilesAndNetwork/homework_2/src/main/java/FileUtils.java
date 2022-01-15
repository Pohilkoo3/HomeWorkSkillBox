import java.io.File;
import java.nio.file.Files;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        File sources = new File(sourceDirectory);
        File destination = new File(destinationDirectory);
        if (!sources.exists()) {
            throw new IllegalArgumentException("Запрошенный путь не существует.");
        }
        if (sources.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdir();
            }
            File[] files = sources.listFiles();
            for (File element : files) {
                String pathDestination = destination.getAbsolutePath() + "\\" + element.getName();
                copyFolder(element.getAbsolutePath(), pathDestination);
            }
        }else {
            try {
                Files.copy(sources.toPath(), destination.toPath());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
