import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static void main(String[] args) throws Exception {


        long start = System.currentTimeMillis();
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        int count = 0;
        StringBuilder buffer = new StringBuilder();
        int maxRegion = 200;
        for (int numberRegion = 1; numberRegion < maxRegion; numberRegion++) {
            String path = "";
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            buffer.append(firstLetter);
                            buffer.append(padNumber(number, 3));
                            buffer.append(secondLetter);
                            buffer.append(thirdLetter);
                            buffer.append(padNumber(numberRegion, 2));
                            buffer.append("\n");
                            count++;
                            path = "res/numbers" + numberRegion +".txt";
                        }
                    }
                }
            }
            if (numberRegion % 5 == 0 || numberRegion == (maxRegion-1)){
                NumbersWriter numbersWriter = new NumbersWriter(buffer, path);
                numbersWriter.start();
                buffer = new StringBuilder();
            }

        }
        System.out.println("We create " + count + " numbers for auto.");
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
       StringBuffer buffer = new StringBuffer(Integer.toString(number));
        int padSize = numberLength - buffer.length();
        for (int i = 0; i < padSize; i++) {
            buffer.insert(0,0);
        }
        return buffer.toString();
    }

    private static int countNumbersInFile(String path){
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.size();
    }
}
