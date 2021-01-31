/* Author: Sami Cortes
 * Course: Object-Oriented Programming
 * Instructor: Lisa Minogue
 * Due date: 01/30/2021
 */

import java.util.Scanner;
public class BankAccount {
    
    public static void main(String[] args) {
        collection();
    }

    static boolean checkSocialFormat(String socialNum) {
        if (socialNum.matches("\\d{3}-\\d{2}-\\d{4}")) {
            return true;
        }else {
            return false;
        }

    }
    
    static boolean checkInfo(String value) {
        System.out.println(value);
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void collection() {

        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to our bank!");
        System.out.println("Please enter your personal details");

        String fullName = null;
        String address = null;
        String city = null;
        String state = null;
        String socialNum = null;
        int zipCode;
     
        

            System.out.print("Name: ");
            fullName = scnr.next();
         
            System.out.print("Address: ");
            address = scnr.next();
            
            System.out.print("City: ");
            city = scnr.next();
            System.out.print("State: ");
            state = scnr.next();

        //Input validation for zipCode and socialNum
        do {
            System.out.print("Zip Code (5 digits): ");
            zipCode = scnr.nextInt();
            if (zipCode > 99999 || zipCode < 10000) {
                System.out.println("Zip Code must be 5 digits");
            }
        } while (zipCode > 99999 || zipCode < 10000);
        
        do {
            if(socialNum != null) {
                System.out.println("Social Security Number is invalid. Must be in 999-99-9999");
            }
            System.out.print("Social Security Number (999-99-9999): ");
            socialNum = scnr.next();
        } while(!checkSocialFormat(socialNum));
        
        congrats();
        
        personalAccount(fullName, address, city, state, socialNum, zipCode);
        
    }

    //Method for approval of account
    public static void congrats() {
    	System.out.println("----------------------------------------");
        System.out.println(" Congratulations! You have been approved");
        System.out.println("----------------------------------------");
    }
    
    public static int hundredBillCount(Double totalWithdraw) {
    	
    	int hundredBills = 0;
    	
    	
    	if(totalWithdraw >= 100) {
    		hundredBills = (int) (totalWithdraw / 100);
    	}
    	return hundredBills;
    
    	
    }
    
    public static int twentyBillCount(Double currentBalance) {
    	
    	int twentyBills = 0;
    	
    	
    	if(currentBalance >= 20) {
    		twentyBills = (int) (currentBalance / 20);
    	}
    	return twentyBills;
    	
    }
    
    public static int tenBillCount(Double totalWithdraw) {
    	
    	int tenBills = 0;
    	
    	
    	if(totalWithdraw >= 10) {
    		tenBills = (int) (totalWithdraw / 10);
    	}
    	return tenBills;
    	
    }
    
    public static int fiveBillCount(Double totalWithdraw) {
    	
    	int fiveBills = 0;
    	
    	
    	if(totalWithdraw >= 5) {
    		fiveBills = (int) (totalWithdraw / 5);
    	}
    	return fiveBills;
    	
    }
    
    public static int onesBillCount(Double totalWithdraw) {
    	
    	int onesBills = 0;
    	
    	
    	if(totalWithdraw >= 1) {
    		onesBills = (int) (totalWithdraw / 1);
    	}
    	return onesBills;
    	
    }
    
    
   
    public static void personalAccount(String fullName, String address, String city, String state, String socialNum, int zipCode)  {
    	Double startBalance = null;
    	Double deposit;
    	Double firstWithdraw;
    	Double secondWithdraw;
    	Double currentBalance;
    	int numberOf100;
    	Double afterOneHundreds;
    	int numberOf20;
    	int numberOf10;
    	int numberOf5;
    	int numberOf1;
    	
    	
    	
    	Scanner scnr = new Scanner(System.in);
    
    	System.out.print("What is the beginning balance? $");
    	startBalance = scnr.nextDouble();
    	
    	System.out.print("Amount to deposit:  $");
    	deposit = scnr.nextDouble();
    	
    	System.out.print("Amount to withdraw: $");
    	firstWithdraw = scnr.nextDouble();
    	
    	System.out.print("Amount to Withdraw: $");
    	secondWithdraw = scnr.nextDouble();
    	
    	currentBalance = startBalance + deposit - firstWithdraw - secondWithdraw;
    	
    	if ((firstWithdraw + secondWithdraw) > startBalance) {
    		System.out.print("Insufficient funds");
    		System.exit(0);
 
    	}
    	
    	
    	numberOf100 = hundredBillCount(currentBalance);
    	
    	afterOneHundreds  =  (currentBalance - (numberOf100 * 100));
    	
    	numberOf20 = twentyBillCount(afterOneHundreds);
    	
    	afterOneHundreds = (afterOneHundreds - (numberOf20 * 20));
    	
    	numberOf10 = tenBillCount(afterOneHundreds);
    	
    	afterOneHundreds = (afterOneHundreds - (numberOf10 * 10));
    	
    	numberOf5 = fiveBillCount(afterOneHundreds);
    	
    	afterOneHundreds = (afterOneHundreds - (numberOf5 * 5));
    	
    	numberOf1 = onesBillCount(afterOneHundreds);
    	
    	afterOneHundreds = (afterOneHundreds - (numberOf1 * 1));
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	System.out.println("******************************");
    	System.out.println("\tAccount Information");
    	System.out.println("******************************");
    	
    	System.out.println("Profile: ");
    	System.out.println("------------------ ---------------- --------------");
    	System.out.println("------------------ ----  ---------- ");
    	System.out.println("Name\t\t Address\t\t City\t\t State");
    	System.out.println("\t\t Zip Code \t SSN");
    	System.out.println("------------------ ---------------- --------------");
    	System.out.println("------------------ ----  ---------- ");
    	
    	System.out.println(fullName.toUpperCase()+ "\t\t" + address + "\t\t" + city + "\t\t" + state);
    	System.out.println("\t\t" + zipCode + "\t" + socialNum);
    	
    	System.out.println("------------------ ---------------- --------------");
    	System.out.println("------------------ ----  ---------- ");
    	System.out.println("******************************");
    	
    	System.out.println("Account Summary");
    	System.out.println("\t\tInitial Balance: $");
    	System.out.printf("%.2f", startBalance);
    	System.out.println("\t\tDeposit: $");
    	System.out.printf("%.2f", deposit);
    	System.out.println();
    	System.out.print("\t\tWithdraw: $");
    	System.out.printf("%.2f", firstWithdraw);
    	System.out.println();
    	System.out.print("\t\tWithdraw: $");
    	System.out.printf("%.2f", secondWithdraw);
    	System.out.println();
    	System.out.print("\t\tCurrent Balance: ");
    	System.out.printf("%.2f", currentBalance);
    	System.out.println();
    	
    	System.out.println("******************************");
    
    	
    	System.out.println("Bill count: ");
    	System.out.println("$100 Bills: " + numberOf100);
    	System.out.println(" $20 Bills: " + numberOf20);
    	System.out.println(" $10 Bills: " + numberOf10);
    	System.out.println("  $5 Bills: " + numberOf5);
    	System.out.println("  $1 Bills: " + numberOf1);
    	System.out.print("     Cents: ");
    	System.out.printf("%.2f", afterOneHundreds);






    }
}
