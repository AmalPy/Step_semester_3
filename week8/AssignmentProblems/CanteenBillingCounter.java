import java.util.Scanner;

public class CanteenBillingCounter {

    static abstract class Customer {
        protected double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double getFinalAmount();

        abstract String getType();
    }

    static class Student extends Customer {

        Student(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount * 0.90;
        }

        @Override
        String getType() {
            return "STUDENT";
        }
    }

    static class Staff extends Customer {

        Staff(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount * 0.95;
        }

        @Override
        String getType() {
            return "STAFF";
        }
    }

    static class Guest extends Customer {

        Guest(double amount) {
            super(amount);
        }

        @Override
        double getFinalAmount() {
            return amount + 10;
        }

        @Override
        String getType() {
            return "GUEST";
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = sc.nextInt();
        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    customers[i] = new Student(amount);
                    break;
                case "STAFF":
                    customers[i] = new Staff(amount);
                    break;
                default:
                    customers[i] = new Guest(amount);
                    break;
            }
        }

        double total = 0;

        for (Customer customer : customers) {
            double finalAmount = customer.getFinalAmount();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}