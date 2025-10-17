package org.example.solution;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Level2BankExercise
 */
public class Level2BankExerciseTest {

    @Test
    void testSavingsAccountInitialization() {
        SavingsAccount account = new SavingsAccount("S123", "John Doe", 1000, 0.05);
        assertEquals(1000, account.getBalance(), "Initial balance should be set correctly");
        assertEquals("Account: S123, Owner: John Doe, Balance: $1000.0", 
                    account.getAccountInfo(), "Account info should display correctly");
    }

    @Test
    void testCheckingAccountInitialization() {
        CheckingAccount account = new CheckingAccount("C456", "Jane Smith", 500, 100);
        assertEquals(500, account.getBalance(), "Initial balance should be set correctly");
        assertEquals("Account: C456, Owner: Jane Smith, Balance: $500.0", 
                    account.getAccountInfo(), "Account info should display correctly");
    }

    @Test
    void testDeposit() {
        SavingsAccount account = new SavingsAccount("S123", "John Doe", 1000, 0.05);
        
        // Test valid deposit
        account.deposit(200);
        assertEquals(1200, account.getBalance(), "Balance should increase after deposit");
        
        // Test invalid deposit
        account.deposit(-50);
        assertEquals(1200, account.getBalance(), "Balance should not change with invalid deposit");
    }

    @Test
    void testSavingsAccountWithdraw() {
        SavingsAccount account = new SavingsAccount("S123", "John Doe", 1000, 0.05);
        
        // Test valid withdrawals within limit
        assertTrue(account.withdraw(100), "Valid withdrawal should return true");
        assertEquals(900, account.getBalance(), "Balance should decrease after withdrawal");
        
        assertTrue(account.withdraw(100), "Second withdrawal should succeed");
        assertEquals(800, account.getBalance());
        
        assertTrue(account.withdraw(100), "Third withdrawal should succeed");
        assertEquals(700, account.getBalance());
        
        // Test withdrawal limit
        assertFalse(account.withdraw(100), "Fourth withdrawal should fail due to limit");
        assertEquals(700, account.getBalance(), "Balance should remain unchanged after failed withdrawal");
        
        // Reset withdrawals and try again
        account.resetWithdrawals();
        assertTrue(account.withdraw(100), "Withdrawal after reset should succeed");
        assertEquals(600, account.getBalance());
    }
    
    @Test
    void testCheckingAccountWithdraw() {
        CheckingAccount account = new CheckingAccount("C456", "Jane Smith", 500, 100);
        
        // Test valid withdrawal
        assertTrue(account.withdraw(200), "Valid withdrawal should return true");
        assertEquals(300, account.getBalance(), "Balance should decrease after withdrawal");
        
        // Test withdrawal with overdraft
        assertTrue(account.withdraw(350), "Withdrawal within overdraft limit should succeed");
        assertEquals(-50, account.getBalance(), "Balance should go negative within overdraft limit");
        
        // Test withdrawal exceeding overdraft limit
        assertFalse(account.withdraw(100), "Withdrawal exceeding overdraft limit should fail");
        assertEquals(-50, account.getBalance(), "Balance should remain unchanged after failed withdrawal");
    }
    
    @Test
    void testSavingsAccountInterest() {
        SavingsAccount account = new SavingsAccount("S123", "John Doe", 1000, 0.05);
        
        account.applyMonthlyInterest();
        assertEquals(1050, account.getBalance(), 0.001, "Balance should increase by interest rate");
        
        // Test compound interest
        account.applyMonthlyInterest();
        assertEquals(1102.50, account.getBalance(), 0.001, "Interest should compound correctly");
    }
}