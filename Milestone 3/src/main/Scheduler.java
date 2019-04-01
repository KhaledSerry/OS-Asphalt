package main;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Scheduler extends Process implements Runnable {

	static PriorityQueue<Process> readyQueue;
	static PriorityQueue<Process> blockedQueue;
	static Process running;
	public Scheduler()
	{
		readyQueue = new PriorityQueue<>();
		blockedQueue = new PriorityQueue<>();
		running = null;
	}
	public static void add(Process p) {
		readyQueue.add(p);
	}

	@SuppressWarnings("deprecation")
	public static void done() {
		if (!readyQueue.isEmpty()) {
			running = readyQueue.remove();
			running.resume();
		} else
			running = null;
	}

	public static void remove(Process p) {
		blockedQueue.remove(p);
	}

	public void run(){
		if (!readyQueue.isEmpty() && running!=null) {

			Process process = readyQueue.peek();
			if (process.getPCB().getPriorty() > running.getPCB().getPriorty()) {

			} else {
				running.suspend();
				readyQueue.remove();
				readyQueue.add(running);
				if(process.getState()== Thread.State.NEW)
				{
				process.start();
				}
				else
				{
					process.resume();
				}
				running = process;
			}

			// running.resume();
		} else
		{
			if(!readyQueue.isEmpty() && running==null)
			{
				running = readyQueue.remove();
			}
			else
				running = null;
		}

	}

}
