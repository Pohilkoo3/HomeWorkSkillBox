public class Account implements Comparable<Account> {
    private boolean lock;
    private long money;
    private final String accNumber;

    public Account(String accNumber) {
        this.accNumber = accNumber;
    }

    public long getMoney() {
        return money;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }


    @Override
    public String toString() {
        return "Account " + accNumber + " => " + money;
    }

    @Override
    public int compareTo(Account o) {
        if (Integer.parseInt(this.getAccNumber()) > Integer.parseInt(o.getAccNumber())) {
            return 1;
        } else if (Integer.parseInt(this.getAccNumber()) < Integer.parseInt(o.getAccNumber())) {
            return -1;
        }
        return 0;
    }
}
