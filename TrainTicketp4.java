import java.util.Scanner;

// Class representing a Train Ticket
public class TrainTicketp4 {
    // Attributes
    private String ticketNumber;
    private String passengerName;
    private String trainNumber;
    private double price;

    // No-argument constructor initializing default values
    public TrainTicketp4() {
        this.ticketNumber = "UNKNOWN";
        this.passengerName = "UNKNOWN";
        this.trainNumber = "UNKNOWN";
        this.price = 0.0;
    }

    // Parameterized constructor initializing all attributes
    public TrainTicketp4(String ticketNumber, String passengerName, String trainNumber, double price) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.price = price;
    }

    // Method with arguments
    public void updateTicketDetails(String ticketNumber, String passengerName) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
    }

    // Method without arguments
    public void displayTicketInfo() {
        System.out.println("Ticket Number: " + this.ticketNumber);
        System.out.println("Passenger Name: " + this.passengerName);
        System.out.println("Train Number: " + this.trainNumber);
        System.out.println("Price: $" + this.price);
    }

    // Method with return type
    public double calculateDiscountedPrice(double discountPercentage) {
        return this.price - (this.price * discountPercentage / 100);
    }

    // Method without return type
    public void applyDiscount(double discountPercentage) {
        this.price = this.calculateDiscountedPrice(discountPercentage);
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a TrainTicket object using the no-argument constructor
        TrainTicketp4 defaultTicket = new TrainTicketp4();
        System.out.println("Default Ticket Info:");
        defaultTicket.displayTicketInfo();

        // Creating a TrainTicket object using the parameterized constructor
        TrainTicketp4 customTicket = new TrainTicketp4("12345", "Alice", "TrainA1", 150.0);

        // Displaying the custom ticket info
        System.out.println("\nCustom Ticket Info:");
        customTicket.displayTicketInfo();

        // Updating ticket details
        System.out.println("\nUpdating Ticket Details:");
        customTicket.updateTicketDetails("67890", "Bob");
        customTicket.displayTicketInfo();

        // Applying discount
        System.out.println("\nApplying Discount:");
        customTicket.applyDiscount(10); // Applying 10% discount
        customTicket.displayTicketInfo();

        // Reading input from the user
        System.out.println("\nEnter Ticket Number:");
        String ticketNumber = scanner.nextLine();
        System.out.println("Enter Passenger Name:");
        String passengerName = scanner.nextLine();
        System.out.println("Enter Train Number:");
        String trainNumber = scanner.nextLine();
        System.out.println("Enter Price:");
        double price = scanner.nextDouble();

        // Creating a new TrainTicket object with user input
        TrainTicketp4 userTicket = new TrainTicketp4(ticketNumber, passengerName, trainNumber, price);
        System.out.println("\nUser Ticket Info:");
        userTicket.displayTicketInfo();

        scanner.close();
    }
}

