import java.util.Scanner;
public class U2P7EX1
{
    public static void main (String []args){
    int num;
    Scanner scan =new Scanner (System.in);
    System.out.println("please insart a number between 1-6 include");
    num = scan.nextInt();
    switch (num){
        case 1:
        case 2: num+=1;
            break;
        case 3: 
        case 4:
        case 5: num-=1;
            break;
        case 6: num*=2;
            break;
        default:num*=3;
        
    }
    System.out.println(num);
    
    }
}
