import java.util.Scanner;

public class FestivalBonusCalculator {

    static abstract class Employee {
        protected String name;
        protected double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        abstract double getBonus();
    }

    static class FullTimeEmployee extends Employee {

        FullTimeEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        double getBonus() {
            return salary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {

        PartTimeEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        double getBonus() {
            return salary * 0.05;
        }
    }

    static class Intern extends Employee {

        Intern(String name, double salary) {
            super(name, salary);
        }

        @Override
        double getBonus() {
            return 2000;
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = sc.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees[i] = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employees[i] = new PartTimeEmployee(name, salary);
                    break;
                default:
                    employees[i] = new Intern(name, salary);
                    break;
            }
        }

        double totalBonus = 0;

        for (Employee employee : employees) {
            double bonus = employee.getBonus();

            System.out.printf("%s: %.2f%n",
                    employee.name, bonus);

            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}
}