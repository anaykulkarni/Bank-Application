/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;
import java.util.Scanner;

/**
 * The class Account contains methods to perform the basic operations of an account
 * such as depositing and withdrawal of money.
 * 
 * @version     1.1 30 May 2018
 * @author      Anay Kulkarni
 */
public class Account {
    
    private int accountNumber;
    private String accHolderName;
    private String accHolderAddr;
    private double balance;
    private Scanner scan = new Scanner(System.in);
    
    /**
     * This constructor initializes the account with the details of the holder
     * and with a minimum balance of Rs.500.0/-.
     * @param accNo This is the account number of the account
     * @param name Name of the account holder.
     * @param addr Address of the account holder.
     * @param bal Balance in the account.
     */
    public Account(int accNo, String name, String addr, double bal){
        accountNumber = accNo;
        accHolderName = name;
        accHolderAddr = addr;
        balance = bal;
    }
    
    /**
     * This methods gets the current balance in the account.
     * @return current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * This method sets the account balance to the value of the parameter
     * @param balance The balance value to be set.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * This method returns the account number.
     * @return Account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * This method returns the account holders name.
     * @return The account holders name.
     */
    public String getAccHolderName() {
        return accHolderName;
    }

    /**
     * This method returns the address of the account holder.
     * @return Account holders address.
     */
    public String getAccHolderAddr() {
        return accHolderAddr;
    }
    
    /**
     * This method reads the amount to be deposited or withdrawn, from the standard input.
     * @return amount to be deposited/withdrawn.
     */
    public double getAmount(){
        System.out.println("Enter the amount: ");
        double amt = scan.nextDouble();
        return amt;
    }
    
    /**
     * This method deposits amount in the account.
     * The amount to be deposited is taken as user input. 
     * The balance after depositing is displayed on the standard output.
     */
    public void deposit(double amt){
        this.balance += amt;
        System.out.println("\nAmount successfully deposited. Current balance : Rs." + this.balance + "/- \n");
    }
    
    /**
     * This method withdraws amount from the account.
     * the amount to be withdrawn is taken as user input. 
     * Only if a balance greater than Rs.500.0/- can be retained, can the withdrawal succeed.
     * The balance after depositing is displayed on the standard output.
     */
    public void withdraw(double amt){
        if( (this.balance - amt) >= 500 ){
            this.balance -= amt;
            System.out.println("\nAmount successfully withdrawn. Current balance : Rs." + this.balance + "/- \n");
        }
        else{
            System.out.println("ERROR3: Insufficient Balance. Minimum balance of Rs.500/- is mandatory.");
            return;
        }
    }
    
    /**
     * This method displays the current balance on the standard output.
     */
    public void checkBalance(){
        System.out.println("The current Balance is: Rs." + this.balance + "/-\n");
    }
   
}