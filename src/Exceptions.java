import java.util.ArrayList;
import java.util.Scanner;

public class Exceptions {

    Scanner input = new Scanner(System.in);
    ParseNumbers pN = new ParseNumbers();

    public String invalidOperator(String formula) {

        System.out.println();
        System.out.println("!> !> ERROR! THERE IS AN INVALID OR NO OPERATOR <! <!");
        System.out.println();
        System.out.println("Valid operators: (x, -, +, / and \".\" or \",\" to float numbers!)");
        System.out.println();
        System.out.print("Try again with invalid operators: ");
        String newFormula = input.nextLine();

        formula = newFormula;

        return formula;
    }

    public String lastNotCharacter(String formula, ArrayList<String> arrayFormula, String lastResult) {

        int lastIndex = formula.length() - 1;
        String lastChar = String.valueOf(formula.charAt(lastIndex));

        if (arrayFormula.isEmpty() == true) {

            while (!pN.isNumb(lastChar)) {

                StringBuilder formulaBuffer = new StringBuilder(formula);

                System.out.println();
                System.out.println("!> !> ERROR! THE LAST CHARACTER ISN'T A NUMBER <! <!");
                System.out.println();

                System.out.print("Try a number in last character: ");

                System.out.print(lastResult);

                formulaBuffer.deleteCharAt(lastIndex);
                System.out.print(formulaBuffer);

                String newCharacter = input.nextLine();

                formulaBuffer.append(newCharacter);

                formula = formulaBuffer.toString();

                lastIndex = formula.length() - 1;
                lastChar = String.valueOf(formula.charAt(lastIndex));
            }

        }

        else if (arrayFormula.isEmpty() == false) {

            StringBuilder formulaBuffer = new StringBuilder(formula);

            System.out.println();
            System.out.println("!> !> ERROR! THE LAST CHARACTER ISN'T A NUMBER <! <!");
            System.out.println();

            System.out.print("Try a number in last character: ");
            System.out.print(lastResult);

            formulaBuffer.deleteCharAt(lastIndex);

            System.out.print(formulaBuffer);

            String newCharacter = input.nextLine();

            formulaBuffer.append(newCharacter);

            formula = formulaBuffer.toString();

            lastIndex = formula.length() - 1;
            lastChar = String.valueOf(formula.charAt(lastIndex));
        }

        return formula;
    }

    public String firstNotCharacter(String formula) {
        formula = "";
        StringBuilder formulaBuffer = new StringBuilder(formula);

        System.out.println();
        System.out.println("!> !> ERROR! THE FIRST CHARACTER ISN'T A NUMBER <! <!");
        System.out.println();
        System.out.print("Try a number: ");
        String newCharacter = input.nextLine();

        formulaBuffer.append(newCharacter);

        formula = formulaBuffer.toString();
        return formula;
    }

    public ArrayList<String> divisionByZero(ArrayList<String> arrayFormula, int index1, int index2) {

        String newNumber;

        System.out.println();
        System.out.println("!> !> INVALID DIVISION, NUMBERS AREN'T DIVISIBLE BY ZERO! <! <!");
        System.out.println();
        System.out.print("Try again your formula: ");

        arrayFormula.removeLast();
        arrayFormula.removeLast();
        arrayFormula.addLast("/");

        for (String str : arrayFormula) {
            System.out.print(str);
        }

        newNumber = input.nextLine();

        arrayFormula.add(index2, newNumber);

        return arrayFormula;

    }
}
