import java.util.Scanner;

public class T2 {
    public static void main(String[] args) throws Exception {
      
        Scanner in = new Scanner(System.in);
        int numberOne = in.nextInt();
        int numberTwo = in.nextInt();

        System.out.println((numberOne + numberTwo) + "\n"
                        +  (numberOne - numberTwo) + "\n"
                        +  (numberOne * numberTwo) + "\n"
                        +  (numberOne / (float) numberTwo));
        in.close();
    }

}
