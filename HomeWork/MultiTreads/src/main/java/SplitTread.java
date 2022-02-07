import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SplitTread extends Thread{
    private File[] files;
    private String dst;
    private int weight;
    private static Logger loggerFiles = LogManager.getLogger("WriteFiles");
    private static Logger errors = LogManager.getLogger("Errors");


    public SplitTread(File[] files, String dst, int weight){
        this.files = files;
        this.dst = dst;
        this.weight = weight;
    }


    @Override
    public void run() {
        String dstDir = dst;
        for (File file : files) {

            if (!file.getName().endsWith("jpg")){
                errors.error(file.getName());
                System.out.println("HELLO");
                continue;
            }
            File dstFile = new File(dstDir + "\\" + file.getName());
            try {
                BufferedImage image = ImageIO.read(file);
                loggerFiles.info("Имя файла к записи: " + file.getName());
                BufferedImage scaledImage = Scalr.resize(image, Scalr.Method.QUALITY, 800);
                ImageIO.write(scaledImage, "jpg", dstFile);

            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }
}
