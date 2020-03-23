package model;

public class Company {

//Attributes
	private String name;
//Relations
	private Ship owned;
	private Client[] clientList;
	
//Methods
	public Company(String pName, Ship pOwned, int clientAmount) {
		name = pName;
		setOwned(pOwned);
		clientList= new Client[clientAmount];
	}
	public void addClient(Client toAdd, int position) {
		clientList[position]= toAdd;
	}
	public boolean searchClient(Client lookFor) {
		boolean exists = false;
		for(int i=0; i<clientList.length; i++)
			{if(clientList[i].equals(lookFor))
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

	public void setOwned(Ship pOwned) {
		owned = pOwned;
	}
	
}
