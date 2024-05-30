
import java.util.ArrayList;

public class ParseNumbers {

    ArrayList<String> originalNumbers = new ArrayList<>();

    Exceptions error = new Exceptions();
    ParseStrings pS = new ParseStrings();

    public String tryNoDecimal(double doubleNumber) {

        String stringNumberOriginal = String.valueOf(doubleNumber);
        String stringNumber = stringNumberOriginal;

        StringBuilder buffer = new StringBuilder(stringNumber);

        try {

            for (int i = 0; i < stringNumber.length(); i++) {

                switch (buffer.charAt(i)) {

                    case '.':
                        buffer.deleteCharAt(i); // Delete "." and loop for delete zeros characters

                        outerLoop: for (int k = i; k < stringNumber.length(); k++) {

                            switch (buffer.charAt(k)) {

                                case '0':
                                    buffer.deleteCharAt(k);

                                    stringNumber = buffer.toString();

                                    i -= 2;
                                    break outerLoop;

                                default:
                                    break;
                            }
                        }
                        break;

                    default:
                        break;
                }
            }

            stringNumber = buffer.toString();
            return stringNumber;

        }

        catch (Throwable e) {
            return stringNumberOriginal;
        }

    }

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

}
