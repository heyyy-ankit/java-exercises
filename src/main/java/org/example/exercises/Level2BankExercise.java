package org.example.exercises;

/**
 * Level 2 Exercise: Bank Account System
 * 
 * This exercise focuses on OOP concepts by implementing a simple bank account system.
 * Complete the classes and methods based on the specifications.
 */

// TODO: Implement this interface
interface Account {
    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    String getAccountInfo();
}

// TODO: Complete this abstract class
abstract class BankAccount implements Account {
    protected String accountNumber;
    protected double balance;
    protected String ownerName;
    
    // Constructor
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        
        // BUG: Fix the initialization of balance (it's setting to 0 instead of initialBalance)
        this.balance = 0;
    }
    
    @Override
    public void deposit(double amount) {
        // BUG: Fix the validation (it should check if amount > 0)
        if (amount < 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    @Override
    public boolean withdraw(double amount) {
        // Implementation goes here
        throw new UnsupportedOperationException("Method not implemented yet");
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
    
    @Override
    public String getAccountInfo() {
        return "Account: " + accountNumber + ", Owner: " + ownerName + ", Balance: $" + balance;
    }
}

// TODO: Implement this class 
class SavingsAccount extends BankAccount {
    private double interestRate;
    private int withdrawalsThisMonth;
    private final int MAX_WITHDRAWALS = 3;
    
    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
        this.withdrawalsThisMonth = 0;
    }
    
    // Implement a method to apply monthly interest to the balance
    public void applyMonthlyInterest() {
        // Implementation goes here
        throw new UnsupportedOperationException("Method not implemented yet");
    }
    
    // Override withdraw method to implement withdrawal limit
    @Override
    public boolean withdraw(double amount) {
        // Implementation goes here
        throw new UnsupportedOperationException("Method not implemented yet");
    }
    
    // Reset monthly withdrawals counter
    public void resetWithdrawals() {
        withdrawalsThisMonth = 0;
    }
}

// TODO: Implement this class
class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double overdraftLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    
    // Override withdraw method to implement overdraft limit
    @Override
    public boolean withdraw(double amount) {
        // Implementation goes here
        throw new UnsupportedOperationException("Method not implemented yet");
    }
}

// Main class for testing
public class Level2BankExercise {
    public static void main(String[] args) {
        // Uncomment these lines once you've implemented the classes
        /*
        SavingsAccount savings = new SavingsAccount("SAV001", "John Doe", 1000, 0.05);
        CheckingAccount checking = new CheckingAccount("CHK001", "Jane Smith", 500, 100);
        
        System.out.println("Initial accounts:");
        System.out.println(savings.getAccountInfo());
        System.out.println(checking.getAccountInfo());
        
        System.out.println("\nTesting deposits:");
        savings.deposit(200);
        checking.deposit(50);
        System.out.println(savings.getAccountInfo());
        System.out.println(checking.getAccountInfo());
        
        System.out.println("\nTesting withdrawals:");
        savings.withdraw(100);
        checking.withdraw(600);  // This should use the overdraft
        System.out.println(savings.getAccountInfo());
        System.out.println(checking.getAccountInfo());
        
        System.out.println("\nTesting withdrawal limits on savings:");
        savings.withdraw(50);
        savings.withdraw(50);
        savings.withdraw(50);  // This should fail due to withdrawal limit
        System.out.println(savings.getAccountInfo());
        
        System.out.println("\nApplying monthly interest:");
        savings.applyMonthlyInterest();
        System.out.println(savings.getAccountInfo());
        */
    }
}