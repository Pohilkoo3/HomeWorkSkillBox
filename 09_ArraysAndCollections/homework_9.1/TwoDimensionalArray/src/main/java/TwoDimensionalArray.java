public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char[][] test = new char[size][size];
        for (int i = 0; i < test.length; i++){
            for (int j = 0; j < test[i].length; j++){
                if (i == j || j == test[i].length-1-i){
                    test[i][j] = 'X';
                } else {
                    test[i][j] = ' ';
                }
            } System.out.println(test[i]);
        }
        return test;
    }
}
