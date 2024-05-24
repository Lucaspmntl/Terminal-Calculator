
import java.util.ArrayList;

public class ParseNumbers {

    ArrayList<String> originalNumbers = new ArrayList<>();

    private String[] acceptedOperators = { "+", "-", "x", "/" };

    Exceptions error = new Exceptions();
    ParseStrings pS = new ParseStrings();

    public boolean isNumb(String string) {
        try {
            Double.parseDouble(string);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean charIsNumb(String string, int charIndex) {
        boolean charIsNumb = isNumb(pS.getChar(string, charIndex));
        return charIsNumb;
    }

    public void setFormula(String formula, ArrayList<String> arrayFormula, String lastResult) {
        String numbers = "";
        int indexArray = 0;

        for (int i = 0; i < formula.length(); i++) {

            if (i == 0) { // if is the first character

                if (charIsNumb(formula, i) == true) {
                    numbers += pS.getChar(formula, i);
                }

                else if (charIsNumb(formula, i) == false && !lastResult.equals("")) {
                    arrayFormula.add(indexArray, lastResult);
                    indexArray++;
                }

                else if (charIsNumb(formula, i) == false && lastResult.equals("")) {
                    System.out.println("Error! the first character isn't a number!");
                }
            }

            else if (i == formula.length() - 1) { // if is the last character
                if (charIsNumb(formula, i) == true) {
                    arrayFormula.add(indexArray, pS.getChar(formula, i));
                }

                else if (charIsNumb(formula, i) == false) {
                    System.out.println("Error! the last character isn't a number");
                }

            }

            else if (charIsNumb(formula, i) == true) { // if is a number
                numbers += pS.getChar(formula, i);
            }

            else if (charIsNumb(formula, i) == false) { // if isn't a number (an operator)

                switch (pS.getChar(formula, i)) {
                    case ".":
                    case ",":
                        numbers += ".";
                        break;

                    default:

                        boolean existingOperator = false;

                        for (int o = 0; o < acceptedOperators.length; o++) {

                            if (pS.getChar(formula, i).equals(acceptedOperators[o])) {
                                arrayFormula.add(indexArray, numbers);
                                indexArray++;

                                numbers = "";

                                arrayFormula.add(indexArray, pS.getChar(formula, i));
                                indexArray++;

                                existingOperator = true;
                                break; // for break
                            }
                        }

                        if (existingOperator == false) { // if operator does not exist..
                            System.out.println("Error! there is an invalid operator!");
                        }

                        break; // default break
                }

            }

        }
    }

}
