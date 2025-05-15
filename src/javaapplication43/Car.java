
package javaapplication43;

/**
 * The Car class is the main object that is used throughout the project. It has instance variables for the plate and make of the car and also whether or not
 * they had a ticket to get in.
 * @author spapp
 */
public class Car implements Comparable<Car> {
    
    public String licenseNumber; 
    public String brands;
    public boolean hasTicket;
    
    /**
     * Creates a null instance of Car. This is used to simulate and empty parking spot.
     */
    public Car () {
        licenseNumber = null;
        brands = null;
        boolean hasTicket = false;
    }  
    
    /**
     * Creates an instance of Car. Assigns the instance variables with the inputted values.
     * @param licenseNumber plate number
     * @param brands make of the car
     * @param hasTicket whether they had a ticket to get in
     */
    public Car (String licenseNumber, String brands, boolean hasTicket) {
        this.licenseNumber = licenseNumber;  
        this.brands = brands;
        this.hasTicket = hasTicket;
    }

    
    public String getLicenseNumber() { return licenseNumber;} //outputs plate number
    
    public String getBrands() { return brands;} //outputs make of car
    
    public boolean getTicket() { return hasTicket; } //outputs whether or not the car is authorized
    
    
    
    /**
     * An implementation of the toString() method. This puts the data from the Car object in an organized String. 
     * It also prints out a message if the parking spot is empty.
     * @return the message as a string
     */
    @Override
    public String toString() { 
        String phrase;
        if (brands == null)
            phrase = ("NULL_PARKING_SPOT    SPOT IS VACANT");
        else
            phrase = ("Regular Parking:   LICENSE: " + licenseNumber + "   MAKE: " + brands);
        return phrase; 
    } 
    
    /**
     * An implementation of the compareTo() method. Dictates how the Cars are compared when sorting. In this case,
     * they are sorted based on plate number.
     * @param that the car being compared
     * @return tells the program which string is "greater" than the other
     */
    @Override
    public int compareTo(Car that) {
        if (this.licenseNumber.compareTo(that.licenseNumber) < 0)
            return -1;
        
        else if (this.licenseNumber.compareTo(that.licenseNumber) == 0)
            return 0;
        
        else
            return 1;
    }
       
}



