package model;

public class Ship {
// -----------
//Atributes
//----------
	private String name;
	private double maxCapacity;
	
	
//-----------
//methods
//-----------
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
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
