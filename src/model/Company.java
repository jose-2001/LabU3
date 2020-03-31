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
			{if(clientList[i].getName().equals(lookFor.getName()))
				{exists = true;}
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
	public String addLoad(int pOwner,int pBoxAmount,double pWeightPerBox,char pCargoType ) {
		String message="";
		Load toAdd = new Load(pBoxAmount, pWeightPerBox, pCargoType);
		return message;
	}
}
