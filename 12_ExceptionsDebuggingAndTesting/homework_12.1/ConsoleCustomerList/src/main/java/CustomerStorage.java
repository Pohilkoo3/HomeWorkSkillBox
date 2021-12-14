import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**количестве компонентов в переданной строке с данными,
 формате номера телефона,
 формате email.*/
public class CustomerStorage {
    private final Map<String, Customer> storage;
    private final String regexPhone = "((\\+7[0-9]{10}))";
    private final Pattern pattern = Pattern.compile(regexPhone);
    private final String regexEmail = "(\\w+@\\w+\\.\\w+)";
    private final Pattern patternEmail = Pattern.compile(regexEmail);

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;


        String[] components = data.split("\\s+");
        if (components.length !=4){
            throw new IllegalArgumentException ("Wrong Command. Wright command: \nadd Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        Matcher matcherPhone = pattern.matcher(components[INDEX_PHONE]);
        if (!matcherPhone.find() || components[INDEX_PHONE].length() != 12){
            throw new IllegalArgumentException("Wrong phone number. Wright format is +79215637722.");
        }
        Matcher matcherEmail = patternEmail.matcher(components[INDEX_EMAIL]);
        if (!matcherEmail.find()){
            throw new IllegalArgumentException("Wrong format Email. Wright format: vasily.petrov@gmail.com");
        }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}