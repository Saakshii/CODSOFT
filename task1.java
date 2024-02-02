package codsoft;

import java.util.Random;
import java.util.Scanner;

public class task1 {

    public static void main(String args[])
    {
        // create instance of Random class
        Random rand = new Random();

        Scanner sc = new Scanner(System.in);
        int rounds=0;
        int count=0;
        boolean playAgain=true;
        while(playAgain) {
            // Generate random integers in range 0 to 100
            int rand_int = rand.nextInt(100)+1;
            System.out.println("Guess the number between 1 and 100");
            int attempt=0;
            while(attempt<5){
                int num=sc.nextInt();
                attempt++;
                count++;
                if (rand_int > num) {
                    System.out.println("Number is Greater than your number");
                } else if (rand_int < num) {
                    System.out.println("Number is Less than your number");
                } else {
                    System.out.println("Congratulations! You find number in the number in "+attempt+" attempts");
                    rounds++;
                    break;
                }
            }
            //Limit the user to maximum 5 attempts
            if(attempt==5){
                System.out.println("You have reached final limit");
            }
            System.out.println("Do you want to Play Again?(Yes/No)");
            String playChoice = sc.next();
            if(playChoice.equalsIgnoreCase("no")){
                playAgain=false;
            }
        }
        System.out.println("Total Score: "+count);
        System.out.println("Rounds Won: "+rounds);
    }
}


