import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewal {

    static abstract class Plan {
        protected String name;
        protected LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int getValidityDays();

        LocalDate getRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    static class BasicPlan extends Plan {

        BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Plan {

        StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Plan {

        PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        int n = sc.nextInt();
        Plan[] plans = new Plan[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            switch (type) {
                case "BASIC":
                    plans[i] = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    plans[i] = new StandardPlan(name, startDate);
                    break;
                default:
                    plans[i] = new PremiumPlan(name, startDate);
                    break;
            }
        }

        for (Plan plan : plans) {
            System.out.println(plan.name + ": " +
                    plan.getRenewalDate());
        }

        sc.close();
    }
}
}