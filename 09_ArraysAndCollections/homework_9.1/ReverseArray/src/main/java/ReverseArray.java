public class ReverseArray {

<<<<<<< HEAD

    public static String[] reverse (String[] strings){
        for (int i = 0; i < strings.length / 2; i++) {
            String temp = strings[i];
            strings[i] = strings[strings.length-1-i];
            strings[strings.length-1-i] = temp;
        }
=======
    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
>>>>>>> f110056b24800c35d3a7bf0ea7d5366e45370773
        return strings;
    }
}
