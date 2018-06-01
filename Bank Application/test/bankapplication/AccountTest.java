/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The class AccountTest contains test cases for the class Account.
 * 
 * @version     1.0     31 May 2018
 * @author      Anay Kulkarni
 */
public class AccountTest {
    
    Account acc;
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        acc = new Account( 10101, "Anay", "Belgaum", 500);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void depositTest1() {
        acc.deposit(200.0);
        Assert.assertEquals(700.0, acc.getBalance(), 0.000001);
    }
    @Test
    public void depositTest2() {
        acc.deposit(3485.137);
        Assert.assertEquals(3985.137, acc.getBalance(), 0.000001);
    }
    
    @Test
    public void depositTest3() {
        acc.deposit(0.0);
        Assert.assertEquals(500.0, acc.getBalance(), 0.000001);
    }
    @Test
    public void depositTest4() {
        acc.deposit(3485.137);
        Assert.assertEquals(3985.137, acc.getBalance(), 0.000001);
        acc.deposit(387.23);
        Assert.assertEquals(4372.367, acc.getBalance(), 0.000001);
        acc.deposit(9584.33);
        Assert.assertEquals(13956.697, acc.getBalance(), 0.000001);
    }
    
    @Test
    public void withdrawTest1() {
        acc.withdraw(200.0);
        Assert.assertEquals(500.0, acc.getBalance(), 0.000001);
    }
    
    @Test
    public void withdrawTest2() {
        acc.deposit(200.0);
        acc.withdraw(100.0);
        Assert.assertEquals(600.0, acc.getBalance(), 0.000001);
    }
    
    @Test
    public void withdrawTest3() {
        acc.deposit(4839.049);
        acc.withdraw(1200.0);
        Assert.assertEquals(4139.049, acc.getBalance(), 0.000001);
        acc.withdraw(178.87);
        Assert.assertEquals(3960.179, acc.getBalance(), 0.000001);
        acc.withdraw(4000.0);
        Assert.assertEquals(3960.179, acc.getBalance(), 0.000001);
    }
    
    @Test
    public void withdrawTest4() {
        acc.deposit(200.0);
        acc.withdraw(100.0);
        Assert.assertEquals(600.0, acc.getBalance(), 0.000001);
        acc.withdraw(100.0);
        Assert.assertEquals(500.0, acc.getBalance(), 0.000001);
    }
}
