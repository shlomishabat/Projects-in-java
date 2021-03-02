import java.util.Scanner;
public class U2P8EX2{
    public static void main (String []args){
    Scanner scan =new Scanner (System.in);
    int num,num1,num5,num10;
    System.out.println("please insart money count:");
    num=scan.nextInt();
    num10 = num/10;
    num-=num10*10;
    num5=num/5;
    num-=num5*5;
    num1=num/1;
    System.out.println("Wee need "+num10+" coins of 10 NIS");
    System.out.println("Wee need "+num5+" coins of 5 NIS");
    System.out.println("Wee need "+num1+" coins of 1 NIS");
    }
}