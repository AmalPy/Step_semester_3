import java.util.Scanner;

public class PaymentSystem {

    static abstract class Payment {
        protected double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double getFinalAmount();

        abstract String getType();
    }

    static class Card extends Payment {

        Card(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount * 1.02;
        }

        @Override
        String getType() {
            return "CARD";
        }
    }

    static class Wallet extends Payment {

        Wallet(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount * 1.01;
        }

        @Override
        String getType() {
            return "WALLET";
        }
    }

    static class BankTransfer extends Payment {

        BankTransfer(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount;
        }

        @Override
        String getType() {
            return "BANKTRANSFER";
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = sc.nextInt();
        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "CARD":
                    payments[i] = new Card(amount);
                    break;
                case "WALLET":
                    payments[i] = new Wallet(amount);
                    break;
                default:
                    payments[i] = new BankTransfer(amount);
                    break;
            }
        }

        double total = 0;

        for (Payment payment : payments) {
            double finalAmount = payment.getFinalAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}