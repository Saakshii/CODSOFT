package codsoft;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        int m1,m2,m3,m4,m5,total;
        float per;
        char grade = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the marks out of 100");
        System.out.println("Enter the marks of Maths");
        m1= scan.nextInt();
        System.out.println("Enter the marks of Science");
        m2= scan.nextInt();
        System.out.println("Enter the marks of English");
        m3= scan.nextInt();
        System.out.println("Enter the marks of Marathi");
        m4= scan.nextInt();
        System.out.println("Enter the marks of Sanskrit");
        m5= scan.nextInt();
        total=m1+m2+m3+m4+m5;
        per=total/5;
        if(per>90){
            grade='A';
        }else if(per>80 && per<90){
            grade = 'B';
        }
        else if(per>70 && per<80){
            grade = 'C';
        }else if(per>60 && per<70){
            grade = 'D';
        }
        else{
            grade='E';
        }
        
        System.out.println("The Total Marks is: "+total);
        System.out.println("The Percentage is: " + per + "%");
        System.out.println("You got Grade "+grade);
    }
}
