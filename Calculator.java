import java.util.Scanner;
//Worked on by Sweta Jain and Francesa Carbone//

public class Calculator {
    public static void main(String[] args) {
        Scanner calc = new Scanner(System.in);
        double num1;
        double num2;
        System.out.print("Enter first operand: ");
        num1 = calc.nextDouble();
        System.out.print("Enter second operand: ");
        num2 = calc.nextDouble();
        //Display Menu Options//
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        int answer;
        //initialized answer1 because it showed error, any # would work//
        double answer1 = 0;
        System.out.print("Which operation do you want to perform? ");
        answer = calc.nextInt();
        //could also use if/else//
        switch (answer) {
            case 1: {
                answer1 = num1 + num2;
                System.out.println("The result of the operation is " + answer1 + ". Goodbye!");
                break;
            }
            case 2: {
                answer1 = num1 - num2;
                System.out.println("The result of the operation is " + answer1 + ". Goodbye!");
                break;
            }
            case 3: {
                answer1 = num1 * num2;
                System.out.println("The result of the operation is " + answer1 + ". Goodbye!");
                break;
            }
            case 4: {
                answer1 = num1 / num2;
                System.out.println("The result of the operation is " + answer1 + ". Goodbye!");
                break;
            }
            default: {
                System.out.println("Error: Invalid selection! Terminating program. ");
                break; }
        }
    }
}


