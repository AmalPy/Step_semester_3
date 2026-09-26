import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationGrader {

    static abstract class Question {
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected double points;

        Question(String questionText, String correctAnswer,
                 String studentAnswer, double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double getScore();

        abstract String getType();
    }

    static class MCQ extends Question {

        MCQ(String questionText, String correctAnswer,
            String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override 
        double getScore() {
            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }

            return 0;
        }

        @Override 
        String getType() {
            return "MCQ";
        }
    }

    static class TrueFalse extends Question {

        TrueFalse(String questionText, String correctAnswer,
                  String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override 
        double getScore() {
            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }

            return 0;
        }

        @Override 
        String getType() {
            return "TF";
        }
    }

    static class Essay extends Question {

        Essay(String questionText, String correctAnswer,
              String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override 
        double getScore() {
            String[] keywords = correctAnswer.split(",");
            String answer = studentAnswer.toLowerCase();

            int found = 0;

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase())) {
                    found++;
                }
            }

            if (found >= 2) {
                return points * 0.75;
            }

            if (found == 1) {
                return points * 0.50;
            }

            return 0;
        }

        @Override 
        String getType() {
            return "ESSAY";
        }
    }

    static String[] getParts(String line) {
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);

        String[] parts = new String[5];
        int count = 0;

        while (matcher.find() && count < 5) {
            if (matcher.group(1) != null) {
                parts[count++] = matcher.group(1);
            } else {
                parts[count++] = matcher.group(2);
            }
        }

        return parts;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = Integer.parseInt(sc.nextLine());
        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = getParts(line);

            String type = parts[0];
            String questionText = parts[1];
            String correctAnswer = parts[2];
            String studentAnswer = parts[3];
            double points = Double.parseDouble(parts[4]);

            switch (type) {
                case "MCQ":
                    questions[i] = new MCQ(
                            questionText, correctAnswer,
                            studentAnswer, points);
                    break;
                case "TF":
                    questions[i] = new TrueFalse(
                            questionText, correctAnswer,
                            studentAnswer, points);
                    break;
                default:
                    questions[i] = new Essay(
                            questionText, correctAnswer,
                            studentAnswer, points);
                    break;
            }
        }

        double total = 0;

        for (Question question : questions) {
            double score = question.getScore();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}
}