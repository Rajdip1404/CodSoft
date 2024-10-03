import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }
}
class ATM {
    private BankAccount acc;
    private Scanner sc;
    public ATM(BankAccount acc) {
        this.acc = acc;
        this.sc = new Scanner(System.in);
    }
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
    private void checkBalance() {
        System.out.println("Current balance: $" + acc.getBalance());
    }
    private void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = sc.nextDouble();
        acc.deposit(amount);
    }
    private void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = sc.nextDouble();
        acc.withdraw(amount);
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance of $1000
        BankAccount acc = new BankAccount(1000.00);

        // Create an ATM and link it with the bank account
        ATM atm = new ATM(acc);
        atm.start();
    }
}
