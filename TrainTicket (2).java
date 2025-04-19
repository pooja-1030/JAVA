// Base Class: TrainTicket
class TrainTicket {
    String trainName;
    double fare;

    public TrainTicket(String trainName, double fare) {
        this.trainName = trainName;
        this.fare = fare;
    }

    public void displayDetails() {
        System.out.println("Train Name: " + trainName + ", Fare: $" + fare);
    }

    public void printTicket() {
        System.out.println("Printing ticket...");
    }

    // Main method to test the inheritance hierarchy
    public static void main(String[] args) {
        SleeperTicket sleeperTicket = new SleeperTicket("Express Train", 150.0, "Lower");
        sleeperTicket.displayDetails();
        System.out.println();

        ACFirstClassTicket acFirstClassTicket = new ACFirstClassTicket("Superfast Train", 500.0, "1A", 5);
        acFirstClassTicket.displayDetails();
        System.out.println();

        GeneralTicket generalTicket = new GeneralTicket("Local Train", 50.0, "Unreserved");
        generalTicket.displayDetails();
    }
}

// Single Inheritance: SleeperTicket extends TrainTicket
class SleeperTicket extends TrainTicket {
    String berthType;

    public SleeperTicket(String trainName, double fare, String berthType) {
        super(trainName, fare);
        this.berthType = berthType;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Berth Type: " + berthType);
    }
}

// Multilevel Inheritance: ACFirstClassTicket extends SleeperTicket
class ACFirstClassTicket extends SleeperTicket {
    int cabinNumber;

    public ACFirstClassTicket(String trainName, double fare, String berthType, int cabinNumber) {
        super(trainName, fare, berthType);
        this.cabinNumber = cabinNumber;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Cabin Number: " + cabinNumber);
    }
}

// Hierarchical Inheritance: GeneralTicket extends TrainTicket
class GeneralTicket extends TrainTicket {
    String seatType;

    public GeneralTicket(String trainName, double fare, String seatType) {
        super(trainName, fare);
        this.seatType = seatType;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seat Type: " + seatType);
    }
}
