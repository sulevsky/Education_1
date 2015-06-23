import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        System.out.println("mySimpleCalc: Welcome!");

        Scanner scanner = new Scanner (System.in);

        BigDecimal num1 = new BigDecimal("0.00");
        BigDecimal num2 = new BigDecimal("0.00");

        System.out.println("Please, input the first number");

        boolean resumeLoop = true;

        do {
            try {

                scanner.hasNextBigDecimal();
                num1 = scanner.nextBigDecimal();
                resumeLoop = false;
                System.out.println("Your input " + num1.toPlainString() + " as the first number");

            }
            catch (InputMismatchException e1) {
                System.err.println("Incorrect entry, exception " + e1 + ". You must enter numbers. Try again.");
                scanner.nextLine();
            }
        }
        while (resumeLoop);




        System.out.println("Please, input the second number.");

        boolean resumeLoop2 = true;

        do {
            try {
                if (scanner.hasNextBigDecimal()) {}
                num2 = scanner.nextBigDecimal();

                BigDecimal sum = (num1.add(num2));
                sum = sum.setScale(8, RoundingMode.HALF_DOWN);

                BigDecimal dif = (num1.subtract(num2));
                dif = dif.setScale(8, RoundingMode.HALF_DOWN);

                BigDecimal mul = (num1.multiply(num2));
                mul = mul.setScale(8, RoundingMode.HALF_DOWN);

                BigDecimal div = (num1.divide(num2, 8, RoundingMode.HALF_DOWN));

                resumeLoop2 = false;

                System.out.println("Your input " + num2.toPlainString() + " as the second number.");

                System.out.println("Results:");
                System.out.println("Sum is: " + sum.toPlainString());
                System.out.println("Difference is: " + dif.toPlainString());
                System.out.println("Multiplication is: " + mul.toPlainString());
                System.out.println("Division is: " + div.toPlainString());

                scanner.close();
            }

            catch (InputMismatchException e2) {
                System.err.println("Incorrect entry, exception " + e2 + ". You must enter numbers. Try again.");
                scanner.nextLine();
            }

            catch (ArithmeticException e3) {
                System.err.println("You can't divide by zero, exception " + e3 + ". Input the second number again.");
                scanner.nextLine();
            }
        }

        while (resumeLoop2);
        System.exit(0);
    }
}