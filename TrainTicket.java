import java.util.Scanner;

public class TrainTicket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Display the menu
            System.out.println("Train Ticket Booking Menu:");
            System.out.println("1. Express Train - $100 per ticket");
            System.out.println("2. Local Train - $50 per ticket");
            System.out.println("3. Sleeper Train - $70 per ticket");
            System.out.println("4. Bullet Train - $150 per ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            // Read the user choice
            int choice = scanner.nextInt();

            // Decision making using switch statement
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    // For these cases, we need the number of tickets from the user
                    System.out.print("Enter the number of tickets: ");
                    int numTickets = scanner.nextInt();
                    if (numTickets <= 0) {
                        System.out.println("Invalid number of tickets. Please enter a positive number.");
                    } else {
                        calculateTotalCost(choice, numTickets);
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
        System.out.println("Thank you for using Train Ticket Booking System!");
        scanner.close();
    }

    // Method to calculate the total cost based on the chosen train and number of tickets
    private static void calculateTotalCost(int choice, int numTickets) {
        double pricePerTicket = 0;
        String trainType = "";

        switch (choice) {
            case 1:
                pricePerTicket = 100;
                trainType = "Express Train";
                break;
            case 2:
                pricePerTicket = 50;
                trainType = "Local Train";
                break;
            case 3:
                pricePerTicket = 70;
                trainType = "Sleeper Train";
                break;
            case 4:
                pricePerTicket = 150;
                trainType = "Bullet Train";
                break;
        }

        double totalCost = pricePerTicket * numTickets;
        System.out.println("Booking Summary:");
        System.out.println("Train Type: " + trainType);
        System.out.println("Number of Tickets: " + numTickets);
        System.out.println("Total Cost: $" + totalCost);
    }
}
