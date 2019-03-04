package main;

import java.util.PriorityQueue;

public class Asphalt {
	static PriorityQueue<Process> readyQueue;
	static PriorityQueue<Process> blockedQueue;
	Process running;
	public static void add(Process p) {
		readyQueue.add(p);
	}
	public static void remove(Process p) {
		blockedQueue.remove(p);
	}
	
}
