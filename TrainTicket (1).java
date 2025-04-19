public class TrainTicket {
    private String trainName;
    private int ticketNumber;
    private String seatClass;
    private double price;

    public TrainTicket(String trainName, int ticketNumber, String seatClass, double price) {
        this.trainName = trainName;
        this.ticketNumber = ticketNumber;
        this.seatClass = seatClass;
        this.price = price;
    }

    
    public void displayTicketInfo() {
        System.out.println("Train Name: " + trainName);
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Seat Class: " + seatClass);
        System.out.println("Price: $" + price);
    }

    public void bookTicket(String seatClass) {
        System.out.println("Booking a " + seatClass + " class ticket.");
    
    }

 
    public void bookTicket(String seatClass, double price) {
        System.out.println("Booking a " + seatClass + " class ticket with price $" + price);
      
    }

    public static void main(String[] args) {
      
        TrainTicket ticket = new TrainTicket("Express Train", 12345, "Economy", 50.0);

        Passenger passenger = new Passenger("John Doe", 30);

        
        passenger.bookTicket(ticket, "Economy");
        passenger.bookTicket(ticket, "Business", 100.0);


        ticket.displayTicketInfo();
    }
}

class Passenger {
    private String name;
    private int age;

    
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    
    public void bookTicket(TrainTicket ticket, String seatClass) {
        System.out.println(name + " is booking a ticket.");
        ticket.bookTicket(seatClass);
    }

    
    public void bookTicket(TrainTicket ticket, String seatClass, double price) {
        System.out.println(name + " is booking a ticket.");
        ticket.bookTicket(seatClass, price);
    }
}
