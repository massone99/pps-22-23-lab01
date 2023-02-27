package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {
    private final int ATM_FEE = 1;
    private final AccountHolder accountHolder;
    private double balance = 0;

    public SimpleBankAccountWithAtm(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public AccountHolder getHolder() {
        return this.accountHolder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (isUserIdCorrect(userID)) {
            this.balance += amount;
            this.balance -= ATM_FEE;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (isUserIdCorrect(userID)) {
            if (isWithdrawAllowed(amount)) {
                this.balance -= amount;
                this.balance -= ATM_FEE;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private boolean isWithdrawAllowed(double amount) {
        return this.balance > amount;
    }

    private boolean isUserIdCorrect(int userId) {
        return this.accountHolder.getId() == userId;
    }
}
