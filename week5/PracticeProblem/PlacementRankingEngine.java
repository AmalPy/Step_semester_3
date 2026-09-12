import java.util.Arrays;
import java.util.Scanner;

public class PlacementRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        public static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        public double getCompositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.cgpa) ||
                Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[count] = candidate;
                count++;
            }
        }

        Candidate[] result = Arrays.copyOf(shortlisted, count);

        Arrays.sort(result);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            output.append(i + 1)
                    .append(". ")
                    .append(result[i].getName())
                    .append(" (")
                    .append(String.format("%.1f", result[i].getCompositeScore()))
                    .append(")");

            if (i < result.length - 1) {
                output.append(" | ");
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Candidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println(shortlistAndRank(candidates));

        sc.close();
    }
}
}