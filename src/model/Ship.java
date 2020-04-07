package model;
import java.util.ArrayList;
public class Ship {
	
	
//Constants 
	public static final double MAXCAPACITY= 28000;
//Attributes
	
	private String name;
	private double maxCapacity;
	
//Relations
	
	private Trip currentTrip;
	private ArrayList<Trip> pastTrips;
	
//methods
/**
 * Name Ship<br>
 * This method is the constructor for the class Ship<br>	
 * @param pName must be a String, not null.
 */
	public Ship(String pName) {
		name = pName;
		maxCapacity = MAXCAPACITY;
		pastTrips= new ArrayList<Trip>();
	}
	/**
	 * Name getMaxCapacity<br>
	 * This method returns the ship's max capacity<br>
	 * @return returns a double.<br>
	 */
	public double getMaxCapacity() {
		return maxCapacity;
	}
	/**
	 * Name: setMaxCapacity <br>
	 * this method sets the max capacity for the ship<br>
	 * @param pMaxCapacity: must be a double.<br>
	 */
	public void setMaxCapacity(double pMaxCapacity) {
		maxCapacity = pMaxCapacity;
	}
	/**
	 * Name: getName<br>
	 * This method returns a String with the name of the ship<br>
	 * @return returns a String with the name of the ship´<br>
	 */
	public String getName() {
		return name;
	}
	/**
	 * Name: setName<br>
	 * This method sets the name of the ship<br>
	 * @param pName must be a String<br>
	 */
	public void setName(String pName) {
		name = pName;
	}
	/**
	 * Name: getCurrentTrip<br>
	 * This method returns the ship's current trip <br>
	 * @return an object of class Trip<br>
	 */
	public Trip getCurrentTrip() {
		return currentTrip;
	}
	/**
	 * Name: setCurrentTrip<br>
	 * This method creates a new trip and sets it as the trip's current trip<br>
	 * @param pCurrentShipmentWeight a double, not negative<br>
	 * @param pAmountShipmentLoads an integer, not negative<br>
	 * @param pDangerousCargoPresence a boolean<br> 
	 * @param pPerishableCargoPresence a boolean<br>
	 */
	public void setCurrentTrip(double pCurrentShipmentWeight, int pAmountShipmentLoads, boolean pDangerousCargoPresence, boolean pPerishableCargoPresence) {
		currentTrip = new Trip(pCurrentShipmentWeight, pAmountShipmentLoads, pDangerousCargoPresence, pPerishableCargoPresence);
	}
	/**
	 * Name registerTrip<br>
	 * This method logs the current trip in the pastTrrips ArrayList<br>
	 */
	public void registerTrip() {
		pastTrips.add(currentTrip);
	}
	/**
	 * Name getPastTrips<br>
	 * This method returns the ArrayList of past trips<br>
	 * @return an ArrayList with the trips logged.<br>
	 */
	public ArrayList<Trip> getPastTrips() {
		return pastTrips;
	}
	
}
