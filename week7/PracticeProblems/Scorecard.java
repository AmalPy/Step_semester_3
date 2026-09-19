import java.util.Scanner;

public class Scorecard {

    private boolean[] results;
    private int answerCount;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount >= results.length) {
            System.out.println("Cannot record more answers");
            return;
        }

        results[answerCount] = correct;
        answerCount++;
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter number of questions: ");
        int totalQuestions = sc.nextInt();

        Scorecard scorecard = new Scorecard(totalQuestions);

        for (int i = 0; i < totalQuestions; i++) {
            System.out.print("Was answer " + (i + 1) + " correct? true/false: ");
            boolean correct = sc.nextBoolean();

            scorecard.recordAnswer(correct);
        }

        System.out.println("Score: " + scorecard.getScore());

        sc.close();
    }
}
}