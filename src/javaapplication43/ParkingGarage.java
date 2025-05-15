package javaapplication43;


/**
 * ParkingGarage is a doubly LinkedList that I used in order to store all the data from the parking lot. It stores both the Car and HandicapCar objects.
 * @author spapp
 * @param <C> This LinkedList is generic and extends Car so that it can handle both car objects very well.
 */
public class ParkingGarage<C extends Car> {
    /**
     * The Node class and its constructors. Each node points to the next node and the previous one as well as holds a car object.
     * @param <C> Once again it is generic so that it is able to deal with car objects easier.
     */
    private class Node<C extends Car> {
        Node next;
        Node prev;
        Car car;
        
        /**
         * instance of Node. uses inputted values to determine where in the chain it goes
         * @param n next node
         * @param p previous node
         * @param newCar car object
         */
        public Node(Node n, Node p, Car newCar) {
            next = n;
            prev = p;
            car = newCar;
        }
        
        /**
         * This is a more basic constructor that only assigns the node with a car object
         * @param newCar inputted car object
         */
        public Node(Car newCar) {
            next = null;
            prev = null;
            car = newCar;
        }
        /**
         * This is a copy constructor for Nodes. This is used to make a copy of a Node instance and potentially a whole LinkedList.
         * @param n the node that is being copied
         */
        public Node (Node n) {
            next = n.next;
            prev = n.prev;
            car = n.car;
        }
        
    }
    
    private Node first; //first node in the list
    private Node last; //last node in the list

    /**
     * creates an instance of the list. assigns first and last null
     */
    public ParkingGarage() {
        first = null;
        last = null;
    }
    
    /**
     * Copy constructor for a LinkedList. This is used in tandem with the copy constructor for Nodes to copy a whole LinkedList
     * @param list LinkedList being copied
     */
    public ParkingGarage(ParkingGarage list) {
        Node<Car> n = list.first; 
        
        first = new Node(n);
        last = first;
        
        while(n.next!=null) {
            last = last.next;
            n = n.next;
            last = new Node(n);
        }
    }

    /**
     * checks if the list is empty
     * @return outputs true if empty, false if not
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * outputs the size of the list
     * @return outputs the size
     */
    public int size() {
        int count = 0;
        Node p = first;
        while(p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    /**
     * adds an object to the linkedlist
     * @param index the desired index of the new Node
     * @param newCar the car object inputted
     */
    public void add(int index, Car newCar) {
        if (index == 0) {  // This above part checks to see if the inputted index is 0 since it would just need to be added at the beginning
            Node<Car> p = first; 
            first = new Node<C>(p, null, newCar);
            if (p != null)
                p.prev = first;
            if (last == null)
                last = first;
            return;
        }
        
        Node<Car> pred = first;
        for (int k = 1; k <= index - 1; k++)
        {
            pred = pred.next;
        }
        
        Node<Car> succ = pred.next;
        Node<Car> middle = new Node<>(succ, pred, newCar);
        pred.next = middle;
        if (succ == null)
            last = middle;
        else
            succ.prev = middle;
    }
    
    /**
     * adds an object to the end of the linkedlist
     * @param newCar inputted car object
     */
    public void add(Car newCar) {        
        if (isEmpty())
        {
            last = new Node<C>(newCar);
            first = last;
        }
        
        else if (newCar instanceof HandicapCar) {
            Node newFirst = new Node<C>(first, null, newCar);
            first.prev = newFirst;
            first = first.prev;
        } 
        
        else
        {
            last.next = new Node<C>(null, last, newCar);
            last = last.next;
        }              
    }
    
    /**
     * outputs the desired car
     * @param index desired car location
     * @return outputs desired car
     */
    public Car outputCar(int index) {
        Node<C> target = first;
        for (int k = 1; k <= index-1; k++)
            target = target.next;
        return (Car) target.car;
    }
    /**
     * This replaces an existing car with an empty parking spot after the car has been picked up
     * @param index location of picked up car
     */
    public void setCarNull(int index) {
        Node<C> target = first;
        for (int k = 1; k <= index-1; k++)
            target = target.next;
        target.car = new Car();
    }
    /**
     * Implementation of toString(). Makes printing out the contents of list much easier. Works in tandem with the 
     * toString() methods from Car and HandicapCar to print the data in an organized fashion.
     * @return the String message
     */
    @Override
    public String toString() {
        String phrase = "///////////////CARS CURRENTLY PARKED/////////////////\n";
        int count = 1;
        Node<Car> c = first;
        
        if(c == null)
            return "";
        
        while (c.next !=null) {
            phrase = phrase + count + ". " + String.valueOf(c.car) + "\n";
            c = c.next;
            count++;
        }
        
        phrase = phrase + count + ". " + String.valueOf(c.car) + "\n";
        return phrase + "//////////////////////////////////////////////////////";
    }
  /**
   * This is a kind of bubbleSort. It iterates through the LinkedList looking at all the plate numbers of the cars and organizes them alphabetically. It does this by slowly going
   * through them and comparing the plate numbers to adjacent car objects in the chain of Nodes.
   * @return the first node
   */
    public Node sort() {
        int swap = -1;
        if (first == null)
            return null;
        
        Node temp1 = first;
        Node temp2 = null;
        
        while(swap != 0) {
            swap = 0;
            temp1 = first;
            
            while(temp1.next != temp2) {
                
                if (temp1.car.compareTo(temp1.next.car) == 1) {
                    Car holder = temp1.car;
                    temp1.car = temp1.next.car;
                    temp1.next.car = holder;
                    swap = 1;
                }
                temp1 = temp1.next;
            }
            temp2 = temp1;
        }
        System.out.println("\nCAR LIST HAS BEEN SORTED BY LICENSE PLATE");
        return first;
    }
    
}






