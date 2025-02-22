import java.util.regex.*;

public class BadWordCensor {
    public String censor(String input, String[] badWords) {
        for (String badWord : badWords) {
            input = input.replaceAll("(?i)" + Pattern.quote(badWord), "****");
        }
        return input;
    }

    public static void main(String[] args) {
        BadWordCensor censor = new BadWordCensor();
        String[] badWords = {"damn", "stupid"};
        System.out.println(censor.censor("This is a damn bad example with some stupid words.", badWords));
    }
}
