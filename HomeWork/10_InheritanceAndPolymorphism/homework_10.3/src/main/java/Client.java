public abstract class Client {
    private double total;

    public abstract double getAmount();

    public abstract void put(double amountToPut);

    public abstract void take(double amountToTake);


    public abstract String toString();
}



