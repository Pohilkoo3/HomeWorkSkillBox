public class Arithmetic {
    private int a;
    private int b;

    Arithmetic (int a, int b){
        this.a = a;
        this.b = b;
    }

    public int summ(){
       int summ = a+b;
        System.out.println("a+b=" + summ);
        return summ;
    }

    public int mult () {
        int mult = a*b;
        System.out.println("a*b=" + mult);
        return mult;
    }

    public  int findMax () {
        if (a>=b){
            System.out.println("a>b!");
            return a;
        } System.out.println("b>a");
        return b;
    }

    public  int findMin () {
        if (a<=b){
            System.out.println("a<b");
            return a;
        }
        System.out.println("b<a");
        return b;
    }


}
