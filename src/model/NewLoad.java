package model;

public class NewLoad {

//----------
//Constants
//----------
	
public final static char DANGEROUS = 'D';
public final static char PERISHABLE = 'P';
public final static char NONPERISHABLE = 'N';

//----------
//Attributes
//----------
	
private int boxAmount;
private double weightPerBox;
private char cargoType;

private Client owner;

//----------
//Methods
//----------

public NewLoad(int pBoxAmount, double pWeightPerBox, char pCargoType) {

	setBoxAmount(pBoxAmount);
	setWeightPerBox(pWeightPerBox);
	setCargoType(pCargoType);
}

public int getBoxAmount() {
	return boxAmount;
}

public void setBoxAmount(int pboxAmount) {
	boxAmount = pboxAmount;
}

public double getWeightPerBox() {
	return weightPerBox;
}

public void setWeightPerBox(double pweightPerBox) {
	weightPerBox = pweightPerBox;
}

public char getCargoType() {
	return cargoType;
}

public void setCargoType(char pcargoType) {
	cargoType = pcargoType;
}

public Client getOwner() {
	return owner;
}

public void setOwner(Client powner) {
	owner = powner;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
