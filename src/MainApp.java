import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> originalNumbersArray = new ArrayList<>();

        ParseNumbers parseNumbers = new ParseNumbers();
        Calculation calculus = new Calculation();
        Options options = new Options();

        String option = "";

        String lastResult = "";
        String formula = "";

        System.out.println("---------------------------------- Calculator ----------------------------------");
        System.out.println();
        System.out.println("Use terminal to input your numbers and arithmetic operators for sum");
        System.out.println();
        System.out.println("(+ = addition)    (- = Subtraction)    (x = Multiplication)    (/ = Division)");
        System.out.println();
        System.out.println("           (c - To clear last result)      (e - To end the program)          ");
        System.out.println("Ex: \"50/2+5-1\" and press 'Enter' for results");
        System.out.println();
        System.out.println("---------------------------------- Calculator ----------------------------------");
        System.out.println();

        outerLoop: while (!option.equals("e")) {

            System.out.print("Your calculation formula: " + lastResult);

            option = options.parseOptions(formula);

            switch (option) {

                case "e":
                    break outerLoop;

                case "c":
                    lastResult = "";
                    options.spamNewLines();
                    System.out.print("Your calculation formula: ");
                    break;

                default:
                    break;
            }

            formula = input.nextLine();

            originalNumbersArray = parseNumbers.setFormula(formula, originalNumbersArray, lastResult);

            lastResult = calculus.calResult(originalNumbersArray);
            System.out.println(lastResult);

        }

        System.out.println("\n\n\n");
        System.out.println("Bye!");
        input.close();
    }

}