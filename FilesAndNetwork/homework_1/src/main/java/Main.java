import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Введите путь до папки.");
//        String path = new Scanner(System.in).nextLine();
        String path = "C:/Users/Домашний/Desktop/ForHomeWork";
        if (FileUtils.getRightPath(path)) {
            System.out.println("Размер папки " + path + " составляет " +
                    getHumanReadableSize(FileUtils.calculateFolderSize(path)) + ".");
        }
    }

    public static String getHumanReadableSize (long size){
        double result = size;
        int level = 0;
        while (result > 999){
            result = result / 1024;
            level += 1;
        }
        String[] sizeName = {"B", "Kb", "Mb", "Gb", "Tb"};
        return String.format("%.2f",result) + sizeName[level];
    }


}
