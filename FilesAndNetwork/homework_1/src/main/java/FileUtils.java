import java.io.File;


public class FileUtils {

    public static boolean getRightPath(String path){
        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()){
            throw new IllegalArgumentException("Name of file or path to the file is specified wrong.");
        }return true;
    }

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        if (folder.isFile()){
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        try {
            for (File element : files) {
                sum += calculateFolderSize(element.getPath());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return sum;
    }
}
