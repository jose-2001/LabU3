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
		System.out.println("Type 1 to add a new Load");
		decision=lector.nextInt();
		switch(decision) {
		case 1:
			objMain.addLoad();
		}
	}

}


public void createCompany() {
	System.out.println("Type the name of the company");
	String name=lector.nextLine();
	System.out.println("How many clients does the company have?");
	int clientAmount=lector.nextInt();
	lector.nextLine();
	mainCompany=new Company (name, clientAmount);
}
public void fillClientList() {
	for(int i=0; i<mainCompany.getClientList().length;i++) 
	{
		if(addClient()==0) 
		{
			System.out.println("Error: Client already exists, add a different client");
			i--;
		}
		if(addClient()==1) 
		{
			System.out.println("Client added successfully");
		}
	}	
}
public int addClient() {
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
	message=mainCompany.addClient(pname, pnrm, pregExpedDate, 'D', 0, 0);
	return message;
}

public void setShip() {
	System.out.println("What is the name of the ship?");
	String shipName = lector.nextLine();
	mainCompany.setOwned(shipName);
}
public void startTrip() {
	mainCompany.startTrip();
}
public String addLoad() {
	String message ="";
	System.out.println("Which client owns this new Load?");
	for (int i=0;i<5;i++) {
	System.out.println("Type "+ (i+1)+ " if it belongs to " + mainCompany.getClientName(i));
	}
	int pOwner = lector.nextInt();
	System.out.println("How many boxes does this Load have?");
	int pBoxAmount = lector.nextInt();
	System.out.println("How much does each box weigh?");
	double pWeightPerBox = lector.nextDouble();
	lector.hasNextLine();
	System.out.println("What type of cargo is this Load?");
	System.out.println("Type 'N' if it is a Non-Perishable Load");
	System.out.println("Type 'P' if it is a Perishable Load");
	System.out.println("Type 'D' if it is a Dangerous Load");
	char pCargoType = lector.nextLine().charAt(0);
	message=mainCompany.addLoad(pOwner, pBoxAmount, pWeightPerBox, pCargoType);
	return message;
}
}