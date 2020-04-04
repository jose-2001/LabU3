package ui;
import java.util.Scanner;
import model.Company;
public class Main {
//Attributes
	
	private Company mainCompany;
			
// global variables
		
	public static Scanner lector;
	
//Methods
	
public Main() {
	createCompany();
}

public static void main(String[] args) {
	lector= new Scanner(System.in);
	Main objMain=new Main();
	int decision =0;
	objMain.fillClientList();
	//clientList is filled
	objMain.setShip();
	objMain.startTrip();
	
	boolean menu=true;
	while(menu)
	{
		System.out.println("Menu");
		System.out.println("Type 1 to add a new Load");
		System.out.println("Type 2 to set sail (get shipment status)");
		System.out.println("Type 3 to unload the ship");
		System.out.println("Type 4 to get a specific trip's info");
		System.out.println("Type 5 to terminate the program");
		decision=lector.nextInt();
		switch(decision) {
		case 1:
			System.out.println(objMain.addLoad());
			break;
		case 2:
			objMain.setSail();
			break;
		case 3: 
			objMain.unloadShip();
			break;
		case 4:
			objMain.getTrip();
			break;
		case 5:
			System.out.println("Goodbye!");
			menu=false;
			break;

		}
	}
}

/**
 * Name: createCompany<br>
 * This method creates an object of the class Company, asks for its name and number of clients<br>
 */
public void createCompany() {
	System.out.println("Type the name of the company");
	String name=lector.nextLine();
	System.out.println("How many clients does the company have?");
	int clientAmount=lector.nextInt();
	lector.nextLine();
	mainCompany=new Company (name, clientAmount);
}
/**
 * Name: fillClientList<br>
 * This method fills the client list of the mainCompany<br>
 */
public void fillClientList() {
	int dec=0;
	for(int i=0; i<mainCompany.getClientList().length;i++) 
	{
		dec=addClient();
		if(dec==0) 
		{
			System.out.println("Error: Client already exists, add a different client");
			i--;
		}
		if(dec==1) 
		{
			System.out.println("Client "+ (i+1) +" added successfully");
		}
	}	
}
/**
 * Name:addClient<br>
 * This method asks for a Client's information depending on if it is a new client or an old client<br>
 * <b> Post </b>: if the client already existed in the client list, it is not saved, if the client did not exist, it is saved<br>
 * @return returns an int, 0 if the client already exists, 1 if it does not <br>
 */
public int addClient() {
	System.out.println("Please fill in the client information");
	System.out.println("Is it an old client? (Y/N)");
	char old =lector.nextLine().charAt(0);
	System.out.println("Type the name of the client");
	String pname=lector.nextLine();
	System.out.println("Type the client's commercial registration number");
	String pnrm=lector.nextLine();
	System.out.println("Type the date of the expedition of the client's commercial registration");
	String pregExpedDate=lector.nextLine();
	int message=0;
	if(old=='Y' | old=='y') 
	{
		System.out.println("Type the client's Client type");
		System.out.println("Type D if the client's Client Type is Normal");
		System.out.println("Type C if the client's Client Type is Silver");
		System.out.println("Type B if the client's Client Type is Gold");
		System.out.println("Type A if the client's Client Type is Platinum");
		char pclientType=lector.nextLine().toUpperCase().charAt(0);
		System.out.println("Type the amount of kilograms the client has transported overall");
		double pkgTransported =lector.nextDouble();
		System.out.println("Type the client's overall payment");
		double poverallPayment =lector.nextDouble();
		lector.nextLine();
		message=mainCompany.addClient(pname, pnrm, pregExpedDate, pclientType, pkgTransported, poverallPayment);
	}
	else{message=mainCompany.addClient(pname, pnrm, pregExpedDate, 'D', 0, 0);}
	return message;
}
/**
 * Name: setShip <br>
 * This method creates the ship that the company uses, asks for its name<br>
 */
public void setShip() {
	System.out.println("What is the name of the ship?");
	String shipName = lector.nextLine();
	mainCompany.setOwned(shipName);
}
/**
 * Name: startTrip<br>
 * This method initializes the ship's trip<br>
 */
public void startTrip() {
	mainCompany.startTrip();
}
/**
 * Name: addLoad
 * This method asks for a new load's info, if the load can be added it adds it to the company's ship's trip's cargo
 * @return it returns a string saying if the load was added successfully and if it was not, why it was not added <br>
 */
public String addLoad() {
	String message ="";
	System.out.println("Which client owns this new Load?");
	for (int i=0;i<mainCompany.getClientList().length;i++) {
	System.out.println("Type "+ (i+1)+ " if it belongs to " + mainCompany.getClientName(i));
	}
	int pOwner = lector.nextInt()-1;
	System.out.println("How many boxes does this Load have?");
	int pBoxAmount = lector.nextInt();
	System.out.println("How much does each box weigh?");
	double pWeightPerBox = lector.nextDouble();
	lector.nextLine();
	System.out.println("What type of cargo is this Load?");
	System.out.println("Type 'N' if it is a Non-Perishable Load");
	System.out.println("Type 'P' if it is a Perishable Load");
	System.out.println("Type 'D' if it is a Dangerous Load");
	char pCargoType = lector.nextLine().toUpperCase().charAt(0);
	message=mainCompany.addLoad(pOwner, pBoxAmount, pWeightPerBox, pCargoType);
	return message;
}
/**
 * Name: setSail <br>
 * If the ship can sail this method returns the client's and the trip's cargo status, if not, only the trip's cargo status<br>
 */
public void setSail() {
	if(mainCompany.setSail()==true) {
		System.out.println("Sail set!");
		System.out.println("You are currently shipping " + mainCompany.getOwned().getCurrentTrip().getAmountShipmentLoads()+
							" load(s), which weigh(s) a total of " + mainCompany.getOwned().getCurrentTrip().getCurrentShipmentWeight());
		for(int i=0; i<mainCompany.getClientList().length;i++) {
			System.out.println("The client " + mainCompany.getClientList()[i].getName() + " is carrying "+ mainCompany.getClientList()[i].getCurrentTripCargoWeight()+ " kilograms for a price of " + mainCompany.getClientList()[i].getCurrentTripBill());
		}
	}
	else { 
		System.out.println(" You cannot set sail because there aren't enough loads being shipped (2 loads minimum) or enough weight being shipped (12.000 kilgrams minimum)");
		System.out.println("Current amount of Loads: "+ mainCompany.getOwned().getCurrentTrip().getAmountShipmentLoads());
		System.out.println("Current weight being shipped: " + mainCompany.getOwned().getCurrentTrip().getCurrentShipmentWeight());
		}
}
/**
 * Name: unloadShip
 * This method registers the trip in the past trips log and unloads the ship<br>
 */
public void unloadShip() {
	mainCompany.getOwned().registerTrip();
	mainCompany.getOwned().getCurrentTrip().unloadShip();
	System.out.println("The ship has been unloaded! Ready for another trip");
	mainCompany.startTrip();
}
public String getTripInfo(int dec) {
	String message=mainCompany.getTripInfo(dec);
	return message;
}
public String getCurrentTripInfo() {
	String message=mainCompany.getCurrentTripInfo();
	return message;
}
public void getTrip() {
	int dec=0;
	if(mainCompany.getOwned().getPastTrips().size()!=0) {
		System.out.println("Which trip would you like to get the info from? There are " + mainCompany.getOwned().getPastTrips().size()+" trips logged.");
		dec= lector.nextInt();
		lector.nextLine();
		System.out.println(getTripInfo(dec));		
	}
	else {System.out.println("There are no trips logged yet, this is the current trip's info");
	System.out.println(getCurrentTripInfo());
	}	
}

}