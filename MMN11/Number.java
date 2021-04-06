package MMN11;

import java.util.Scanner;
/**
 * The Number class The program prints the reverse sign,
 * or the reverse number or both at the user's choice for a 4-digit number.
 * @author Shlomi Shabat
 * @version v.0.0.1
*/

public class Number
{
     /**
         * Gets the 4-digit Number from user.
         * Verifies the legality of the number.
         * in case of illegal time - prints Selection menu:
         * 1.Reverse sign 2.Reverse number 3.Reverse sign and number.
         * calculates by user choice and prints The result.
         * otherwise - prints Invalid number message.
        */
    public static void main(String[]args){
        Scanner scan= new Scanner (System.in);
        System.out.println("Please enter a 4 digit number:");  
        int fourDigit = scan.nextInt();
        int reversedNumber=0;
        final int BOTTOM=999;
        final int TOP=10000;
        final int BOTTOM_NEGATIVE=-999;
        final int TOP_NEGATIVE=-10000;
        final int REVERSE_SIGN=1;
        final int REVERSE_NUM=2;
        final int REVERSE_SIGN_NUM=3;
        if (fourDigit > BOTTOM && fourDigit < TOP || fourDigit < BOTTOM_NEGATIVE && fourDigit > TOP_NEGATIVE ){
            System.out.println("1. Reverse sign.");
            System.out.println("2. Reverse number.");
            System.out.println("3. Reverse sign and number.");
            System.out.println("Please choose an option: ");
            int choiceDigit = scan.nextInt();
            switch (choiceDigit)
            {
                //Reverse sign
                case REVERSE_SIGN:
                    System.out.println("The result is");
                    System.out.println(fourDigit*-1);
                break;
                //Reverse number
                case REVERSE_NUM: 
                    reversedNumber+=(fourDigit%1000%100%10)*1000;//Turns units into thousands
                    reversedNumber+=(fourDigit%1000%100/10)*100;//Turns tens into hundreds
                    reversedNumber+=(fourDigit%1000/100)*10;//Turns hundreds into dozens
                    reversedNumber+=(fourDigit/1000);//Turns thousands into units
                    System.out.println("The result is");
                    System.out.println(reversedNumber);
                    break;
                //Reverse sign and number
                case REVERSE_SIGN_NUM:
                    reversedNumber+=(fourDigit%1000%100%10)*1000;
                    reversedNumber+=(fourDigit%1000%100/10)*100;
                    reversedNumber+=(fourDigit%1000/100)*10;
                    reversedNumber+=(fourDigit/1000);
                    System.out.println("The result is");
                    System.out.println(reversedNumber*-1);
                    break;
                default: System.out.print("Illegal option – you must choose 1, 2 or 3");
                    break;
            }//end of Selection menu.
        }//End of if four Digit number.
        else System.out.print("Illegal number – you must enter a 4 digit number");
    }// end of method main
}//end of class Number.