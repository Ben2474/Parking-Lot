package javaapplication43;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * The TicketSystem class just holds a list of the license plates of cars that checked in when they parked. If there are any cars that just parked in the lot without
 * taking the proper steps, they get fined for more than double the usual fee.
 * @author spapp
 */
public class TicketSystem {
    LinkedList <String> ticketSystem; //List of license plates
    Iterator<String> iter; //Looks through the list of plates
    
    /**
     * This creates an instance of the TicketSystem list.
     */
    public TicketSystem () {
        ticketSystem = new LinkedList<>();    
    }
    
    /**
     * adds a car to the list
     * @param licenseNumber takes in the license plate of an authorized car
     */
    public void carParked (String licenseNumber) {
        ticketSystem.add(licenseNumber);    
    }
    
    /**
     * removes the inputted car from the list and issues them the normal fee
     * @param licenseNumber takes in the license plate of an authorized car
     * @return returns the output of fine(true)
     */
    public int ticketIssued (String licenseNumber) {
        ticketSystem.remove(licenseNumber);
        return fine(true);
    }
    
    /**
     * outputs whether or not the inputted car is in the list of authorized cars
     * @param licenseNumber takes in the license plate of an authorized car
     * @return outputs true or false
     */
    public boolean findCar (String licenseNumber) {
        iter = ticketSystem.iterator(); 
        while(iter.hasNext()) {
            String val = iter.next();
            if (licenseNumber.equals(val)) 
                return true;
        }
        return false;
    }
    
    /**
     * this just determines the amount that needs to be payed depending on if they are authorized
     * @param x whether or not they have a ticket. true if yes, false if no
     * @return fee amount
     */
    public int fine (boolean x) {
        if (x == true)
            return 50;
        else
            return 125;
    }
}
