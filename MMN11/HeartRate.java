package MMN11;

import java.util.Scanner;
/**
 * The Heart Rate class prints the Desired heart rate.
 * @author Shlomi Shabat
 * @version v.0.0.1
 */
public class HeartRate {
        /**
         * Gets the age from user.
         * calculates the top rate size.
         * calculates the lowest rate size.
         * print the top and lowest rate size.
         */
    public static void main (String[]args){
    
        Scanner scan = new Scanner(System.in);
        int age ,topRate,lowestRate;
        final int TOP_HEART_RATE=85, LOWEST_HEART_RATE=65;
        final int CONST=220;
        //Gets the age from the user
        System.out.println("This program calculates your " +
        "target heart rate while exercising.");
        System.out.print("Enter your age:");
        age = scan.nextInt();
        //calculates the top and lowest rate size
        age =(CONST-age);
        topRate=(age*TOP_HEART_RATE/100);//top rate size
        lowestRate=(age*LOWEST_HEART_RATE/100);//lowest rate size
        //output
        System.out.println("Your estimated target heart rate"+
        " zone is "+lowestRate+" – "+topRate+
        " beats per minute.");
    } // end of method main
}//end of class HeartRate
