public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());


        System.out.println(getNumberChar('А'));
        System.out.println(getNumberChar('я'));
        System.out.println(getNumberChar('Ё'));
        System.out.println(getNumberChar('ё'));

        /*for (int i = 0; i <= 65535; i++) {//цикл для вывода символов и их номеров
            char y = (char) i;
            System.out.println(i + " - " + y);*/

    }


        public static int getNumberChar(char symbol) {//сделал метод, который перебирает символы и возвращает номер необходимого
            int i = 0;
            for (; i < 65_535; i++) {
                if ((char) i == symbol) {
                    break;
                }
            }return i;
        }
    }

