class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void debit(int amount) {
        balance -= amount;
    }

    public void credit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        // Assuming each account has a unique ID
        return System.identityHashCode(this);
    }
}

public class Set2 {
    public static void transfer(Account from, Account to, int amount) {
        Account first = from;
        Account second = to;

        // Ensure the consistent locking order
        if (from.getId() > to.getId()) {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {
                from.debit(amount);
                to.credit(amount);
            }
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account(1000);
        Account account2 = new Account(2000);

        System.out.println("Initial balances:");
        System.out.println("Account 1: " + account1.getBalance());
        System.out.println("Account 2: " + account2.getBalance());

        transfer(account1, account2, 300);

        System.out.println("Balances after transfer:");
        System.out.println("Account 1: " + account1.getBalance());
        System.out.println("Account 2: " + account2.getBalance());
    }
}
