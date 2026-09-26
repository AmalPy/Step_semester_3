import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {
        protected int units;

        Room(int units) {
            this.units = units;
        }

        abstract double getBill();

        abstract String getType();
    }

    static class SingleRoom extends Room {

        SingleRoom(int units) {
            super(units);
        }

        @Override 
        double getBill() {
            return units * 8;
        }

        @Override
        String getType() {
            return "SINGLE";
        }
    }

    static class SharedRoom extends Room {

        private final int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        double getBill() {
            return (units * 6.0) / occupants;
        }

        @Override
        String getType() {
            return "SHARED";
        }
    }

    static class ACRoom extends Room {

        ACRoom(int units) {
            super(units);
        }

        @Override
        double getBill() {
            return units * 10 + 200;
        }

        @Override
        String getType() {
            return "AC";
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = sc.nextInt();
        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms[i] = new SharedRoom(units, occupants);
                    break;
                default:
                    rooms[i] = new ACRoom(units);
                    break;
            }
        }

        double total = 0;

        for (Room room : rooms) {
            double bill = room.getBill();

            System.out.printf("%s: %.2f%n",
                    room.getType(), bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}