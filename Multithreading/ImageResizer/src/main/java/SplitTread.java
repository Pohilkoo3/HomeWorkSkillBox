import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SplitTread extends Thread{
    private final File[] files;
    private final String dst;
    private final int width;
    private static final Logger loggerFiles = LogManager.getLogger("WriteFiles");
    private static final Logger errors = LogManager.getLogger("Errors");


    public SplitTread(File[] files, String dst, int width){
        this.files = files;
        this.dst = dst;
        this.width = width;
    }


    @Override
    public void run() {
        for (File file : files) {
            File dstFile = new File(dst + "\\" + file.getName());
            try {
                BufferedImage image = ImageIO.read(file);
                loggerFiles.info("Имя файла к записи: " + file.getName());
                BufferedImage scaledImage = Scalr.resize(image, Scalr.Method.QUALITY, width);
                ImageIO.write(scaledImage, "jpg", dstFile);

            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }
}
