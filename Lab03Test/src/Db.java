public class Db {
    private String dbName;
    private double balance = 0.0;

    public Db(String dbName) {
        this.dbName = dbName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance += amount;
    }

    public boolean verify(int acct, String pw) {
        return true;
    }
}
