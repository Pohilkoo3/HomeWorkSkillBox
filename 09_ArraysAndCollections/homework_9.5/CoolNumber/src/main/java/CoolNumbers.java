import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < letters.length; m++) {
                            for (int n = 0; n < letters.length; n++) {
                                for (int o = 10; o <= 199 ; o++) {
                                    if (j == k && k == l && j != 0){
                                        String resultNumber = letters[i] + j + k + l + letters[m] +letters[n] + o;
                                        result.add(resultNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
      return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}
