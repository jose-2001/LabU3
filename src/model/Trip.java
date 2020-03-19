package model;

public class Trip {
//----------
//Attributes
//----------
private double currentShipmentWeight;	
private int amountShipmentLoads;
private boolean sendable;
private boolean dangerousCargoPresence;
private boolean perishableCargoPresence;	
private boolean cargoTypeIncompatibility;

private Ship boat;
private NewLoad latestLoad;

//----------
//methods
//----------
	
public Trip(double pCurrentShipmentWeight, int pAmountShipmentLoads, boolean pSendable, boolean pDangerousCargoPresence, boolean pPerishableCargoPresence)	
{
	setCurrentShipmentWeight(pCurrentShipmentWeight);
	setAmountShipmentLoads(pAmountShipmentLoads);
	setSendable(pSendable);
	setDangerousCargoPresence(pDangerousCargoPresence);
	setPerishableCargoPresence(pPerishableCargoPresence);
	cargoTypeIncompatibility = checkCargoTypeIncompatibility();
}

public double getCurrentShipmentWeight() {
	return currentShipmentWeight;
}

public void setCurrentShipmentWeight(double pCurrentShipmentWeight) {
	currentShipmentWeight = pCurrentShipmentWeight;
}

public int getAmountShipmentLoads() {
	return amountShipmentLoads;
}

public void setAmountShipmentLoads(int pAmountShipmentLoads) {
	amountShipmentLoads = pAmountShipmentLoads;
}

public boolean getSendable() {
	return sendable;
}

public void setSendable(boolean pSendable) {
	sendable = pSendable;
}

public boolean getDangerousCargoPresence() {
	return dangerousCargoPresence;
}

public void setDangerousCargoPresence(boolean pDangerousCargoPresence) {
	dangerousCargoPresence = pDangerousCargoPresence;
}

public boolean getPerishableCargoPresence() {
	return perishableCargoPresence;
}

public void setPerishableCargoPresence(boolean pPerishableCargoPresence) {
	perishableCargoPresence = pPerishableCargoPresence;
}
public boolean 	checkCargoTypeIncompatibility() {
	if (perishableCargoPresence== true && dangerousCargoPresence == true)
		{return true;}
	else {return false;}
}
public boolean getCargoTypeIncompatibility()  {
	return cargoTypeIncompatibility;
}
public void unloadShip () {
	currentShipmentWeight = 0;
	amountShipmentLoads = 0;
	dangerousCargoPresence = false;
	perishableCargoPresence = false;
	cargoTypeIncompatibility = false;
	sendable = false;
}
public boolean checkSendable () {
	checkCargoTypeIncompatibility();
	if(cargoTypeIncompatibility = true)
		{return false;}
	if(currentShipmentWeight>12000)
		{return true;}
	if (amountShipmentLoads>=2)
		{return true;}
	else {return false;}
}

public Ship getBoat() {
	return boat;
}

public void setBoat(Ship pboat) {
	boat = pboat;
}

public NewLoad getLatestLoad() {
	return latestLoad;
}

public void setLatestLoad(NewLoad platestLoad) {
	latestLoad = platestLoad;
}
}
