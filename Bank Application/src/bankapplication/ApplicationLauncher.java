/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.util.Scanner;

/**
 * The class ApplicationLauncher launches the bank application and displays a menu of the services provided by the bank.
 * 
 * @version     1.1 30 May 2018
 * @author      Anay Kulkarni
 */
public class ApplicationLauncher {
    /* Creates a Bank object and calls appropriate methods based on the user input.*/
    
    /**
     * This method simply prints the menu of Bank services 
     * along with a prompt for user's choice, on standard output.
     */
    public static void displayBankMenu() {
        System.out.println("----------------------MENU--------------------");
        System.out.println("1. Create Account. \n2. Access Account\n3. Total Money in Bank\n4. Richest Person\n5. Exit");
        System.out.println("----------------------------------------------");
        System.out.println("Enter your choice: ");
    }
    
    /**
     * This is the main method, where the program execution begins.
     * the method creates a bank object, calls the displayBankMenu method
     * and scans the user input.
     * A switch block is used to exercise the user's choice.
     * @param args Unused
     */
    public static void main(String[] args) {
        Bank myBank = new Bank();
        int choice;
        while(true){
            displayBankMenu();
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();

            switch(choice)
            {
            case 1: 
                myBank.createAccount();                 //calls the createAccount method in the Bank class.
                break;
            case 2:
                myBank.accessAccount();                 //calls the accessAccount method in the Bank class.
                break;
            case 3:
                myBank.calculateTotalMoney();           //calls the calculateTotalMoney method in the Bank class.
                break;
            case 4:
                myBank.findRichestPerson();             //calls the findRichestPerson method in the Bank class.
                break;
            case 5:
                return;                                 //exit from main.
                
            default: System.out.println("You entered a wrong choice!");
            }//switch ends
        }//while ends
    }//end of main 
}
