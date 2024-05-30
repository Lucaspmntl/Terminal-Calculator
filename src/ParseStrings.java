import java.util.ArrayList;

public class ParseStrings {

    public String getChar(String string, int indexOfCharacter) {

        String stringChar = string.substring(indexOfCharacter, indexOfCharacter + 1);
        return stringChar;
    }

    public String removeSpaceChars(String string) {
        char[] chars = string.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();

        int arrayListIndex = 0;

        for (int i = 0; i < chars.length; i++) {

            switch (chars[i]) {
                case ' ':
                    break;

                default:
                    characters.add(arrayListIndex, chars[i]);
                    arrayListIndex ++;
                    break;
            }

        }

        StringBuilder sB = new StringBuilder(characters.size());

        for (int i = 0; i < characters.size(); i ++) {
            sB.append(characters.get(i));
        }

        String noSpacesString = sB.toString();

        return noSpacesString;

    }
}
