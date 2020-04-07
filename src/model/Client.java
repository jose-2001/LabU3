package model;

public class Client {


//Constants
	public final static char NORMAL = 'D';
	public final static char SILVER = 'C';
	public final static char GOLD = 'B';
	public final static char PLATINUM = 'A';

//Attributes
	private String name;
	private String nrm;
	private String regExpedDate;
	private char clientType;
	private double kgTransported;
	private double overallPayment;
	private double currentTripBill;
	private double currentTripCargoWeight;
//Methods
/**
 * Name: Client<br>
 * The constructor method for the class Client<br>
 * @param pname a String, not null, not empty<br>
 * @param pnrm a String, not null, not empty<br>
 * @param pregExpedDate a String, not null, not empty<br>
 * @param pclientType a char, must be either 'A', 'B', 'C' or 'D'<br>
 * @param pkgTransported a double, not negative<br>
 * @param poverallPayment a double, not negative<br>
 */
	public Client(String pname, String pnrm, String pregExpedDate, char pclientType, double pkgTransported, double poverallPayment) {
		name = pname;
		nrm = pnrm;
		regExpedDate = pregExpedDate;
		clientType = pclientType;
		kgTransported = pkgTransported;
		overallPayment = poverallPayment;
		currentTripBill = 0;
		currentTripCargoWeight = 0;

	}
	/**
	 * Name: getName<br>
	 * Returns the name of the Client<br>
	 * @return a String<br>
	 */
	public String getName() {
		return name;
	}
	/**
	 * Name: setName<br>
	 * This method sets a Client's name<br>
	 * @param pname a String, not empty, not null<br>
	 */
	public void setName(String pname) {
		name = pname;
	}
	/**
	 * Name: getNrm<br>
	 * This method returns the client's commercial registration number<br>
	 * @return a String<br>
	 */
	public String getNrm() {
		return nrm;
	}
	/**
	 * Name: setNrm<br>
	 * This method sets the client's commercial registration number<br>
	 * @param pnrm a String, not empty, not null<br>
	 */
	public void setNrm(String pnrm) {
		nrm = pnrm;
	}
	/**
	 * Name: getRegExpedDate<br>
	 * This method returns the date of the expedition of the client's commercial registration<br>
	 * @return a String
	 */
	public String getRegExpedDate() {
		return regExpedDate;
	}
	/**
	 * Name: setRegExpedDate<br>
	 * This method sets the date of the expedition of the client's commercial registration<br>
	 * @param pregExpedDate a String, not empty, not null<br>
	 */
	public void setRegExpedDate(String pregExpedDate) {
		regExpedDate = pregExpedDate;
	}
	/**
	 * Name:getClientType<br>
	 * This method the client's type<br>
	 * @return a char, 'D', 'C', 'B' or 'A'<br>
	 */
	public char getClientType() {
		return clientType;
	}
	/**
	 * Name: setClientType<br>
	 * This method sets the client's type<br>
	 * @param pclientType a char, must be either 'A', 'B', 'C' or 'D'<br>
	 */
	public void setClientType(char pclientType) {
		clientType = pclientType;
	}
	/**
	 * Name: getKgTransported<br>
	 * This method the amount of kilograms transported by the client with the company overall<br>
	 * @return a double
	 */
	public double getKgTransported() {
		return kgTransported;
	}
	/**
	 * Name: setKgTransported<br>
	 * This method sets the amount of kilograms transported by the client with the company overall<br>
	 * @param pkgTransported a double, not negative<br>
	 */
	public void setKgTransported(double pkgTransported) {
		kgTransported = pkgTransported;
	}
	/**
	 * Name: getOverallPayment<br>
	 * This method returns the client's overall payment to the company<br>
	 * @return a double<br>
	 */
	public double getOverallPayment() {
		return overallPayment;
	}
	/**
	 * Name:setOverallPayment<br>
	 * This method sets the client's overall payment to the company<br>
	 * @param poverallPayment a double, not negative<br>
	 */
	public void setOverallPayment(double poverallPayment) {
		overallPayment = poverallPayment;
	}
	/**
	 * Name: getCurrentTripBill<br>
	 * This method returns what the client has to pay for the cargo they are transporting on the current trip<br>
	 * @return a double<br>
	 */
	public double getCurrentTripBill() {
		return currentTripBill;
	}
	/**
	 * Name: setCurrentTripBill<br>
	 * This method sets what the client has to pay for the cargo they are transporting on the current trip<br>
	 * @param pcurrentTripBill a double, not negative
	 */
	public void setCurrentTripBill(double pcurrentTripBill) {
		currentTripBill = pcurrentTripBill;
	}
	/**
	 * Name: getCurrentTripCargoWeight<br>
	 * This method returns the amount of kilograms being transported for the client in the current trip<br>
	 * @return a double
	 */
	public double getCurrentTripCargoWeight() {
		return currentTripCargoWeight;
	}
	/**
	 * Name: setCurrentTripCargoWeight<br>
	 * This method sets the amount of kilograms being transported for the client in the current trip<br>
	 * @param pcurrentTripCargoWeight a double, not negative
	 */
	public void setCurrentTripCargoWeight(double pcurrentTripCargoWeight) {
		currentTripCargoWeight = pcurrentTripCargoWeight;
	}	
	/**
	 * Name: getClientDiscount<br>
	 * This method returns the discount (in decimals) a client has on a specific Load depending on the Load's and the Client's type<br>
	 * @param thisLoad a Load, not null<br>
	 * @return a double<br>
	 */
	public double getClientDiscount(Load thisLoad) {
	double discount=0;
	if(getClientType()=='D') {
		discount=0;
	}
	if(getClientType()=='C'& thisLoad.getCargoType()=='P') {
		discount=0.015;
	}
	if(getClientType()=='B'& (thisLoad.getCargoType()=='P'|thisLoad.getCargoType()=='N')) {
		discount=0.03;
	}
	if(getClientType()=='A') {
		discount=0.05;
	}
	return discount;
	}
	/**
	 * Name: updateClientType <br>
	 * This method returns a message if the client now qualifies to be a higher type of client, the message says the name of the client and their new type<br>
	 * @return a String<br>
	 */
public String updateClientType () {
	String message="";
	String ms2="";
	boolean update=false;
	if(getKgTransported()>35000 && getClientType()!='C') {
		setClientType('C');	
		ms2="SILVER";
		update=true;
		}
	if((getKgTransported()>55000 || getOverallPayment()>=2000000) && getClientType()!='B') {
		setClientType('B');
		ms2="GOLD";
		update=true;
		}
	if(getOverallPayment()>=5000000 && getClientType()!='A') {
		setClientType('A');
		ms2="PLATINUM";
		update=true;
		}
	if(update==true) {message=("The client " + getName() + " has been updated to "+ ms2+".\n");}
	return message;
}
	
}
