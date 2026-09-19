import java.util.Scanner;

public class EmployeeProfileCreation {

    static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        public Employee(String empId, String empName) {
            this(empId, empName, 0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(empId + " | " + empName +
                    " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter permanent employee ID: ");
        String permanentId = sc.nextLine();

        System.out.print("Enter permanent employee name: ");
        String permanentName = sc.nextLine();

        System.out.print("Enter permanent employee salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        Employee permanent = new Employee(
                permanentId, permanentName, salary);

        System.out.print("Enter intern employee ID: ");
        String internId = sc.nextLine();

        System.out.print("Enter intern employee name: ");
        String internName = sc.nextLine();

        Employee intern = new Employee(internId, internName);

        permanent.printProfile();
        intern.printProfile();

        sc.close();
    }
}
}