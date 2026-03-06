import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private String pin;
    private Customer owner;
    private List<Transaction> history;

    public Account() {
        this.history = new ArrayList<>();
    }

    public Account(String accountNumber, Customer owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0.0;
        this.history = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add(new Transaction("DEPOSIT", amount));
            System.out.println("Deposit berhasil!");
        } else {
            System.out.println("Error: Nominal harus > 0");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add(new Transaction("WITHDRAW", amount));
            System.out.println("Withdraw berhasil!");
        } else {
            System.out.println("Error: Saldo tidak mencukupi atau nominal salah.");
        }
    }

    public void setPin(String pin) {
        if (pin != null && pin.matches("\\d{6}")) {
            this.pin = pin;
        } else {
            System.out.println("Error: PIN harus 6 digit angka.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        }
        else {
            for (Transaction t : history) {
                t.display();
            }
        }
    }

}