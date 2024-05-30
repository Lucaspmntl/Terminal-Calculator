import java.util.ArrayList;

public class Calculation {
    double result;
    double lastResult = 0;
    String noDecimalResult;

    ParseNumbers pN = new ParseNumbers();
    Operators operator = new Operators();

    public String calResult(ArrayList<String> arrayFormula) {

        for (int i = 0; i < arrayFormula.size(); i++) {

            switch (arrayFormula.get(i)) {

                case "/":

                    lastResult = operator.division(arrayFormula, i - 1, i + 1);
                    noDecimalResult = pN.tryNoDecimal(lastResult);

                    arrayFormula.remove(i + 1);
                    arrayFormula.remove(i);
                    arrayFormula.set(i - 1, noDecimalResult);

                    i = 0;
                    break;

                case "x":

                    lastResult = operator.multiplication(arrayFormula, i - 1, i + 1);
                    noDecimalResult = pN.tryNoDecimal(lastResult);

                    arrayFormula.remove(i + 1);
                    arrayFormula.remove(i);
                    arrayFormula.set(i - 1, noDecimalResult);
                    i = 0;
                    break;
            }

        }

        for (int i = 0; i < arrayFormula.size(); i++) {

            switch (arrayFormula.get(i)) {

                case "+":

                    lastResult = operator.addition(arrayFormula, i - 1, i + 1);
                    noDecimalResult = pN.tryNoDecimal(lastResult);

                    arrayFormula.remove(i + 1);
                    arrayFormula.remove(i);
                    arrayFormula.set(i - 1, noDecimalResult);
                    i = 0;
                    break;

                case "-":

                    lastResult = operator.subtraction(arrayFormula, i - 1, i + 1);
                    noDecimalResult = pN.tryNoDecimal(lastResult);

                    arrayFormula.remove(i + 1);
                    arrayFormula.remove(i);
                    arrayFormula.set(i - 1, noDecimalResult);
                    i = 0;
                    break;
            }

        }

        if (arrayFormula.size() == 1) {
            String finalResult = arrayFormula.get(0);
            return finalResult;
        }

        else {
            System.out.println("error in class Calculation, array with than one index");
            return "0";
        }
    }
}
