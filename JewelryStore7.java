// File: JewelryStore.java

// Package P1
package P1;
public class JewelryDetails {
    // Method 1: Display jewelry type
    public void displayJewelryType() {
        System.out.println("Jewelry Type: Necklace");
    }

    // Method 2: Display jewelry material
    public void displayJewelryMaterial() {
        System.out.println("Material: Gold");
    }
}

// Package P2
package P2;
public class PriceDetails {
    // Method 1: Calculate price based on weight
    public double calculatePrice(double weight) {
        double pricePerGram = 5000; // Assuming 5000 per gram for gold
        return weight * pricePerGram;
    }

    // Method 2: Calculate price with tax
    public double calculatePriceWithTax(double weight) {
        double price = calculatePrice(weight);
        double taxRate = 0.05; // 5% tax
        return price + (price * taxRate);
    }
}

// Main Program
import P1.JewelryDetails;
import P2.PriceDetails;

public class JewelryStore7 {
    public static void main(String[] args) {
        // Create objects of both classes
        JewelryDetails jewelry = new JewelryDetails();
        PriceDetails price = new PriceDetails();

        // Call methods from P1 (JewelryDetails)
        jewelry.displayJewelryType();
        jewelry.displayJewelryMaterial();

        // Call methods from P2 (PriceDetails)
        double weight = 10; // 10 grams of gold
        System.out.println("Price (without tax) for " + weight + " grams: " + price.calculatePrice(weight));
        System.out.println("Price (with tax) for " + weight + " grams: " + price.calculatePriceWithTax(weight));
    }
}
