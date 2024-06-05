import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> originalNumbersArray = new ArrayList<>();

        Calculation calculus = new Calculation();
        Options options = new Options();
        SetFormula setFormula = new SetFormula();

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

            option = "";
            System.out.print("Your calculation formula: " + lastResult);

            option = options.parseOptions(formula);

            switch (option) {

                case "e":
                    break outerLoop;

                case "c":
                    lastResult = "";
                    options.spamNewLines();
                    originalNumbersArray.clear();
                    System.out.print("Your calculation formula: ");

                    break;

                default:
                    break;
            }

            formula = input.nextLine();

            originalNumbersArray = setFormula.setFormula(formula, originalNumbersArray, lastResult);

            lastResult = calculus.calResult(originalNumbersArray);
            System.out.println(lastResult);

        }

        System.out.println("\n");
        System.out.println("Bye!");
        input.close();
    }

}