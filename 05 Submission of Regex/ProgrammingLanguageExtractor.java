import java.util.regex.*;
import java.util.*;

public class ProgrammingLanguageExtractor {
    public List<String> extract(String text) {
        List<String> languages = new ArrayList<>();
        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|Ruby|C#|Swift|Kotlin)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static void main(String[] args) {
        ProgrammingLanguageExtractor extractor = new ProgrammingLanguageExtractor();
        List<String> languages = extractor.extract("I love Java, Python, and JavaScript, but I haven't tried Go yet.");
        for (String language : languages) {
            System.out.println(language);
        }
    }
}
