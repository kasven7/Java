package lab11_p;


public class Zad2 {
        public static void login(String username, String password) throws InvalidPasswordException {
            String correctPassword = "secure123";

            if (!password.equals(correctPassword)) {
                throw new InvalidPasswordException("Incorrect password. User: " + username);
            }

            System.out.println("Successfully logged in! Welcome, " + username + "!");
        }

        public static void main(String[] args) {
            String username = "user123";
            String password = "wrongPassword";

            try {
                login(username, password);
            } catch (InvalidPasswordException e) {
                System.err.println("Error during logging in: " + e.getMessage());
            } finally {
                System.out.println("Thank you for using our system :).");
            }
        }
}
