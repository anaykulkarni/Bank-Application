/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anay
 */
public class BankTest {
    
    Bank bank;
    Account a1;
    Account a2;
    Account a3;
    Account a4;
    Account a5;
    
    public BankTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bank = new Bank();
        a1 = new Account( 10101, "A", "adr1", 30345.99);
        a2 = new Account( 10102, "B", "adr2", 76119.93) ;
        a3 = new Account( 10103, "C", "adr3", 8257.94);
        a4 = new Account( 10104, "D", "adr4", 5724.23);
        a5 = new Account( 10105, "E", "adr5", 724475.78);
                        
        bank.getAccounts().add(a1);
        bank.getAccounts().add(a2);
        bank.getAccounts().add(a3);
        bank.getAccounts().add(a4);
        bank.getAccounts().add(a5);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void transferTest1(){
        bank.transfer(a1, a2, 3244.52);
        assertEquals(27101.47, a1.getBalance(), 0.000001);
        assertEquals(79364.45, a2.getBalance(), 0.000001);
    }
    
    @Test
    public void transferTest2(){
        bank.transfer(a4, a3, 100.0);
        assertEquals(5624.23, a4.getBalance(), 0.000001);
        assertEquals(8357.94, a3.getBalance(), 0.000001);
    }
    
    @Test
    public void transferTest3(){
        bank.transfer(a3, a2, 13244.52);
        assertEquals(8257.94, a3.getBalance(), 0.000001);
        assertEquals(76119.93, a2.getBalance(), 0.000001);
    }
    
    @Test
    public void transferTest4(){
        bank.transfer(a5, a4, 700000.78);
        assertEquals(24475.0, a5.getBalance(), 0.000001);
        assertEquals(705725.01, a4.getBalance(), 0.000001);
        bank.transfer(a4, a3, 13244.52);
        assertEquals(692480.49, a4.getBalance(), 0.000001);
        assertEquals(21502.46, a3.getBalance(), 0.000001);
    }
    
    @Test
    public void findRichestPersonTest1(){
        assertEquals(a5, bank.findRichestPerson());
    }
    
    @Test
    public void findRichestPersonTest2(){
        bank.transfer(a5, a4, 700000.78);
        assertEquals(24475.0, a5.getBalance(), 0.000001);
        assertEquals(705725.01, a4.getBalance(), 0.000001);
        assertEquals(a4, bank.findRichestPerson());
    }
    
    @Test
    public void calculateTotalMoneyTest1(){
        assertEquals(844923.87, bank.calculateTotalMoney(), 0.000001);
    }
    
    @Test
    public void calculateTotalMoneyTest2(){
        a2.withdraw(34454.45);
        assertEquals(810469.42, bank.calculateTotalMoney(), 0.000001);
    }
}
