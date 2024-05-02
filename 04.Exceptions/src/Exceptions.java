import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) throws Exception {
        boolean right = true ;
        Scanner input = new Scanner(System.in);
        do {
            try{
                System.out.print("Enter the first number: ");
                int n1 = input.nextInt();
                System.out.print("Enter the second number: ");
                int n2 = input.nextInt();
                System.out.println("sum = " + (n1+n2));
                right = false ;
            } catch (Exception e) {
                System.out.println("Invalid input. try again enter numbers only.");
                input.nextLine();
            }
        }while (right);
        input.close();
    }
}
