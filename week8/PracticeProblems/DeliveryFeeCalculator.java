import java.util.Scanner;

public class DeliveryFeeCalculator {

    static abstract class Delivery {
        protected double weight;
        protected double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract double getFee();

        abstract String getType();
    }

    static class Standard extends Delivery {

        Standard(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        double getFee() {
            return 5 + (weight * 0.50) + (distance * 0.10);
        }

        @Override
        String getType() {
            return "STANDARD";
        }
    }

    static class Express extends Delivery {

        Express(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        double getFee() {
            return 15 + weight + (distance * 0.20);
        }

        @Override
        String getType() {
            return "EXPRESS";
        }
    }

    static class International extends Delivery {

        private final double customsFee;

        International(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        double getFee() {
            return 25 + (weight * 2) + (distance * 0.50) + customsFee;
        }

        @Override
        String getType() {
            return "INTERNATIONAL";
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = sc.nextInt();
        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    deliveries[i] = new Standard(weight, distance);
                    break;
                case "EXPRESS":
                    deliveries[i] = new Express(weight, distance);
                    break;
                default:
                    double customsFee = sc.nextDouble();
                    deliveries[i] = new International(
                            weight, distance, customsFee);
                    break;
            }
        }

        double total = 0;

        for (Delivery delivery : deliveries) {
            double fee = delivery.getFee();

            System.out.printf("%s: %.2f%n",
                    delivery.getType(), fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}