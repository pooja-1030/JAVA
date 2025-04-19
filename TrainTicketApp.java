import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for Booking Tickets
interface TicketBooking {
    void bookTicket(String trainName, String passengerName, int seats);
}

// Interface for Managing Bookings
interface BookingManagement {
    void displayTickets();
}

// Interface for Customer Support
interface CustomerSupport {
    void assistCustomer(String customerName, String query);
}

// Class representing a Train Ticket
class TrainTicket {
    private String trainName;
    private String passengerName;
    private int seatsBooked;

    public TrainTicket(String trainName, String passengerName, int seatsBooked) {
        this.trainName = trainName;
        this.passengerName = passengerName;
        this.seatsBooked = seatsBooked;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }
}

// Class that implements all the interfaces
class TrainTicketBookingSystem implements TicketBooking, BookingManagement, CustomerSupport {
    private List<TrainTicket> bookedTickets = new ArrayList<>();

    // Implement Ticket Booking
    public void bookTicket(String trainName, String passengerName, int seats) {
        TrainTicket ticket = new TrainTicket(trainName, passengerName, seats);
        bookedTickets.add(ticket);
        System.out.println("Ticket booked for " + passengerName + " on train " + trainName + " for " + seats + " seat(s).");
    }

    // Implement Booking Management
    public void displayTickets() {
        if (bookedTickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
        } else {
            System.out.println("\nBooked Tickets:");
            for (TrainTicket ticket : bookedTickets) {
                System.out.println("Passenger: " + ticket.getPassengerName() + ", Train: " + ticket.getTrainName() + ", Seats: " + ticket.getSeatsBooked());
            }
        }
    }

    // Implement Customer Support
    public void assistCustomer(String customerName, String query) {
        System.out.println("\nAssisting " + customerName + " with query: " + query);
    }
}

// Main class to run the application
public class TrainTicketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrainTicketBookingSystem bookingSystem = new TrainTicketBookingSystem();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nTrain Ticket Booking Menu:");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Display Booked Tickets");
            System.out.println("3. Assist Customer");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Train Name: ");
                    String trainName = scanner.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter Number of Seats: ");
                    int seats = scanner.nextInt();
                    bookingSystem.bookTicket(trainName, passengerName, seats);
                    break;

                case 2:
                    bookingSystem.displayTickets();
                    break;

                case 3:
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Customer Query: ");
                    String query = scanner.nextLine();
                    bookingSystem.assistCustomer(customerName, query);
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting Train Ticket Booking System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
