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




    public void parseFormula(String formula, ArrayList<String> originalNumbers) {
        String numbers = null;
        String character = null;
        int indexArray = 0;

        for (int i = 0; i < formula.length(); i++) {
            int m = i+1;

            if (isNumb(formula.substring(i, m))) {
                numbers += formula.charAt(i);
            }

            if (formula.substring(i, m) == "." || formula.substring(i, m) == ",") {
                numbers += formula.charAt(i);
            }

            for (int itwo = 0; itwo < acceptedOperators.length; itwo++) {

                if (formula.substring(i, m) == acceptedOperators[itwo]) {
                    originalNumbers.set(indexArray, numbers);
                    indexArray++;
                    numbers = null;
                    character = formula.substring(i, m);
                    originalNumbers.set(indexArray, character);
                }
            }

        }
    }

}
