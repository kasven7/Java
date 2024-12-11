package lab8_p;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;


public class Zad3 {
    public static void main(String[] args){
        String sentence = "Z podanego zdania należy wyodrębnić zawarte w nim słowa stosując wyrażenie regularne.";
        String regex = "\\b[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(sentence);
        List<String> words = new ArrayList<>();


        while(matcher.find()){
            words.add(matcher.group());
        }
        System.out.println("Here are your words: " + words);
    }
}
