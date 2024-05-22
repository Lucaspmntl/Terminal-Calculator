import java.util.ArrayList;

public class Calculation {
    double result;
    double lastResult;

    ParseNumbers parseNumbers = new ParseNumbers();
    Operators operator = new Operators();

    public double calResult(ArrayList<String> arrayFormula) {
        // ArrayList<String> flexibleFormula = (ArrayList<String>) arrayFormula.clone();

        for (int i = 0; i < arrayFormula.size(); i++) {

            if (arrayFormula.get(i) == "/") {
                lastResult = operator.division(arrayFormula, i - 1, i + 1);

                arrayFormula.remove(i);
                arrayFormula.remove(i + 1);
                arrayFormula.set(i - 1, String.valueOf(lastResult));
                // Excluir o indice i e i+1 e substituir o i-1 pelo lastResult
            }

            if (arrayFormula.get(i) == "x") {
                lastResult = operator.multiplication(arrayFormula, i - 1, i + 1);

                arrayFormula.remove(i);
                arrayFormula.remove(i + 1);
                arrayFormula.set(i - 1, String.valueOf(lastResult));
            }

        }

        for (int i = 0; i < arrayFormula.size(); i++) {

            if (arrayFormula.get(i) == "+") {
                lastResult = operator.addition(arrayFormula, i - 1, i + 1);

                arrayFormula.remove(i);
                arrayFormula.remove(i + 1);
                arrayFormula.set(i - 1, String.valueOf(lastResult));
            }

            if (arrayFormula.get(i) == "-") {
                lastResult = operator.subtraction(arrayFormula, i + 1, i - 1);

                arrayFormula.remove(i);
                arrayFormula.remove(i + 1);
                arrayFormula.set(i - 1, String.valueOf(lastResult));

            }
        }

        if (arrayFormula.size() == 1) {
            double finalResult = Double.parseDouble(arrayFormula.get(0));
            return finalResult;
        }

        System.out.println("error in class Calculation");
        return 0;
    }
}
