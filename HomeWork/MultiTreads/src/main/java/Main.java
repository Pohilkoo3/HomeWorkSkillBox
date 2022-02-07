import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static Logger logger;
    private static int NEW_WIDTH = 500;
    public static void main(String[] args) {
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




















/**
 *  String srcFolder = "C:\\Users\\Домашний\\Desktop\\ForHomeWork";
 *        String dstFolder = "C:\\Users\\Домашний\\Desktop\\Copy";
 *        File dstDir = new File(dstFolder);
 *        dstDir.mkdir();
 *         File srcDir = new File(srcFolder);
 *         long start = System.currentTimeMillis();
 *         File[] files = srcDir.listFiles();
 *         int middle = files.length / 2;
 *         File[] files1 = new File[middle];
 *         System.arraycopy(files, 0, files1, 0, files1.length);
 *         FileResizer fileResizer = new FileResizer(files1, dstDir, NEW_WIDTH);
 *         fileResizer.start();
 *
 *         File[] files2 = new File[files.length - middle];
 *         System.arraycopy(files, middle, files2, 0, files2.length);
 *         FileResizer fileResizer2 = new FileResizer(files2, dstDir, NEW_WIDTH);
 *         fileResizer2.start();
 */

/*

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class FileResizer extends Thread{
    private File[] files;
    private static int NEW_WIDTH;
    private File dstDir;
    private long start;


public FileResizer(File[] files, File dstDir, int newWidth){
    this.files = files;
    this.NEW_WIDTH = newWidth;
    this.dstDir = dstDir;
    this.start = System.currentTimeMillis();
}

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {//проверить как правильно поставить равенство
                    continue;
                }
                int newHeight = (int) Math.round((image.getHeight()) / (image.getWidth() / (double) NEW_WIDTH));
                BufferedImage newImage = new BufferedImage(NEW_WIDTH, newHeight, BufferedImage.TYPE_INT_RGB);
                int widthStep = image.getWidth() / NEW_WIDTH;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < NEW_WIDTH; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }
                File newFile = new File(dstDir.getAbsolutePath() + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);

            }
        } catch (Exception ex){
                ex.printStackTrace();
            }
        System.out.println("Duration operation  = " + (start - System.currentTimeMillis()));
    }
}

 */