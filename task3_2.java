package codsoft;
import java.util.Scanner;

import static codsoft.User1.balance;

class User1{
   static double balance=10000;
}
class ATM1 {
    public static void main(String[] args) {
        int choice;
        Scanner scan = new Scanner(System.in);
        double amount;

        System.out.println("1.Withdraw \n2.Deposit \n3.Check Balance \nEnter Choice ");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter Amount to be Withdraw");
                amount = scan.nextDouble();
                withdraw(amount);
                break;
            case 2:
                System.out.println("Enter Amount to be Deposit");
                amount = scan.nextDouble();
                deposit(amount);
                break;
            case 3:
                checkBalance();
                break;
            default:
                System.out.println("Invalid Choice");
        }

    }
    public static void withdraw(double amt){
        if(amt<= balance){
            balance-=amt;
            System.out.println("Withdrawal of Rs."+amt+" and remaining balance is Rs."+balance);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    public static void deposit(double amt) {
        balance+=amt;
        System.out.println("Deposit of Rs."+amt+" and balance is Rs."+balance);
    }
    public static void checkBalance(){
        System.out.println("Balance is Rs."+balance);
    }
}


