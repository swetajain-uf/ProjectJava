import java.text.DecimalFormat;
import java.util.Scanner;
// worked with Francesca//

public class SciCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = 1;
        int numCalculations = 0;
        double sumofcalc = 0;
        System.out.println("Current Result: 0.0");
        while (num1 != 0) {
            System.out.println("Calculator Menu");
            System.out.println("---------------");
            System.out.println("0. Exit Program");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exponentiation");
            System.out.println("6. Logarithm");
            System.out.println("7. Display Average");
            System.out.println();

            System.out.print("Enter Menu Selection: ");
            num1 = input.nextInt();
            while (num1 < 0 || num1 >= 7) {
                if (num1 == 7 && numCalculations==0) {
                    System.out.println("Error: No calculations yet to average!");
                    System.out.println();
                }
                else if (num1 == 7 && numCalculations != 0){
                    break;
                }
                else {
                    System.out.println("Error: Invalid selection!");
                }
                System.out.print("Enter Menu Selection: ");
                num1 = input.nextInt();
            }
            //
            if (num1 == 0){
                System.out.println("Thanks for using this calculator. Goodbye!");
                break;
            }
            double answer = 0;
            double num2 = 0;
            double num3 = 0;
            if (num1 != 7) {

                System.out.print("Enter first operand: ");
                num2 = input.nextDouble();
                System.out.print("Enter second operand: ");
                num3 = input.nextDouble();
            }
            if (num1 == 1) {
                answer = num2 + num3;
                numCalculations++;
                sumofcalc += answer;
                System.out.println();
                System.out.println("Current Result: " + answer);
            }
            else if (num1 == 2) {
                answer = num2 - num3;
                numCalculations++;
                sumofcalc += answer;
                System.out.println();
                System.out.println("Current Result: " + answer);
            }
            else if (num1 == 3) {
                answer = num2 * num3;
                numCalculations++;
                sumofcalc += answer;
                System.out.println();
                System.out.println("Current Result: " + answer);
            }
            else if (num1 == 4) {
                answer = num2 / num3;
                numCalculations++;
                sumofcalc += answer;
                System.out.println();
                System.out.println("Current Result: " + answer);
            }
            else if (num1 == 5) {
                answer = Math.pow(num2, num3);
                numCalculations++;
                sumofcalc += answer;
                System.out.println();
                System.out.println("Current Result: " + answer);
            }
            else if (num1 == 6) {
                answer = Math.log(num3) / Math.log(num2);
                System.out.println();
                System.out.println("Current Result: " + answer);
                numCalculations++;
                sumofcalc += answer;
            }
            else if (num1 == 7) {
                System.out.println();
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println("Sum of calculations: " + sumofcalc);
                System.out.println("Number of calculations: " + numCalculations);
                System.out.println("Average of calculations: " + df.format(sumofcalc / numCalculations));
            }
        }
    }
}
