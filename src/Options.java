public class Options {

    public String parseOptions(String formula) {

        switch (formula) {
            case "e":
                return "e";

            case "c":
                return "c";

            default:
                return "";

        }
    }

    public void spamNewLines() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
