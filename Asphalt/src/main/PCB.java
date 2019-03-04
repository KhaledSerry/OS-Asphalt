package main;

import java.util.ArrayList;

public class PCB {
	private int id;
	private int userID;
	private status status;
	private int stackPointer;
	private int priority;
	private int eventID;
	private ArrayList<Integer> privileges;
	private static int currentID=0;

	public PCB(int userID,int priotity,ArrayList<Integer> privileges) {
		this.id=currentID++;
		this.setStatus(getStatus().NEW);
		this.userID=userID;
		this.stackPointer=0;
		this.priority=priotity;
		this.eventID=0;
		this.privileges=privileges;
		}
	
	public int getPriorty() {
		return priority;
	}
	public int getID() {
		return id;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(status status) {
		this.status = status;
	}

}



// switch(pointer){
// case 1:while(true) if() break;
// case 2
// }