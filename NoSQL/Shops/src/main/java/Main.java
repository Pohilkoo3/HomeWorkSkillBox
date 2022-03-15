import Methods.Command;
import Methods.Connection;
import Methods.MethodsForShop;
import com.mongodb.Block;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        Connection connection = new Connection();
        Command commandOperator = new Command();
        MethodsForShop methodsForShop = new MethodsForShop(connection.getDatabase(), connection.getCollectionShops(),
                connection.getCollectionGoods());

        for (;;) {
            System.out.println("\nВведите команду. \nЕсли хотите выйти - наберите \"Exit\"\nЕсли нужна помощь наберите \"Help\"");
            String command = new Scanner(System.in).nextLine();
            String commandForSwitch = commandOperator.getCommand(command);
            switch(commandForSwitch) {
                case "Exit" -> {return;}
                case "Help" -> printHelp();
                case "ДОБАВИТЬ_МАГАЗИН" -> methodsForShop.addShop(command);
                case "ПОКАЗАТЬ_МАГАЗИНЫ" -> connection.getDatabase().listCollectionNames().forEach((Block<? super String>) System.out::println);
                case "УДАЛИТЬ_МАГАЗИН" -> methodsForShop.deleteShop(command);
                case "ПОДКЛЮЧИТЬ_МАГАЗИН" -> methodsForShop.switchShop(command);
                case "ДОБАВИТЬ_ТОВАР" -> methodsForShop.addGoods(command);
                case "ВЫСТАВИТЬ_ТОВАР" -> methodsForShop.putGoodsInShop(command);
                case "СТАТИСТИКА_ТОВАРОВ" -> methodsForShop.printStatisticGoods();
                case "СТАТИСТИКА_МАГАЗИНА" -> methodsForShop.printStatisticGoodsAtShop();
                case "ПОЛУЧИТЬ_ТОВАР" -> methodsForShop.getGoodByName(command);
                default -> System.out.println("Команда не распознана. Введите другую комманду.");

            }
        }

    }


    private static void printHelp() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("data/help.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines != null) {
            lines.forEach(System.out::println);
        }
    }

}
