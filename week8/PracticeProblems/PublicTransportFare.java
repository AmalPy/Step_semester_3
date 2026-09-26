import java.util.Scanner;

public class PublicTransportFare {

    static abstract class Transport {
        protected double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double getFare();

        abstract String getType();
    }

    static class Bus extends Transport {

        Bus(double distance) {
            super(distance);
        }

        @Override 
        double getFare() {
            double fare = 2 + distance * 0.10;

            if (fare > 10) {
                fare = 10;
            }

            return fare;
        }

        @Override 
        String getType() {
            return "BUS";
        }
    }

    static class Train extends Transport {

        Train(double distance) {
            super(distance);
        }

        @Override 
        double getFare() {
            return 3 + distance * 0.15;
        }

        @Override 
        String getType() {
            return "TRAIN";
        }
    }

    static class Metro extends Transport {

        private final double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override 
        double getFare() {
            return (1.50 + distance * 0.20) * peakHourFactor;
        }

        @Override 
        String getType() {
            return "METRO";
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = sc.nextInt();
        Transport[] transports = new Transport[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            switch (type) {
                case "BUS":
                    transports[i] = new Bus(distance);
                    break;
                case "TRAIN":
                    transports[i] = new Train(distance);
                    break;
                default:
                    double factor = sc.nextDouble();
                    transports[i] = new Metro(distance, factor);
                    break;
            }
        }

        double total = 0;

        for (Transport transport : transports) {
            double fare = transport.getFare();

            System.out.printf("%s: %.2f%n",
                    transport.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}