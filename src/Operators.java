
import java.util.ArrayList;

public class Operators {

    Exceptions exception = new Exceptions();

    public double multiplication(ArrayList<String> arrayFormula, int index1, int index2) {

        double multiplicationResult = (Double.parseDouble(arrayFormula.get(index1)))
                * (Double.parseDouble(arrayFormula.get(index2)));

        return multiplicationResult;
    }

    public double addition(ArrayList<String> arrayFormula, int index1, int index2) {

        double additionResult = (Double.parseDouble(arrayFormula.get(index1)))
                + (Double.parseDouble(arrayFormula.get(index2)));

        return additionResult;
    }

    public double subtraction(ArrayList<String> arrayFormula, int index1, int index2) {

        double subtractionResult = (Double.parseDouble(arrayFormula.get(index1)))
                - (Double.parseDouble(arrayFormula.get(index2)));

        return subtractionResult;
    }

    public double division(ArrayList<String> arrayFormula, int index1, int index2) {
        double divisionResult;

        if (arrayFormula.get(index2).equals("0")) {
            
            do {
                arrayFormula = exception.divisionByZero(arrayFormula, index1, index2);

                divisionResult = (Double.parseDouble(arrayFormula.get(index1)))
                        / (Double.parseDouble(arrayFormula.get(index2)));

            } while ((arrayFormula.get(index2).equals("0")));

            return divisionResult;

        }

        else {

            divisionResult = (Double.parseDouble(arrayFormula.get(index1)))
                    / (Double.parseDouble(arrayFormula.get(index2)));

            return divisionResult;
        }

    }
}
