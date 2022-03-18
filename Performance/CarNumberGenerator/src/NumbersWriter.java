import java.io.*;

public class NumbersWriter extends Thread
{
    private StringBuilder buffer;
    private String path;

    public NumbersWriter(StringBuilder buffer, String path)  {
       this.buffer = buffer;
       this.path = path;
    }
    @Override
    public void run() {
        PrintWriter writer = null;
        try {
          writer = new PrintWriter(path);
           writer.write(buffer.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
