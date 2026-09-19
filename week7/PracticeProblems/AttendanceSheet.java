import java.util.Scanner;

public class AttendanceSheet {

    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxStudents) {
        presentStudents = new String[maxStudents];
        count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter maximum class size: ");
        int maxStudents = sc.nextInt();
        sc.nextLine();

        AttendanceSheet sheet = new AttendanceSheet(maxStudents);

        System.out.print("Enter number of students to mark present: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            sheet.markPresent(name);
        }

        System.out.println("Present count: " + sheet.getPresentCount());

        System.out.print("Enter name to check: ");
        String name = sc.nextLine();

        System.out.println("Is present: " + sheet.isPresent(name));

        sc.close();
    }
}
}