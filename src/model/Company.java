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
	public String getName(){
		return name;
	}	
	public void setName(String pName) {
		name = pName;
	}

	public Ship getOwned() {
		return owned;
	}

	public void setOwned(String shipName) {
		owned = new Ship(shipName);
	}
	public Client[] getClientList() {
		return clientList;
	}
	public String getClientName(int position) {
		return clientList[position].getName();
	}
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
	public void startTrip() {
		//pCurrentShipmentWeight, pAmountShipmentLoads, pSendable, pDangerousCargoPresence, pPerishableCargoPresence
		owned.setCurrentTrip(0,0,false,false);
	}
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
	public boolean setSail() {
		return owned.getCurrentTrip().checkSendable();
	}
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
	public String getCurrentTripInfo() {
		String message=("You are currently shipping " + getOwned().getCurrentTrip().getAmountShipmentLoads()+
				" load(s), which weigh(s) a total of " + getOwned().getCurrentTrip().getCurrentShipmentWeight());
		return message;
	}
}
