import java.util.Scanner;
public class tree {
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        int treedigit;
        System.out.println("please insart 3 digit number");
        treedigit =scan.nextInt();
        System.out.println("hondred="+(treedigit/100));        
        System.out.println("Dozens="+(treedigit/10%10));
        System.out.println("units="+(treedigit%100%10));
    }
}