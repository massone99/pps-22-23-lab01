package lab01.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccount;

    @BeforeEach
    void setUp() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(accountHolder);
    }

    @Test
    void testGetHolder() {
        AccountHolder holder = this.bankAccount.getHolder();
        assertNotNull(holder);
    }

    @Test
    void testBalanceIsInitiallyZero() {
        double balance = this.bankAccount.getBalance();
        assertEquals(0, balance);
    }

    @Test
    void testDeposit() {
        this.bankAccount.deposit(accountHolder.getId(), 10);
        double balance = this.bankAccount.getBalance();
        assertEquals(9, balance);
    }

    @Test
    void testWithdraw() {
        this.bankAccount.deposit(accountHolder.getId(), 40);
        this.bankAccount.withdraw(accountHolder.getId(), 35);
        double balance = this.bankAccount.getBalance();

        assertEquals(3, balance);
    }

    @Test
    void testWithdrawWithAmountGreaterThanBalance() {
        assertThrows(IllegalStateException.class, () -> this.bankAccount.withdraw(accountHolder.getId(), 100));
    }

    @Test
    void testWithdrawEqualToBalance() {
        this.bankAccount.deposit(accountHolder.getId(), 2);
        assertThrows(IllegalStateException.class, () -> this.bankAccount.withdraw(accountHolder.getId(), 1));
    }
}