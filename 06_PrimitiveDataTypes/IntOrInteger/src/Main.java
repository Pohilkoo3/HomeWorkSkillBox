public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        Main search = new Main();
        System.out.println(search.getNumberChar('А'));
        System.out.println(search.getNumberChar('я'));
        System.out.println(search.getNumberChar('Ё'));
        System.out.println(search.getNumberChar('ё'));

        /*for (int i = 0; i <= 65535; i++) {//цикл для вывода символов и их номеров
            char y = (char) i;
            System.out.println(i + " - " + y);*/

    }


        public int getNumberChar(char symbol) {//сделал метод, который перебирает символы и возвращает номер необходимого
            int i = 0;
            for (; i < 65_535; i++) {
                if ((char) i == symbol) {
                    break;
                }
            }return i;
        }
    }

