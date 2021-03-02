import java.util.Scanner;
public class Rectangle {

    public static void main (String[] args) {
    int width ,height,perimeter,area;
    Scanner scan = new Scanner(System.in);
    System.out.print("please insart your whidth>");
    width =scan.nextInt();
    System.out.print("please insart your height>");
    height=scan.nextInt();
    perimeter=2*width + height*2;
    area= width*height;
    System.out.print("perimeter="+perimeter);
    System.out.print("area="+area);
    


    }

}