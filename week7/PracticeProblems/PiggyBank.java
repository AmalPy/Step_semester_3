import java.util.Scanner;

public class PiggyBank {

    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
            return;
        }

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: invalid amount");
            return;
        }

        savings -= amount;
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter piggy bank ID: ");
        String id = sc.nextLine();

        PiggyBank pb = new PiggyBank(id);

        System.out.print("Enter deposit amount: ");
        double deposit = sc.nextDouble();
        pb.deposit(deposit);

        System.out.print("Enter withdrawal amount: ");
        double withdraw = sc.nextDouble();
        pb.withdraw(withdraw);

        System.out.println("Savings: " + pb.getSavings());

        sc.close();
    }
}
}