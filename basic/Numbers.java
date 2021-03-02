import java.util.Scanner;
public class Numbers{
    public static void main (String []args){
    Scanner scan =new Scanner (System.in);
    int num1,num2;
    System.out.print("please insart a num1:");
    num1=scan.nextInt();
    System.out.print("please insart a num2:");
    num2=scan.nextInt();
    System.out.println(num1+"+"+num2+"="+(num1+num2));
    System.out.println(num1+"-"+num2 +"="+(num1-num2));    
    }
    
    
    }
