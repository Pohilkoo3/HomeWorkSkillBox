import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FilesWriter implements Runnable{

    private final File file;
    private final String dstDir;
    private final int width;
    private final Logger loggerWriter = LogManager.getLogger("FilesWriter");

    public FilesWriter(File file, String dstDir, int width) {
        this.file = file;
        this.dstDir = dstDir;
        this.width = width;

    }

    @Override
    public void run() {
        File dstFile = new File(dstDir + "\\" + file.getName());
        try {
            BufferedImage image = ImageIO.read(file);
            loggerWriter.info("Логгер executor: " + file.getName());
            BufferedImage scaledImage = Scalr.resize(image, Scalr.Method.QUALITY, width);
            ImageIO.write(scaledImage, "jpg", dstFile);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
