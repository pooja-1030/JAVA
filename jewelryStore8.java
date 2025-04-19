import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JewelryStore8 {
    
    // Method to write jewelry information to a file
    public static void writeToFile(String data, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
            System.out.println("Data has been written to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read jewelry information from a file
    public static void readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new IOException("File not found!");
            }
            FileReader reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            System.out.println("\nReading data from the file: " + fileName);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            reader.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }

    // Main method demonstrating file handling and exception handling
    public static void main(String[] args) {
        // Define the file name
        String fileName = "JewelryStoreInfo.txt";

        // Program information to write to the file
        String jewelryInfo = "Jewelry Store Information:\n"
                           + "1. Jewelry Type: Necklace\n"
                           + "2. Material: Gold\n"
                           + "3. Weight: 10 grams\n"
                           + "4. Price per gram: 5000 INR\n"
                           + "5. Total Price: 50000 INR";

        // Write data to the file
        writeToFile(jewelryInfo, fileName);

        // Read data from the file
        readFromFile(fileName);

        // Demonstrating exception handling for a non-existent file
        System.out.println("\nAttempting to read from a non-existent file:");
        readFromFile("NonExistentFile.txt");
    }
}
