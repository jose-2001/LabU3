package model;
import java.util.ArrayList;
public class Trip {
	
//Attributes
	
private double currentShipmentWeight;	
private int amountShipmentLoads;
private boolean sendable;
private boolean dangerousCargoPresence;
private boolean perishableCargoPresence;	
private boolean cargoTypeIncompatibility;

//Relations

private ArrayList<Load> currentCargo;

//Methods
	
public Trip(double pCurrentShipmentWeight, int pAmountShipmentLoads,  boolean pDangerousCargoPresence, boolean pPerishableCargoPresence)	
{
	currentShipmentWeight=pCurrentShipmentWeight;
	amountShipmentLoads=pAmountShipmentLoads;
	dangerousCargoPresence=pDangerousCargoPresence;
	perishableCargoPresence=pPerishableCargoPresence;
	sendable=checkSendable();
	cargoTypeIncompatibility = checkCargoTypeIncompatibility();
	currentCargo= new ArrayList<Load>();
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
public boolean getCargoTypeIncompatibility()  {
	return cargoTypeIncompatibility;
}

public ArrayList<Load> getCurrentCargo() {
	return currentCargo;
}

public void unloadShip () {
	currentShipmentWeight = 0;
	amountShipmentLoads = 0;
	dangerousCargoPresence = false;
	perishableCargoPresence = false;
	cargoTypeIncompatibility = false;
	sendable = false;
}
public boolean 	checkCargoTypeIncompatibility() {
	if (perishableCargoPresence== true && dangerousCargoPresence == true)
		{return true;}
	else {return false;}
}
public boolean checkSendable() {
	checkCargoTypeIncompatibility();
	if(cargoTypeIncompatibility == true)
		{return false;}
	if(currentShipmentWeight>12000 ||amountShipmentLoads>=2 )
		{return true;}
	else {return false;}
}

public Load getSpecLoad(int position) {
	Load specLoad = currentCargo.get(position);
	return specLoad;
}

public void addLoad(Load latestLoad) {
	currentCargo.add(latestLoad);
}
public int nextFreePosition() {
	int position=-1;
	boolean found= false;
	for(int i=0; i<currentCargo.size() && !found;i++)
	 {if (currentCargo.get(i)==null)
	 	{position= i;
	 	found=true;}
	}
	return position;
}
public void eraseLoad(int position) {
	currentCargo.remove(position);
}

}
