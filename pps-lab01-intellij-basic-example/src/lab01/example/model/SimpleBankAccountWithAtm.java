package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {
    private final int ATM_FEE = 1;
    private final SimpleBankAccount bankAccount;

    public SimpleBankAccountWithAtm(AccountHolder accountHolder) {
        this.bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Override
    public AccountHolder getHolder() {
        return this.bankAccount.getHolder();
    }

    @Override
    public double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        this.bankAccount.deposit(userID, amount);
        payAtmFee(userID);
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (getBalance() >= (amount + ATM_FEE)) {
            this.bankAccount.withdraw(userID, amount);
            payAtmFee(userID);
        } else {
            throw new IllegalStateException();
        }
    }

    private void payAtmFee(int userID) {
        this.bankAccount.deposit(userID, (ATM_FEE * -1));
    }

}
