package model;
import java.util.ArrayList;
public class Trip {
	
//Attributes
	
private double currentShipmentWeight;	
private int amountShipmentLoads;
private boolean sendable;
private boolean dangerousCargoPresence;
private boolean perishableCargoPresence;	


//Relations

private ArrayList<Load> currentCargo;

//Methods
	/**
	 * Name: Trip
	 * This method is the constructor for the class Trip<br>
	 * @param pCurrentShipmentWeight a double, not negative<br>
	 * @param pAmountShipmentLoads an integer, not negative<br>
	 * @param pDangerousCargoPresence a boolean.<br>
	 * @param pPerishableCargoPresence a boolean.<br>
	 */
public Trip(double pCurrentShipmentWeight, int pAmountShipmentLoads,  boolean pDangerousCargoPresence, boolean pPerishableCargoPresence)	
{
	currentShipmentWeight=pCurrentShipmentWeight;
	amountShipmentLoads=pAmountShipmentLoads;
	dangerousCargoPresence=pDangerousCargoPresence;
	perishableCargoPresence=pPerishableCargoPresence;
	sendable=checkSendable();
	currentCargo= new ArrayList<Load>();
}
/**
 * Name getCurrentShipmentWeight<br>
 * This method returns the trip's get Current Shipment Weight<br>
 * @return returns a double.<br>
 */
public double getCurrentShipmentWeight() {
	return currentShipmentWeight;
}
/**
 * Name: setCurrentShipmentWeight<br>
 * this method sets the Current Shipment Weight for the trip<br>
 * @param pCurrentShipmentWeight: must be a double.<br>
 */
public void setCurrentShipmentWeight(double pCurrentShipmentWeight) {
	currentShipmentWeight = pCurrentShipmentWeight;
}
/**
 * Name: <br>
 * This method returns the trip's Amount of Loads<br>
 * @return an int<br>
 */
public int getAmountShipmentLoads() {
	return amountShipmentLoads;
}
/**
 * Name: setAmountShipmentLoads<br>
 * This method sets the amount of loads for a trip<br>
 * @param pAmountShipmentLoads an int, not negative<br>
 */
public void setAmountShipmentLoads(int pAmountShipmentLoads) {
	amountShipmentLoads = pAmountShipmentLoads;
}
/**
 * Name: getSendable
 * This method returns true if the ship can set sail, false if it cannot<br>
 * @return a boolean<br>
 */
public boolean getSendable() {
	return sendable;
}
/**
 * Name: setSendable<br>
 * This method sets the value for Sendable(tells the ship if it can set sail or not)<br>
 * @param pSendable a boolean<br>
 */
public void setSendable(boolean pSendable) {
	sendable = pSendable;
}
/**
 * Name:getDangerousCargoPresence<br>
 * This method returns true if there is dangerous cargo aboard, false if not<br>
 * @return a boolean<br>
 */
public boolean getDangerousCargoPresence() {
	return dangerousCargoPresence;
}
/**
 * Name: setDangerousCargoPresence<br>
 * This method tells the ship if it has got dangerous cargo on board or not<br>
 * @param pDangerousCargoPresence a boolean<br>
 */
public void setDangerousCargoPresence(boolean pDangerousCargoPresence) {
	dangerousCargoPresence = pDangerousCargoPresence;
}
/**
 * Name:getPerishableCargoPresence<br>
 * This method returns true if there is perishable cargo aboard, false if not<br>
 * @return a boolean<br>
 */
public boolean getPerishableCargoPresence() {
	return perishableCargoPresence;
}
/**
 * Name: setPerishableCargoPresence<br>
 * This method tells the ship if it has got perishable cargo on board or not<br>
 * @param pPerishableCargoPresence a boolean<br>
 */
public void setPerishableCargoPresence(boolean pPerishableCargoPresence) {
	perishableCargoPresence = pPerishableCargoPresence;
}
/**
 * Name: getCurrentCargo<br>
 * This method returns an ArrayList of the current cargo the trip has<br>
 * @return an ArrayList
 */
public ArrayList<Load> getCurrentCargo() {
	return currentCargo;
}
/**
 * Name: unloadShip<br>
 * This method unloads the ship, turns the current shipment weight and amount of shipment loads to 0, and the presence of cargo to false<br>
 */
public void unloadShip () {
	currentShipmentWeight = 0;
	amountShipmentLoads = 0;
	dangerousCargoPresence = false;
	perishableCargoPresence = false;
	sendable = false;
}
/**
 * Name: checkSendable<br>
 * This method checks if the cargo weight is over 12000 kilograms or if the amount of loads carried is 2 or more, returns true if at least one of the conditions is met, false if not<br>
 * @return a boolean<br>
 */
public boolean checkSendable() {
	if(currentShipmentWeight>12000 ||amountShipmentLoads>=2 )
		{return true;}
	else {return false;}
}
/**
 * Name: getSpecLoad<br>
 * This method returns the specific load in the given postiion in the ArrayList of current Loads<br>
 * @param position an int, not negative, not greater than the max index of the loads stored in the boat<br>
 * @return the Load in that position of the ArrayList currentCargo<br>
 */
public Load getSpecLoad(int position) {
	Load specLoad = currentCargo.get(position);
	return specLoad;
}
/**
 * Name: addLoad<br>
 * This method adds a load to the ArrayList CurrentCargo of the current trip<br>
 * @param latestLoad a Load<br>
 */
public void addLoad(Load latestLoad) {
	currentCargo.add(latestLoad);
}

}
