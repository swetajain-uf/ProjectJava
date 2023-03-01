import java.util.Scanner;

public class Project1Ex {
    public static void main(String[] args) {
        int num1 = 0;
        while (true){
            System.out.println("Start From Beginning");
            second:
            while (num1 == 0){
                int input=0;
                System.out.println("Input something: " +input);
                Scanner scan = new Scanner(System.in);
                 input = scan.nextInt();
                System.out.println(input + 1);
                if (input == 1){
                    System.out.println(1);
                }
                break second;
            }
    }


    }
}
