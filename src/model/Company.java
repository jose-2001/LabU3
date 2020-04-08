package model;

public class Company {

//Attributes
	private String name;
//Relations
	private Ship owned;
	private Client[] clientList;
	
//Methods
	public Company(String pName,int clientAmount) {
		name = pName;
		clientList= new Client[clientAmount];
	}
	/**
	 * name: addClient <br>
	 * This method adds a client in the next available location in the clientList array if the client does not already exist <br>
	 * @param pname is a String, != null <br>
	 * @param pnrm is a String, != null <br>
	 * @param pregExpedDate is a String, != null <br>
	 * @param pclientType is a single char<br>
	 * @param pkgTransported is a positive real number, type double <br>
	 * @param poverallPayment is a positive real number, type double <br>
	 * @return returns a 1 if the client is added successfully, if the client already existed it returns a 0 <br>
	 */
	public int addClient(String pname, String pnrm, String pregExpedDate, char pclientType, double pkgTransported, double poverallPayment) {
		int message=0;
		Client toAdd= new Client(pname, pnrm, pregExpedDate, pclientType, pkgTransported, poverallPayment);
		if(searchClient(toAdd)== false)
		{
		clientList[nextFreePosition()]= toAdd;
		message=1;
		}
		else {message=0;}
		return message;
	}
	/**
	 * Name: searchClient <br>
	 * This method looks for a client in the client list and if it exists, it returns true, if it does not, it returns false<br>
	 * @param lookFor a Client, not null<bR>
	 * @return a boolean<br>
	 */
	public boolean searchClient(Client lookFor) {
		boolean exists = false;
		for(int i=0; i<clientList.length; i++)
			{if(clientList[i]!=null)
				{
				if(clientList[i].getName().equals(lookFor.getName()))
				{exists = true;}
				}
			}	
		return exists;
	}
	/**
	 * Name: getName<br>
	 * This method returns the company's name<br>
	 * @return a String<br>
	 */
	public String getName(){
		return name;
	}	
	/**
	 * Name: setName<br>
	 * This method sets the company's name<br> 
	 * @param pName a String, not null<br>
	 */
	public void setName(String pName) {
		name = pName;
	}
	/**
	 * Name: getOwned<br>
	 * This method returns the ship owned by the company<br>
	 * @return a ship<br>
	 */
	public Ship getOwned() {
		return owned;
	}
	/**
	 * Name: setOwned<br>
	 * This method creates a new Ship and sets it as the ship owned by the company<br>
	 * @param shipName a String, not null<br>
	 */
	public void setOwned(String shipName) {
		owned = new Ship(shipName);
	}
	/**
	 * Name: getClientList<br>
	 * This method returns the client list of the company<br>
	 * @return an array of clients
	 */
	public Client[] getClientList() {
		return clientList;
	}
	/**
	 * Name:getClientName
	 * This method returns the name of the client in the given index in the on the client list<br>
	 * @param position an int, not negative, not bigger than the max index for the clientList
	 * @return a String
	 */
	public String getClientName(int position) {
		return clientList[position].getName();
	}
	/**
	 * Name: nextFreePosition<br>
	 * This method returns the index of the next free position in the clientList array<br>
	 * @return an int <br>
	 */
	public int nextFreePosition() {
		int position=-1;
		boolean found= false;
		for(int i=0; i<clientList.length && !found;i++)
		 {if (clientList[i]==null)
		 	{position= i;
		 	found=true;}
		}
		return position;
	}
	/**
	 * Name: startTrip<br>
	 * This method creates a new trip and sets it as the ship's current trip<br>
	 */
	public void startTrip() {
		//pCurrentShipmentWeight, pAmountShipmentLoads, pSendable, pDangerousCargoPresence, pPerishableCargoPresence
		owned.setCurrentTrip(0,0,false,false);
	}
	/**
	 * Name addLaod<br>
	 * This method creates a Load with the parameters given, <br>
	 * checks if adding the Load would exceed the ship's maximum capacity, <br>
	 * or if it cannot be added due to cargo type incompatibility; <br>
	 * if the load can be added it updates the the trip's and the client's information on weight and price of the current trip<br>
	 * it returns a message that the Load has been successfully added, <br>
	 * and if because of this new load a client can be upgraded to a better type, <br>
	 * it does so and also notifies by adding it to the message returned, <br>
	 * if it cannot be added, it does not add it and adds to the message why it was not added<br>
	 * @param pOwnerIndex an int, not negative, not bigger than the maximum index possible for the ClientList array<br>
	 * @param pBoxAmount an int, positive<br>
	 * @param pWeightPerBox a double, positive<br>
	 * @param pCargoType a char, must be either 'N', 'P' or 'D'<br>
	 * @return a String<br>
	 */
	//Check everything before actually adding the load
	public String addLoad(int pOwnerIndex,int pBoxAmount,double pWeightPerBox,char pCargoType ) {
		String message=""; boolean error = false;
		Load toAdd = new Load(pBoxAmount, pWeightPerBox, pCargoType);
		Client pOwner= getClientList()[pOwnerIndex];
		toAdd.setOwner(pOwner);
		if(toAdd.getLoadWeightInKg()+owned.getCurrentTrip().getCurrentShipmentWeight()>owned.getMaxCapacity()) {
			message="Error, adding this Load would surpass the ship's maximum capacity";
			error=true;
		}
		if (toAdd.getCargoType()=='D'& owned.getCurrentTrip().getPerishableCargoPresence()) {
			message="Error, this is a Dangerous cargo and the ship already has Perishable cargo on board";
			error=true;
		}
		if (toAdd.getCargoType()=='P'& owned.getCurrentTrip().getDangerousCargoPresence()) {
			message="Error, this is a Perishable cargo and the ship already has Dangerous cargo ob board";
			error=true;
		}
		if(!error) {
			toAdd.getOwner().setCurrentTripCargoWeight(toAdd.getOwner().getCurrentTripCargoWeight()+toAdd.getLoadWeightInKg());
			toAdd.getOwner().setKgTransported(toAdd.getOwner().getKgTransported()+ toAdd.getLoadWeightInKg() );
			double ownerPays = toAdd.getLoadPrice()- toAdd.getLoadPrice()*toAdd.getOwner().getClientDiscount(toAdd);
			toAdd.getOwner().setCurrentTripBill(toAdd.getOwner().getCurrentTripBill()+ownerPays);
			toAdd.getOwner().setOverallPayment(toAdd.getOwner().getOverallPayment()+ownerPays);
			owned.getCurrentTrip().setCurrentShipmentWeight(owned.getCurrentTrip().getCurrentShipmentWeight()+toAdd.getLoadWeightInKg());
			if(toAdd.getCargoType()=='P') {
				owned.getCurrentTrip().setPerishableCargoPresence(true);
			}
			if(toAdd.getCargoType()=='D') {
				owned.getCurrentTrip().setDangerousCargoPresence(true);
			}
			owned.getCurrentTrip().setAmountShipmentLoads(owned.getCurrentTrip().getAmountShipmentLoads()+1);
			owned.getCurrentTrip().getCurrentCargo().add(toAdd);
			message="Load added succesfully\n";
			for(int i=0; i<getClientList().length; i++) {
				message+=clientList[i].updateClientType();
			}
		}
		
		return message;
	}
	/**
	 * Name: setSail <br>
	 * This method returns true if the ship can set sail, false if it cannot<br>
	 * @return a boolean<br>
	 */
	public boolean setSail() {
		return owned.getCurrentTrip().checkSendable();
	}
	/**
	 * Name: getTripInfo<br>
	 * This method returns a String carrying a past trip's information<br>
	 * @param dec an int, not negative, not bigger than the index of the last trip logged in the pastTrips ArrayList<br>
	 * @return a String<br>
	 */
	public String getTripInfo(int dec) {
		String message=("that trip transported "+ getOwned().getPastTrips().get(dec).getCurrentShipmentWeight()+" kilograms in " + getOwned().getPastTrips().get(dec).getAmountShipmentLoads()+ "loads.");
		if(getOwned().getPastTrips().get(dec).getDangerousCargoPresence()) {
		message+="and it carried dangerous cargo";	
		}
		if(getOwned().getPastTrips().get(dec).getPerishableCargoPresence()) {
			message+="and it carried perishable cargo";	
			}
		
		return message;
	}
	/**
	 * Name: getCurrentTripInfo<br>
	 * This method returns a String with the information of the current trip<br>
	 * @return a String <br>
	 */
	public String getCurrentTripInfo() {
		String message=("You are currently shipping " + getOwned().getCurrentTrip().getAmountShipmentLoads()+
				" load(s), which weigh(s) a total of " + getOwned().getCurrentTrip().getCurrentShipmentWeight());
		return message;
	}
	/**
	 * Name: getLoadInfo<br>
	 * This method returns a String with the information a Load from the current trip<br>
	 * @param dec an int, not negative, not bigger than the index of the last load added in the currentCargo ArrayList<br>
	 * @return a String<br>
	 */
	public String getLoadInfo(int dec) {
		String message="That load is comprised of "+ getOwned().getCurrentTrip().getCurrentCargo().get(dec-1).getBoxAmount() +
				" boxes, each box weighs "+getOwned().getCurrentTrip().getCurrentCargo().get(dec-1).getWeightPerBox()+
				" grams, in total they all weigh "+getOwned().getCurrentTrip().getCurrentCargo().get(dec-1).getLoadWeightInKg()+
				" kilograms. This load belong to "+getOwned().getCurrentTrip().getCurrentCargo().get(dec-1).getOwner().getName()+ 
				" and it's a ";
		if(getOwned().getCurrentTrip().getCurrentCargo().get(dec-1).getCargoType()=='D') {
			message+="dangerous type of load.";
		}
		if(getOwned().getCurrentTrip().getCurrentCargo().get(dec-1).getCargoType()=='P') {
			message+="perishable type of load.";
		}
		if(getOwned().getCurrentTrip().getCurrentCargo().get(dec-1).getCargoType()=='N') {
			message+="non-perishable type of load.";
		}
		return message;
	}
	/**
	 * Name: getClientInfo<br>
	 * This method returns a String with the information of a client<br>
	 * @param dec an int, not negative, not bigger than the index of the last Client in the clientList array<br>
	 * @return a String<br>
	 */
	public String getClientInfo(int dec) {
		String message=" Client: "+ getClientList()[dec].getName()+ "\n"+
						"Commercial registration number: "+ getClientList()[dec].getNrm()+"\n"+
						"Commercial registration expedition date: "+ getClientList()[dec].getRegExpedDate()+"\n"+
						"Client type: "+ getClientList()[dec].getClientType()+"\n"+
						"Overall payment: "+ getClientList()[dec].getOverallPayment()+"\n"+
						"Kilograms transported (overall): "+ getClientList()[dec].getKgTransported()+"\n"+
						"Current trip bill: "+ getClientList()[dec].getCurrentTripBill()+"\n"+
						"Kilograms transported (this trip): "+ getClientList()[dec].getCurrentTripCargoWeight()+"\n";
		return message;
	}
	public void unloadShip() {
		getOwned().registerTrip();
		getOwned().getCurrentTrip().unloadShip();
		for(int i=0; i<clientList.length;i++) {
			clientList[i].setCurrentTripCargoWeight(0);
			clientList[i].setCurrentTripBill(0);
		}
		startTrip();
	}
}
