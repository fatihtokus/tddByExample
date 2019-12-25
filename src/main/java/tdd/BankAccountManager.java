package tdd;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    private int balance;
    private List<Integer> transactions = new ArrayList<Integer>();
    public BankAccountManager(int balance) {
        this.balance = balance;
    }

    public Object withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            transactions.add(amount);
            return "OK";
        }

        return "NO_SUFFICIENT_BALANCE";
    }

    public int balance() {
        return balance;
    }

    public Object transactions() {
        return transactions;
    }
}
