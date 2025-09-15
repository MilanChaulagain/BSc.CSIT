package RMILab;

import java.rmi.Naming;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            System.out.println("Sum: " + calc.add(10, 5));
            System.out.println("Difference: " + calc.subtract(10, 5));
            System.out.println("Product: " + calc.multiply(10, 5));
            System.out.println("Quotient: " + calc.divide(10, 5));

            List<Integer> factors = calc.factors(28);
            System.out.println("Factors of 28: " + factors);

            System.out.println("Factorial of 5: " + calc.factorial(5));

        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}

