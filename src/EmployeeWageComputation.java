public class EmployeeWageComputation {
    public static void main(String args[]) {
        Company[] arr;
        arr = new Company[3];

        arr[0] = new Company(200, 20, 100);
        arr[1] = new Company(250, 30, 110);
        arr[2] = new Company(270, 35, 105);

        System.out.println("Company 1");
        arr[0].monthlyWage();
        arr[0].totalMonthlyWage();
        System.out.println("******************************");
        System.out.println();

        System.out.println("Company 2");
        arr[1].monthlyWage();
        arr[1].totalMonthlyWage();
        System.out.println("******************************");
        System.out.println();

        System.out.println("Company 3");
        arr[2].monthlyWage();
        arr[2].totalMonthlyWage();
        System.out.println("******************************");
        System.out.println();
    }
}

class Company {
    public int wagePerHour, maxWorkingDays, MaxWorkingHrs, empHrs = 0, dailyWage = 0,
            totalWage = 0, totalWorkingDays = 0;

    Company(int wage, int days, int hours) {
        this.wagePerHour = wage;
        this.maxWorkingDays = days;
        this.MaxWorkingHrs = hours;
    }

    double todaysAttendance() {
        return Math.floor(Math.random() * 10) % 3;
    }

    void monthlyWage() {
        while (totalWorkingDays < maxWorkingDays && empHrs < MaxWorkingHrs) {

            totalWorkingDays++;
            double attendance = todaysAttendance();

            switch ((int) attendance) {
                case 1:
                    empHrs = 8;
                    dailyWage = empHrs * wagePerHour;
                    System.out.println("Day: " + totalWorkingDays);
                    System.out.println("Employee is Present for Full-Time.");
                    System.out.println("Employee Daily Wage is: " + dailyWage);
                    System.out.println("-------------------------");
                    break;
                case 2:
                    empHrs = 4;
                    dailyWage = empHrs * wagePerHour;
                    System.out.println("Day: " + totalWorkingDays);
                    System.out.println("Employee is Present for Part-time.");
                    System.out.println("Employee Daily Wage is: " + dailyWage);
                    System.out.println("-------------------------");
                    break;
                default:
                    dailyWage = empHrs * wagePerHour;
                    System.out.println("Day: " + totalWorkingDays);
                    System.out.println("Employee is Absent.");
                    System.out.println("Employee Daily Wage is: " + dailyWage);
                    System.out.println("-------------------------");
                    break;
            }
            totalWage += dailyWage;
        }
    }

    void totalMonthlyWage() {
        System.out.println("Total Monthly Wage: " + totalWage);
    }
}
