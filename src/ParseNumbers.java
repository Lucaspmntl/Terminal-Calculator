import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class ParseNumbers {
    ArrayList<String> originalNumbers = new ArrayList<>();
    private String[] acceptedOperators = { "+", "-", "x", "/" };

    public boolean isNumb(String str) {
        try {
            Double.parseDouble(str);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setFormula(String formula, ArrayList<String> originalNumbers) {
        String numbers = "";
        String character = "";
        int indexArray = 0;

        for (int i = 0; i <= formula.length(); i++) {
            int m = i + 1;

            if (isNumb(formula.substring(i, m))) {
                if (i == formula.length()) {

                    numbers += formula.substring(i, m);
                    originalNumbers.set(indexArray, numbers);
                }

                else {
                    numbers += formula.substring(i, m);
                }
            }

            if (formula.substring(i, m) == "." || formula.substring(i, m) == ",") {
                numbers += ",";
            }

            for (int itwo = 0; itwo < acceptedOperators.length; itwo++) {

                if (formula.substring(i, m) == acceptedOperators[itwo]) {
                    originalNumbers.set(indexArray, numbers);
                    indexArray++;

                    numbers = "";
                    character = "";

                    character = formula.substring(i, m);
                    originalNumbers.set(indexArray, character);
                }
            }

            if (i == formula.length() && isNumb(formula.substring(i, m)) == false) {
                System.out.println("Error! the last character isn't a number");
            }
        }
    }

}
