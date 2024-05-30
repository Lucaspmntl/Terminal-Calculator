
import java.util.ArrayList;

public class Operators {

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

        if (arrayFormula.get(index2).equals("0")) {
            System.out.println("Invalid division, numbers aren't divisible by zero!");
            return 0;
        }

        else {

            double divisionResult = (Double.parseDouble(arrayFormula.get(index1)))
                    / (Double.parseDouble(arrayFormula.get(index2)));

            return divisionResult;
        }

    }
}
