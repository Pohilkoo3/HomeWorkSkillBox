import java.util.Scanner;

public class Main {
    public static final int CONTAINER_IN_TRUCK = 12;
    public static final int BOXES_IN_CONTAINER = 27;
    private static final String LS = System.lineSeparator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int boxes1 = Integer.parseInt(boxes);// переделать под бесконечный цикл с правильным ответом
        if (boxes1 < 0) {
            System.out.println("Вы ввели отрицательное число. Количество коробок должно быть больше нуля.");
            return;
        }
        int countContainer = boxes1 / BOXES_IN_CONTAINER;
        countContainer = boxes1 % BOXES_IN_CONTAINER == 0 ? countContainer : countContainer + 1;
        int countTruck = countContainer / CONTAINER_IN_TRUCK;
        countTruck = countContainer % CONTAINER_IN_TRUCK == 0 ? countTruck : countTruck + 1;
        int countJ = 0; //считаем общее количество контейнеров
        int countK = 0; //считаем общее количество коробок в контейнерах

        for (int i = 0; i < countTruck; i++) { //подумать начать цикл с 1 или 0
            System.out.println("Грузовик: " + (i + 1));
            for (int j = 0; j < CONTAINER_IN_TRUCK; j++) {
                System.out.println("\tКонтейнер: " + (countJ + 1));
                for (int k = 0; k < BOXES_IN_CONTAINER; k++) {
                    System.out.println("\t\tЯщик: " + (countK + 1));
                    countK += 1;
                    if (countK == boxes1) {
                        break;
                    }
                }
                countJ += 1;
                if (countJ == countContainer) {
                    break;
                }
            }
        }
        System.out.println("Необходимо:" + LS + "грузовиков - " + countTruck + " шт." + LS + "контейнеров - " +
                countContainer + " шт.");
    }
}
