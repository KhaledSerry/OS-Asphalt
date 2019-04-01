package main;

import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {
	private boolean value;
	private int ownerID;
	

	public Semaphore(boolean value) {
		value = true;
		
		
	}

	void semWait(Process p) {
		if (value) {
			ownerID = p.getPCB().getID();
			value = false;
		} else {
			Scheduler.blockedQueue.add(p);
			Scheduler.readyQueue.remove(p);
		}
	}
	

	void semSignal(Process p) {
		if (ownerID == p.getPCB().getID()) {
			if (Scheduler.blockedQueue.isEmpty())
				value = true;
			else {
				Scheduler.readyQueue.add((Process)Scheduler.blockedQueue.remove());
				Process process = new Scheduler();
				process.run();
		}
	}

}
}
