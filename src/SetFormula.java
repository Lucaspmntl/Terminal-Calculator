import java.util.ArrayList;

public class SetFormula {

    private String[] acceptedOperators = { "+", "-", "x", "/" };

    Exceptions error = new Exceptions();
    ParseStrings pS = new ParseStrings();
    ParseNumbers pN = new ParseNumbers();

    // Return an tokened and separated Array from the original formula String
    public ArrayList<String> setFormula(String formula, ArrayList<String> arrayFormula, String lastResult) {
        String numbers = "";
        int indexArray = 0;
        boolean conditionFirstCharMet = false;

        formula = pS.removeSpaceChars(formula);

        for (int i = 0; i < formula.length(); i++) {

            if (i == 0 && conditionFirstCharMet == false) { // if is the first character

                if (pN.charIsNumb(formula, i) == true) {
                    numbers += pS.getChar(formula, i);
                }

                else if (pN.charIsNumb(formula, i) == false && !lastResult.equals("")) {

                    arrayFormula.clear();

                    arrayFormula.add(indexArray, lastResult);
                    indexArray++;

                    conditionFirstCharMet = true;
                    i = -1;
                }

                else if (pN.charIsNumb(formula, i) == false && lastResult.equals("")) {
                    System.out.println("Error! the first character isn't a number!");
                }
            }

            else if (i == formula.length() - 1) { // if is the last character
                if (pN.charIsNumb(formula, i) == true) {
                    numbers += pS.getChar(formula, i);
                    arrayFormula.add(indexArray, numbers);
                }

                // if isn't a number and isn't "clear" ("c")
                else if (pN.charIsNumb(formula, i) == false && !pS.getChar(formula, i).equals("c")) {
                    System.out.println("Error! the last character isn't a number");

                }

            }

            else if (pN.charIsNumb(formula, i) == true) { // if is a number
                numbers += pS.getChar(formula, i);
            }

            else if (pN.charIsNumb(formula, i) == false) { // if isn't a number (an operator)

                switch (pS.getChar(formula, i)) {
                    case ".":
                    case ",":
                        numbers += ".";
                        break;

                    default:

                        boolean existingOperator = false;

                        outerLoop: for (int o = 0; o < acceptedOperators.length; o++) {

                            if (pS.getChar(formula, i).equals(acceptedOperators[o])) {

                                switch (i) {
                                    case 0: // If is the first character yet
                                        arrayFormula.add(indexArray, pS.getChar(formula, i));
                                        indexArray++;
                                        existingOperator = true;

                                        break outerLoop;

                                    default:
                                        arrayFormula.add(indexArray, numbers);
                                        indexArray++;

                                        numbers = "";

                                        arrayFormula.add(indexArray, pS.getChar(formula, i));
                                        indexArray++;

                                        existingOperator = true;
                                        break outerLoop;
                                }
                            }
                        }

                        if (existingOperator == false) { // if operator does not exist..
                            System.out.println("Error! there is an invalid operator!");
                        }

                        break; // default break
                }

            }

        }
        return arrayFormula;
    }
}