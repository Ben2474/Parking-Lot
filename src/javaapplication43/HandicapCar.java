package javaapplication43;

/**
 * The HandicapCar class inherits from the Car class. The main reason for using polymorphism like this was to make
 * it easier to output the cars using toString(). It was also just more organized.
 * @author spapp
 */
public class HandicapCar extends Car {
    private String badgeNum; //Handicap badge number

    /**
     * Creates an instance of HandicapCar very similarly to Car and sets the badge number to null
     * @param licenseNumber inputted plate number
     * @param brands inputted make of car
     * @param hasTicket whether the car was authorized
     */
    public HandicapCar(String licenseNumber, String brands, boolean hasTicket) {
        super(licenseNumber, brands, hasTicket);
        badgeNum = null;
    }
    
    /**
     * This creates yet another instance of HandicapCar like the last one but uses the inputted badge number this time.
     * @param licenseNumber inputted plate number
     * @param brands inputted make of car
     * @param hasTicket whether the car was authorized
     * @param idNum inputted handicap badge number
     */
    public HandicapCar (String licenseNumber, String brands, boolean hasTicket, String idNum) {
        super(licenseNumber, brands, hasTicket);
        this.badgeNum = idNum;
    }
    
    public String getID() { return badgeNum; } //outputs the handicap badge number
    
    /**
     * Implementation of toString(). Very similar to the Car variation with the addition of the handicap badge number.
     * @return outputs the String message
     */
    @Override
    public String toString() {
        String phrase = ("Handicap: " + badgeNum + "   LICENSE: " + licenseNumber + "   MAKE: " + brands);
        return phrase;
    } 
       
}


