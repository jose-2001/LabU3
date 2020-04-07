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
/**
 * Name: Load<br>
 * This is the constructor method fo the class Load<br> 
 * @param pBoxAmount an int, not negative<br>
 * @param pWeightPerBox a double, not negative<br>
 * @param pCargoType a char, must be either 'N', 'P'  or 'D'<br>
 */
public Load(int pBoxAmount, double pWeightPerBox, char pCargoType) {

	boxAmount=pBoxAmount;
	weightPerBox=pWeightPerBox;
	cargoType=pCargoType;
}
/**
 * Name: getBoxAmount<br>
 * This method returns the amount of boxes the Load is comprised of<br>
 * @return an int<br>
 */
public int getBoxAmount() {
	return boxAmount;
}
/**
 * Name: setBoxAmount<br>
 * This method sets the amount of boxes the Load is comprised of<br>
 * @param pboxAmount an int, positive.<br>
 */
public void setBoxAmount(int pboxAmount) {
	boxAmount = pboxAmount;
}
/**
 * Name: getWeightPerBox<br>
 * This method returns what each box of the Load weighs in grams<br>
 * @return a double<br>
 */
public double getWeightPerBox() {
	return weightPerBox;
}
/**
 * Name: setWeightPerBox<br>
 * This method sets what each box of the Load weighs in grams<br>
 * @param pweightPerBox a double, positive<br>
 */
public void setWeightPerBox(double pweightPerBox) {
	weightPerBox = pweightPerBox;
}
/**
 * Name: getCargoType<br>
 * This method returns the cargo type of the Load<br>
 * @return a char, either 'N', 'P' or 'D'<br>
 */
public char getCargoType() {
	return cargoType;
}
/**
 * Name: setCargoType<br>
 * This method sets the cargo type of the Load<br>
 * @param pcargoType a char, either 'N', 'P' or 'D'
 */
public void setCargoType(char pcargoType) {
	cargoType = pcargoType;
}
/**
 * Name: getOwner<br>
 * This method returns the client who owns the load<br>
 * @return a Client<br>
 */
public Client getOwner() {
	return owner;
}
/**
 * Name: setOwner<br>
 * This method sets the owner of the Load<br>
 * @param powner a Client, not null<br>
 */
public void setOwner(Client powner) {
	owner = powner;
}
/**
 * Name: getLoadWeightInKg
 * This method calculates and returns the weight of the Load in kilograms<br>
 * @return a double<br>
 */
public double getLoadWeightInKg() {
	double weight= (boxAmount*weightPerBox/1000);
	return weight;
}
/**
 * Name:getLoadPrice
 * This method calculates and returns the price of a Load base on its weight in kilograms and the type of cargo<br>
 * @return a double<bR>
 */
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
	