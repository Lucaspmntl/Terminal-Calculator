import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> originalNumbersArray = new ArrayList<>();

        ParseNumbers parseNumbers = new ParseNumbers();
        Calculation calculus = new Calculation();

        String lastResult = "";
        String formula = "20x2+7-1";

        System.out.println("---------------------------------- Calculator ----------------------------------");
        System.out.println();
        System.out.println("Use terminal to input your numbers and arithmetic operators for sum");
        System.out.println();
        System.out.println("(+ = addition)    (- = Subtraction)    (x = Multiplication)    (/ = Division)");
        System.out.println();
        System.out.println("Ex: \"50/2+5-1\" and press 'Enter' for results");
        System.out.println();
        System.out.println("---------------------------------- Calculator ----------------------------------");
        System.out.println();
        System.out.print("Your calculation formula: ");
        // formula = input.nextLine();

        originalNumbersArray = parseNumbers.setFormula(formula, originalNumbersArray, lastResult);

        lastResult = calculus.calResult(originalNumbersArray);
        System.out.println(lastResult);

        input.close();
    }

}