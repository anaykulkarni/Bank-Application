/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class Bank contains the methods for the basic operations of Bank.
 * A Bank object maintains an ArrayList of Account objects
 * 
 * @version     1.1 30 May 2018
 * @author      Anay Kulkarni
 */
public class Bank {
    
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private static int accNumberCount = 10101;
    private static int numberOfAccounts = 0;
    private Scanner scan = new Scanner(System.in);
    
    /**
     * This method simply prints the menu of services available to an account holder.
     * A prompt is displayed for the user to input his/her choice.
     */
    private static void displayAccountMenu(){
        System.out.println("\n----------------------MENU--------------------");
        System.out.println("1. Deposit \n2. Withdraw\n3. Transfer\n4. Check Balance\n5. Exit account");
        System.out.println("------------------------------------------------");
        System.out.println("Enter your choice: ");
    }
    
    /**
     * This method creates an Account object and initializes it with the account details.
     * After the account is created, the details of the account are displayed.
     */
    public void createAccount(){
        String name;
        String addr;
        System.out.print("Enter your Name: \n");
        name = scan.nextLine();
        System.out.print("Enter your Address: \n");
        addr = scan.nextLine();
        
        Account a = new Account( accNumberCount++, name, addr, 500.0 );         //calls the constructor from Account class.
        accounts.add(a);
        
        numberOfAccounts++;
        System.out.println("-----------Account Successfully created!------------");
        System.out.println("Account No.: " + a.getAccountNumber() );
        System.out.println("      Name : " + a.getAccHolderName() );
        System.out.println("   Address : " + a.getAccHolderAddr() );
        System.out.println("   Balance : " + a.getBalance() );
        System.out.println("----------------------------------------------------\n");
    }
    
    /**
     * This method allows the users to access their accounts by providing the Account Number.
     */
    public void accessAccount(){
        System.out.println("Enter your Account Number: ");
        int accNum = scan.nextInt();
        if( accNum >= 10101 && (accNum < accounts.size()+10101 )){
            getUserAccount(accNum);                                                      //account found. Calls the getUserAccount method.
        } else {
            System.out.println("\nERROR: Invalid Account number\n");            //acccount doesn't exist.
        }
    }
    
    /**
     * This method searches the account of the user in the ArrayList of accounts and displays it.
     * Calls displayAccountMethod to display the account menu and gets user choice.
     * Based on the choice, appropriate methods are called to avail the services. 
     * @param accNum This is the Account Number of the user whose account is to be accessed.
     */
    public void getUserAccount(int accNum){
        Account userAccount = null;
        int i;
        for(i=0; i<accounts.size() ; i++)
            if(accounts.get(i).getAccountNumber() == accNum){
                userAccount = accounts.get(i);                                  // gets the account from the list.
                break;
            }
        if(i >= accounts.size()){
            System.out.println("ERROR2: Account not found! \n\n");
            return;
        }
        
        System.out.println("\n\n----------------------------------------------------");
        System.out.println("ACCOUNT NO. : "+ userAccount.getAccountNumber() + "     NAME: " + userAccount.getAccHolderName());
        System.out.println("----------------------------------------------------\n");
        
        while(true){
            displayAccountMenu();                                               //displays the menu of available services.
            int choice = scan.nextInt();                                        //get User choice
            switch(choice)
            {
            case 1: 
                userAccount.deposit( userAccount.getAmount());                                          
                break;
            case 2:
                userAccount.withdraw( userAccount.getAmount());
                break;
            case 3: 
                this.transfer(userAccount, getOtherAccount(), readAmountToBeTransfered());
                break;
            case 4: 
                userAccount.checkBalance();
                break;
            case 5:
                return;
            default: System.out.println("You entered a wrong choice!");
            }
        }
    }
    
    /**
     * This method gets the account number of the other account where money is to be transfered.
     * @return the other Account.
     */
    public Account getOtherAccount(){
        System.out.println("Enter the other account number: ");
        int otherAccNum = scan.nextInt();
        Account otherAccount = null;
        int j;
        for(j=0; j < accounts.size(); j++)                                      //searches the account in the ArrayList.
            if(accounts.get(j).getAccountNumber() == otherAccNum){
                otherAccount = accounts.get(j);
                break;
            }
        if(j >= accounts.size()){
            System.out.println("ERROR2: Account not found! \n\n");
            return getOtherAccount();
        }
        return otherAccount;
    }
    
    /**
     * This method reads the amount to be transfered from standard input.
     * @return amount to be transfered
     */
    public double readAmountToBeTransfered(){
        System.out.println("Enter the amount to be transfered: ");
        double amt = scan.nextDouble();
        return amt;
    }
    
    /**
     * This method performs the transaction of transferring money to another account.
     * The method gets the other account number from the user as input
     * and transfers the amount specified.
     * @param userAccount This is the account of the user who wants to perform the transfer.
     */
    public void transfer(Account userAccount, Account otherAccount, double amt){
        if( (userAccount.getBalance() - amt) >= 500 ){
            userAccount.setBalance( userAccount.getBalance() - amt );
            otherAccount.setBalance( otherAccount.getBalance() + amt );
        }
        else{
            System.out.println("ERROR3: Insufficient Balance. Minimum balance of Rs.500/- is mandatory.");
            return;
        }
    }
    
    /**
     * This method calculates the total money available with the bank.
     * @return Total money available in the bank.
     */
    public double calculateTotalMoney(){
        double sum=0;
        for(Account a : accounts ){
            sum += a.getBalance();
        }
        System.out.println("The total money in the Bank is: Rs." + sum + "/-");
        return sum;
    }
    
    /**
     * This method identifies the richest account holder in the bank. 
     * @return Account having the highest balance.
     */
    public Account findRichestPerson(){
        double maxbal=0.0;
        Account richest=null;
        for(Account a : accounts ){
            if(maxbal < a.getBalance()){
                maxbal = a.getBalance();
                richest = a;
            }
        }
        System.out.println("The Richest person in the Bank is " + richest.getAccHolderName() + 
                ", whose account number is " + richest.getAccountNumber() + ", with a balance of Rs." + 
                richest.getBalance() + "/- ");
        return richest;
    }
    
    /**
     * This method gets the ArrayList of Accounts in the bank
     * @return the ArrayList of accounts.
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

}
