import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private static final String regex = "(\\+*\\d{11,12})";
    private static final Pattern pattern = Pattern.compile(regex);
    private static final String regexName = "(\\W*\\d*[A-я]+)+";
    private static final Pattern patternName = Pattern.compile(regexName);

    private final TreeMap<String, String> phoneBook = new TreeMap<>();

    public boolean checkNumber (String phone){
      return phoneBook.containsKey((correctNumber(phone)));
    }
    public boolean checkName(String name){
        return phoneBook.containsValue(name);
    }

    public boolean addContact(String phone, String name) {
        Matcher matcherNumber = pattern.matcher(correctNumber(phone));
        Matcher matcherName = patternName.matcher(name);
        if (matcherNumber.matches() && matcherName.matches()) {
            phoneBook.put(correctNumber(phone), name);
            return true;
        } else {
            return false;
        }
    }
    private static String correctNumber(String number){
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            String input1 = (number.replaceAll("\\+", "")).trim();
            return "7".concat(input1.substring(1));
        }else {
            return "";
        }
    }

    public String getContactByPhone(String phone) {// формат одного контакта "Имя - Телефон"
        if (phoneBook.containsKey(correctNumber(phone))) {
            return phoneBook.get(correctNumber(phone)) + " - " + phone;
        }
        return "";// если контакт не найдены - вернуть пустую строку
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> numbers = new TreeSet<>();  // формат одного контакта "Имя - Телефон"
        StringBuilder result  = new StringBuilder();
        if (phoneBook.containsValue(name)) {
            for (Map.Entry element : phoneBook.entrySet()) {
                if (element.getValue().equals(name)) {
                    result.append(element.getKey().toString()).append(", ");
                }
            } result.insert(0,name + " - ");
            numbers.add(result.substring(0, result.length()-2));
        }
        return numbers;
    }

    public Set<String> getAllContacts() {// формат одного контакта "Имя - Телефон"
        TreeSet<String> allContacts = new TreeSet<>();
        for (Map.Entry<String, String> element : phoneBook.entrySet()) {
            StringBuilder total = new StringBuilder();
            String searchName = element.getValue();
            for (Map.Entry entry : phoneBook.entrySet()) {
                if (entry.getValue().equals(searchName)) {
                    total.append(entry.getKey().toString()) .append(", ");
                }
            } total.insert(0, searchName + " - ");
            allContacts.add(total.substring(0,total.length()-2));
        }return allContacts;
    }
}
