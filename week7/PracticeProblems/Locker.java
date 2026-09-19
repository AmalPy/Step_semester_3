import java.util.Scanner;

public class Locker {

    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public void changeCode(String currentCode, String newCode) {
        if (!combination.equals(currentCode)) {
            System.out.println("Code change rejected");
            return;
        }

        combination = newCode;
        System.out.println("Code changed successfully");
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter locker number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter current code: ");
        String code = sc.nextLine();

        Locker locker = new Locker(number, code);

        System.out.print("Enter current code for change: ");
        String oldCode = sc.nextLine();

        System.out.print("Enter new code: ");
        String newCode = sc.nextLine();

        locker.changeCode(oldCode, newCode);

        sc.close();
    }
}
}