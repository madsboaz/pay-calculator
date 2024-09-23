import java.util.Scanner;

public class Main {

    private static final String[] regions = {"US", "Japan", "UK", "European", "Spain", "Germany", "Belgium"};

    public static void main(String[] args) {
        displayGreeting();

        // Testing calcGrossPay with different values
        double grossPay1 = calcGrossPay(50, 16);
        double grossPay2 = calcGrossPay(27.09, 8);

        // Displaying the calculated gross pay
        System.out.println("Gross Pay 1: $" + grossPay1);
        System.out.println("Gross Pay 2: $" + grossPay2);

        // Display regions menu
        displayRegionsMenu();

        // Get user's selection
        Scanner scanner = new Scanner(System.in);
        int userSelection = scanner.nextInt();

        // Format the date string using the selected region
        String formattedDate = formatDateString(2, 19, 2024, "Sunday", "11", "59", "PM", regions[userSelection - 1]);

        // Display the formatted date string
        System.out.println("Formatted Date: " + formattedDate);

        // Displaying the exit message
        closeApp();
    }

    // Method to display a greeting
    public static void displayGreeting() {
        System.out.println("Welcome to the pay calculator section of the HR app!");
    }

    // Method to calculate gross pay
    public static double calcGrossPay(double payRate, int hoursWorked) {
        if (payRate > 0 && payRate <= 120 && hoursWorked > 0 && hoursWorked <= 15) {
            return payRate * hoursWorked;
        } else {
            return 0;
        }
    }

    // Method to format date string
    public static String formatDateString(int month, int day, int year, String dayName, String hours, String minutes, String timeOfDay, String region) {
        String formattedDate;
        switch (region.toLowerCase()) {
            case "us":
                formattedDate = String.format("US Format: %s, %s %d, %d: %s:%s %s",
                        dayName, getMonthName(month), day, year, hours, minutes, timeOfDay);
                break;
            case "japan":
            case "iraq":
            case "korea":
                formattedDate = String.format("Year First Format: %d %s %d (%s) %s:%s %s",
                        year, getMonthName(month), day, dayName, hours, minutes, timeOfDay);
                break;
            case "european":
            case "uk":
            case "spain":
            case "germany":
            case "belgium":
                formattedDate = String.format("%s, %d %s %d %s:%s",
                        dayName, day, getMonthName(month), year, hours, minutes);
                break;
            default:
                throw new IllegalArgumentException("Unsupported region: " + region);
        }
        return formattedDate;
    }

    public static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }
    // Method to display regions menu
    public static void displayRegionsMenu() {
        System.out.println("Options for date display:");
        for (int i = 0; i < regions.length; i++) {
            System.out.printf("%d. %s\n", i + 1, regions[i]);
        }
        System.out.println("Select the option you wish to use:");
    }

    // Method to close the app
    public static void closeApp() {
        System.out.println("Goodbye and thank you for using our pay calculator app.");
    }
}