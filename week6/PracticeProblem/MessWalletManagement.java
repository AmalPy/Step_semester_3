import java.util.Scanner;

public class MessWalletManagement {

    static class MessWallet {
        private double balance;

        public MessWallet(double balance) {
            if (balance < 0) {
                System.out.println("Invalid opening balance. Starting with 0.");
                this.balance = 0;
            } else {
                this.balance = balance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be positive");
                return;
            }

            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }

        public void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }

            if (amount <= 0) {
                System.out.println("Deduct rejected: amount must be positive");
                return;
            }

            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter opening balance: ");
        double opening = sc.nextDouble();

        MessWallet wallet = new MessWallet(opening);

        System.out.print("Enter top-up amount: ");
        double topUpAmount = sc.nextDouble();

        wallet.topUp(topUpAmount);

        System.out.print("Enter deduction amount: ");
        double deductionAmount = sc.nextDouble();

        wallet.deduct(deductionAmount);

        System.out.println("Final balance: " + wallet.getBalance());

        sc.close();
    }
}