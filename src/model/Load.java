package model;

public class Load {

//Constants
	
public final static char DANGEROUS = 'D';
public final static char PERISHABLE = 'P';
public final static char NONPERISHABLE = 'N';
public final static double DCARGOPRICE =390000; 
public final static double PCARGOPRICE =250000;
public final static double NCARGOPRICE =80000;

//Attributes
	
private int boxAmount;
private double weightPerBox;
private char cargoType;

//Relations

private Client owner;

//Methods

public Load(int pBoxAmount, double pWeightPerBox, char pCargoType) {

	boxAmount=pBoxAmount;
	weightPerBox=pWeightPerBox;
	cargoType=pCargoType;
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

public double getLoadWeightInKg() {
	double weight= (boxAmount*weightPerBox/1000);
	return weight;
}
public double getLoadPrice() {
	double price=0;
	if(cargoType=='D')
	{price=getLoadWeightInKg()*DCARGOPRICE;}
	if(cargoType=='P')
	{price=getLoadWeightInKg()*PCARGOPRICE;}
	if(cargoType=='N')
	{price=getLoadWeightInKg()*NCARGOPRICE;}
	return price;
}

}
	

