import java.util.Scanner;

public class NameTag {

    private final String firstName;
    private final char lastInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastInitial = parts[1].charAt(0);
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        NameTag tag = new NameTag(fullName);

        System.out.println(tag.getNickname());

        sc.close();
    }
}
}