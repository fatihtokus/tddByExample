package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class BankAccountManagerTest {
    BankAccountManager bankAccountManager;

    @BeforeEach
    public void setUp() {
        bankAccountManager = new BankAccountManager(400);
    }

    @Test
    public void thereIsSufficientBalance() {
        Assertions.assertEquals("OK", bankAccountManager.withdraw(50), "There is no sufficient balance");
        Assertions.assertEquals(350, bankAccountManager.balance(), "The balance is not 350");

        Assertions.assertEquals("OK", bankAccountManager.withdraw(350), "There is no sufficient balance");
        Assertions.assertEquals(0, bankAccountManager.balance(), "The balance is not 0");
    }

    @Test
    public void thereIsNoSufficientBalance() {
        Assertions.assertEquals("NO_SUFFICIENT_BALANCE", bankAccountManager.withdraw(450), "There is sufficient balance");
    }

    @Test
    public void transactions() {
        Assertions.assertEquals(Collections.EMPTY_LIST, bankAccountManager.transactions(), "The transactions are not empty");

        bankAccountManager.withdraw(10);
        bankAccountManager.withdraw(15);
        bankAccountManager.withdraw(20);
        Assertions.assertEquals(Arrays.asList(10, 15, 20), bankAccountManager.transactions());
    }
}
