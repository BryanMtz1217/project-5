import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("Enter an operation (+, -, *, /, or exit): ");
            String operation = scanner.next();

            if (operation.equals("exit")) {
                continueCalculation = false;
                System.out.println("Thank you for using the Java Calculator! Goodbye!");
                break;
            }

            if (!operation.matches("[+\\-*/]")) {
                System.out.println("Invalid operation. Please try again.");
                continue;
            }

            System.out.println("Enter the first number: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number: ");
                scanner.next();
            }
            double num1 = scanner.nextDouble();

            System.out.println("Enter the second number: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number: ");
                scanner.next();
            }
            double num2 = scanner.nextDouble();

            double result = 0;
            boolean validOperation = true;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    }
                    break;
            }

            if (validOperation) {
                System.out.println("The result of " + num1 + " " + operation + " " + num2 + " = " + result);
            }

            System.out.println("Would you like to perform another operation (yes/no)? ");
            String continueResponse = scanner.next();
            if (!continueResponse.equalsIgnoreCase("yes")) {
                continueCalculation = false;
                System.out.println("Thank you for using the Java Calculator! Goodbye!");
            }
        }

        scanner.close();
    }
}