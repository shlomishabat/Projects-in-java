import java.util.Scanner;
public class Paychack{
    public static void main (String[]args){
    Scanner scan = new Scanner(System.in);
    int age,salary;
    System.out.print("please insart your age");
    age=scan.nextInt();
    System.out.print("please insart your salary");
    salary=scan.nextInt();
    if (age>=18 && age<67)
        salary-=100;
    else salary+=200;
    
    System.out.print(salary);
        
    }
}
