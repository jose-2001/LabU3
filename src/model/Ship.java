package model;

public class Ship {
	
//Attributes
	
	private String name;
	private double maxCapacity;
	
//Relations
	
	private Trip currentTrip;
	
//methods
	
	public Ship(String pName, double pMaxCapacity) {
		name = pName;
		maxCapacity = pMaxCapacity;
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
	public void setCurrentTrip(Trip pCurrentTrip) {
		currentTrip = pCurrentTrip;
	}
	
	
	
}
