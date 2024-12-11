package lab8_p;
import java.util.regex.*;


public class Zad4 {
    public static void main(String[] args){
        String email = "andrzej012@gmail.com";
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isValid = Pattern.matches(regex, email);


        if(isValid) {
            System.out.println(email + " is a valid email address.");
        }

        else {
            System.out.println(email + " is not a valid email address.");
        }
    }
}
