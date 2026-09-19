import java.util.Scanner;

public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        PasswordChecker checker = new PasswordChecker(password);

        System.out.println("Password strength: " + checker.getStrength());

        sc.close();
    }
}
}