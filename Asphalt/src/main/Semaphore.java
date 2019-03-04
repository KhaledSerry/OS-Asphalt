package main;

import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {
	private boolean value;
	private int ownerID;
	private Queue waiting;

	public Semaphore(boolean value) {
		value = true;
		waiting = new LinkedList<String>();
		;
	}

	void semWait(Process p) {
		if (value) {
			ownerID = p.getPCB().getID();
			value = false;
		} else {
			waiting.add(p);
			Asphalt.add(p);
		}
	}

	void semSignal(Process p) {
		if (ownerID == p.getPCB().getID()) {
			if (waiting.isEmpty())
				value = true;
			else {
				Asphalt.add((Process)waiting.remove());
				Asphalt.remove(p);
			
		}
	}

}
}
