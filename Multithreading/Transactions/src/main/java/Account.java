public class Account {
    private volatile boolean lock;
    private volatile long money;
    private String accNumber;

    public synchronized long getMoney() {
        return money;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public synchronized void setMoney(long money) {
        if (lock){
            return;
        }
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    @Override
    public String toString() {
        return "Account " + accNumber + " => " + money;
    }


}
