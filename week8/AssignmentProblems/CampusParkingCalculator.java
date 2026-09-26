import java.util.Scanner;

public class CampusParkingCalculator {

    static abstract class Vehicle {
        protected int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double getCharge();

        abstract String getType();
    }

    static class Bike extends Vehicle {

        Bike(int hours) {
            super(hours);
        }

        @Override
        double getCharge() {
            return hours * 10;
        }

        @Override 
        String getType() {
            return "BIKE";
        }
    }

    static class Car extends Vehicle {

        Car(int hours) {
            super(hours);
        }

        @Override 
        double getCharge() {
            return 30 + (hours - 1) * 20;
        }

        @Override 
        String getType() {
            return "CAR";
        }
    }

    static class Truck extends Vehicle {

        Truck(int hours) {
            super(hours);
        }

        @Override 
        double getCharge() {
            double charge = hours * 50;

            if (charge < 100) {
                charge = 100;
            }

            return charge;
        }

        @Override 
        String getType() {
            return "TRUCK";
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = sc.nextInt();
        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;
                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;
                default:
                    vehicles[i] = new Truck(hours);
                    break;
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.getCharge();

            System.out.printf("%s: %.2f%n",
                    vehicle.getType(), charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}