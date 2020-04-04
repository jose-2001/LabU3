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
	
	public Ship(String pName) {
		name = pName;
		maxCapacity = MAXCAPACITY;
		pastTrips= new ArrayList<Trip>();
	}
	public double getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(double pMaxCapacity) {
		maxCapacity = pMaxCapacity;
	}
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		name = pName;
	}
	public Trip getCurrentTrip() {
		return currentTrip;
	}
	public void setCurrentTrip(double pCurrentShipmentWeight, int pAmountShipmentLoads, boolean pDangerousCargoPresence, boolean pPerishableCargoPresence) {
		currentTrip = new Trip(pCurrentShipmentWeight, pAmountShipmentLoads, pDangerousCargoPresence, pPerishableCargoPresence);
	}
	public void registerTrip() {
		pastTrips.add(currentTrip);
	}
	public ArrayList<Trip> getPastTrips() {
		return pastTrips;
	}
	
}
