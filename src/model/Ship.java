package model;

public class Ship {
	
	
//Constants 
	public static final double MAXCAPACITY= 28000;
//Attributes
	
	private String name;
	private double maxCapacity;
	
//Relations
	
	private Trip currentTrip;
	
//methods
	
	public Ship(String pName) {
		name = pName;
		maxCapacity = MAXCAPACITY;
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
	
	
	
}
