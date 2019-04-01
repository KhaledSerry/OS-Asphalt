package main;

import java.util.PriorityQueue;
public class Asphalt extends Thread {
	
	static Scheduler dispatcher = new Scheduler();
	static Memory memorys = new Memory(128);
	public static void main(String[] args) throws InterruptedException {
		SpeedWarning speed = new SpeedWarning();
		SeatbeltWarning belt = new SeatbeltWarning();
		Gas gas = new Gas();
		Breaks breaks = new Breaks();
		ParkingSensor park = new ParkingSensor();
		WearBelt wear = new WearBelt();
		WearBelt wear1 = new WearBelt();
		
				belt.start();
		System.out.println(memorys.toString());
		 
		
		Thread.sleep(20000);
		wear.start();
		
		System.out.println(memorys.toString());
		
		Thread.sleep(7000);
		wear1.start();
		System.out.println(memorys.toString());
		
		Thread.sleep(1000);
		
		System.err.println(memorys.toString());
		//memorys.memory[127]="speed,120";
		//Thread.sleep(1000);
		//belt.start();
		
		
		//System.out.println(memorys.toString());
		//System.out.println("we out");
	
		//System.out.println(memorys.toString());
		
		
		
		
	}
	
	
	
}
