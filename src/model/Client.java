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
	public String getName() {
		return name;
	}
	public void setName(String pname) {
		name = pname;
	}
	public String getNrm() {
		return nrm;
	}
	public void setNrm(String pnrm) {
		nrm = pnrm;
	}
	public String getRegExpedDate() {
		return regExpedDate;
	}
	public void setRegExpedDate(String pregExpedDate) {
		regExpedDate = pregExpedDate;
	}
	public char getClientType() {
		return clientType;
	}
	public void setClientType(char pclientType) {
		clientType = pclientType;
	}
	public double getKgTransported() {
		return kgTransported;
	}
	public void setKgTransported(double pkgTransported) {
		kgTransported = pkgTransported;
	}
	public double getOverallPayment() {
		return overallPayment;
	}
	public void setOverallPayment(double poverallPayment) {
		overallPayment = poverallPayment;
	}
	public double getCurrentTripBill() {
		return currentTripBill;
	}
	public void setCurrentTripBill(double pcurrentTripBill) {
		currentTripBill = pcurrentTripBill;
	}
	public double getCurrentTripCargoWeight() {
		return currentTripCargoWeight;
	}
	public void setCurrentTripCargoWeight(double pcurrentTripCargoWeight) {
		currentTripCargoWeight = pcurrentTripCargoWeight;
	}	
	
	
	
	
	
	
	
	
	
}
