import java.util.Scanner;

public class Problem2_WeeklyStaffPay {

    static abstract class Staff {

        String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double getPay();
    }

    static class FullTime extends Staff {

        double weeklySalary;

        FullTime(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        double getPay() {
            return weeklySalary;
        }
    }

    static class Hourly extends Staff {

        double hours;
        double rate;

        Hourly(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double getPay() {

            if (hours <= 40) {
                return hours * rate;
            }

            return (40 * rate) +
                   ((hours - 40) * rate * 1.5);
        }
    }

    static class Intern extends Staff {

        double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double getPay() {
            return stipend;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Staff staff;

            if (type.equals("FULLTIME")) {

                double salary = sc.nextDouble();
                staff = new FullTime(name, salary);

            } else if (type.equals("HOURLY")) {

                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                staff = new Hourly(name, hours, rate);

            } else {

                double stipend = sc.nextDouble();
                staff = new Intern(name, stipend);
            }

            double pay = staff.getPay();

            System.out.printf(
                "%s: %.2f%n",
                staff.name,
                pay
            );

            totalPayroll += pay;
        }

        System.out.printf(
            "Total Payroll: %.2f%n",
            totalPayroll
        );

        sc.close();
    }
}