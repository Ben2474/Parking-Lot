package javaapplication43;

import java.util.Scanner;


/**
 * This is the main class where most of the magic happens. There are 10 instances of cars with 2 of them being one with handicap badges. It adds them to the LinkedList. After it asks the user
 * if they would like to pick up their car. From their you can pick up a car, sort the cars in the parking lot, or just exit the program.
 * @author spapp
 */
public class CarGarage {
       public static void main(String[] args) throws InterruptedException {
        ParkingGarage<Car> garageList = new ParkingGarage<>();
        Scanner scan = new Scanner(System.in);
        TicketSystem tic = new TicketSystem();
        
        Car c1 = new Car("ZYX-9887","BMW", true);
        Car c2 = new Car("WVU-6254","Ford", true);
        Car c3 = new Car("TSR-3251","Honda", false);
        HandicapCar h1 = new HandicapCar("KMF-4223", "Honda", true,"300248");
        Car c4 = new Car("QPO-0182","Toyota", true);
        Car c5 = new Car("NML-3454","Bugatti", true);
        Car c6 = new Car("KJW-6178","Nissan", false);        
        Car c7 = new Car("KMF-9130","Volkswagon", true);
        HandicapCar h2 = new HandicapCar("JDR-3977", "Chevrolet", true,"491756");
        Car c8 = new Car("EMG-1501","Lambo", true);
                                
        garageList.add(c1);
        garageList.add(c2);
        garageList.add(c3);
        garageList.add(h1);
        garageList.add(c4);
        garageList.add(c5);
        garageList.add(c6);
        garageList.add(c7);
        garageList.add(h2);
        garageList.add(c8);
        System.out.print(garageList.toString());
        for(int i = 0; i<garageList.size(); i++) {
            if (garageList.outputCar(i).getTicket()) {
                tic.carParked(garageList.outputCar(i).getLicenseNumber()); //goes through linkedlist and adds cars with authorization to the ticketsytsem list
            }
        }
        
        ParkingGarage<Car> sortedList = new ParkingGarage<>(garageList);
        
              
     
        boolean running = true;
        while (running) {            
            System.out.println("\n\nIf you would like to pick up a car, type 1.\nIf you would like to view a list of the cars in order by license plate, type 2."
            + "\nIf you would like to exit the program, type 3.");
            int i = scan.nextInt();
            
            if (i != 1 && i != 2 && i != 3)
                System.out.println("ERROR_INVALID_INPUT");
            
            else if(i == 3) {
                System.out.println("\nProgram_Exited");
                running = false;
            }           
            else if(i == 2) {
                sortedList.sort();
                System.out.println(sortedList.toString());  
            }  
            else {
                System.out.println("Enter the number of the car you are picking up.");
                int pickup = scan.nextInt();
                if (pickup < 1 || pickup > 10)
                    System.out.println("ERROR_INVALID_INPUT");
                else {
                    Car pickedUp = garageList.outputCar(pickup);
                    garageList.setCarNull(pickup);

                    if (pickedUp.getBrands() == null)
                        System.out.println("PARKING SPACE ALREADY EMPTY\n");

                    else if(!tic.findCar(pickedUp.getLicenseNumber())) 
                        System.out.println("\nYou have been issued a parking ticket for unauthorized parking. You must pay the $" + tic.fine(false) + ".00 on your way out.");              

                    else 
                        System.out.println("\nCar picked up successfully with a fee of $" + tic.ticketIssued(pickedUp.getLicenseNumber()) + ".00\n");

                    Thread.sleep(2000);                
                    System.out.println(garageList.toString());
                }
            }
        }
    } 
}




