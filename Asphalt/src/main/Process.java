package main;

public abstract class Process implements Comparable<Process>{
	private PCB PCB;
	public Process() {
		
	}
	public abstract void run();
	public void block() {
		getPCB().setStatus(status.BLOCKED);
		Asphalt.blockedQueue.add(this);
	}
	public void preemptied() {
		getPCB().setStatus(status.READY);
		Asphalt.readyQueue.add(this);
	}
	public int compareTo(Process p) {  
	    if(getPCB().getPriorty()>p.getPCB().getPriorty()){  
	        return 1;  
	    }else if(getPCB().getPriorty()<p.getPCB().getPriorty()){  
	        return -1;  
	    }else{  
	    return 0;  
	    }  
	}
	public PCB getPCB() {
		return PCB;
	}
	public void setPCB(PCB pCB) {
		PCB = pCB;
	}  
}
