import java.util.Scanner;

public class CSVStudentRecord {

    static void parseStudentRecord(String csvLine) {
        String[] details = csvLine.split(",");

        if (details.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + details[0] +
                " | Roll No: " + details[1] +
                " | Dept: " + details[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String csvLine = sc.nextLine();

        parseStudentRecord(csvLine);

        sc.close();
    }
}