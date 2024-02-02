package codsoft;

import java.util.Scanner;

class User{
    public double balance;
    User(double balance){
        this.balance=balance;
    }
    public void withdraw(double amt){
        if(amt<= balance){
            balance-=amt;
            System.out.println("Withdrawal of Rs."+amt+" and remaining balance is Rs."+balance);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    public void deposit(double amt) {
        balance+=amt;
        System.out.println("Deposit of Rs."+amt+" and balance is Rs."+balance);
    }
    public void checkBalance(){
        System.out.println("Balance is Rs."+balance);
    }
}
 class ATM {
    public static void main(String[] args) {
        User us = new User(10000);
        int choice;
        Scanner scan = new Scanner(System.in);
        double amount;
        System.out.println("1.Withdraw \n2.Deposit \n3.Check Balance \nEnter Choice ");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter Amount to be Withdraw");
                amount = scan.nextDouble();
                us.withdraw(amount);
                break;
            case 2:
                System.out.println("Enter Amount to be Deposit");
                amount = scan.nextDouble();
                us.deposit(amount);
                break;
            case 3:
                us.checkBalance();
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
