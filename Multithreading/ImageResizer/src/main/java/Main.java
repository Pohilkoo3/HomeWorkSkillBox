import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;

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
        int startCopying = 0;
        int lengthMassive = files.length / amountCores;
        for (int i = 0; i < amountCores; i++) {
            File[] files1 = new File[lengthMassive];
            System.arraycopy(files, startCopying, files1, 0, files1.length);
            startCopying += lengthMassive;
            SplitTread splitTread = new SplitTread(files1, dstFolder, NEW_WIDTH);
            splitTread.start();
        }
    }

    static File[] getFilesFromDirectory(String srs) throws FileNotFoundException {
        File file = new File(srs);
        if (!file.exists()){
            throw new FileNotFoundException("File does not exist");
        }
        return file.listFiles();
    }
}



/*
 String srcFolder = "/users/sortedmap/Desktop/src";
        String dstFolder = "/users/sortedmap/Desktop/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newWidth = 300;
                int newHeight = (int) Math.round(
                    image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = new BufferedImage(
                    newWidth, newHeight, BufferedImage.TYPE_INT_RGB
                );

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
 */