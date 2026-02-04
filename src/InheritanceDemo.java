import java.util.ArrayList;

public class InheritanceDemo {

    public static void main(String[] args) {

        ArrayList<Worker> workers = new ArrayList<>();

        // 3 hourly Workers
        workers.add(new Worker("W001", "John", "Doe", "Mr.", 1998, 18.50));
        workers.add(new Worker("W002", "Amy", "Lee", "Ms.", 2001, 22.00));
        workers.add(new Worker("W003", "Carlos", "Rivera", "Mr.", 1997, 20.00));

        // 3 SalaryWorkers (still stored as Worker because of inheritance)
        workers.add(new SalaryWorker("S001", "Sara", "Kim", "Dr.", 1985, 30.00, 78000.00));
        workers.add(new SalaryWorker("S002", "Minh", "Nguyen", "Mr.", 1990, 28.00, 65000.00));
        workers.add(new SalaryWorker("S003", "Lina", "Patel", "Ms.", 1992, 25.00, 52000.00));

        // Week hours: 40, 50, 40
        double[] weekHours = {40, 50, 40};

        for (int week = 0; week < weekHours.length; week++) {
            double hours = weekHours[week];

            System.out.println("\n==============================");
            System.out.println("WEEK " + (week + 1) + " (Hours: " + hours + ")");
            System.out.println("==============================");

            for (Worker w : workers) {
                // This line uses polymorphism:
                // Hourly workers calculate overtime, SalaryWorkers ignore hours and use salary/52
                w.displayWeeklyPay(hours);
            }
        }
    }
}
