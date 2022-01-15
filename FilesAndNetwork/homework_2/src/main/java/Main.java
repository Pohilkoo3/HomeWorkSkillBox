import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к папке которую необходимо копировать.");
        String testSources = scanner.nextLine();
        System.out.println("Введите путь к папке в которую необходимо провести копирование.");
        String testDestination = scanner.nextLine();

        try {
            FileUtils.copyFolder(testSources, testDestination);
            System.out.println("Копирование успешно завершено.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

