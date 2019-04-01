package main;

public class SeatbeltWarning extends Process implements Runnable{
	String disk = "Speed belt warning";
	
	public SeatbeltWarning()
	{
		super();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		this.getPCB().setPriority(10);
		this.getPCB().setStackPointer(Memory.add(disk));
	
		
		
		Asphalt.dispatcher.add(this);
		Asphalt.dispatcher.run();
		
		int size =Memory.memory.length-1;
		String speed = Memory.memory[size];
		int value = Integer.parseInt(speed.split(",")[1]);
		
		
		String belt = Memory.memory[size-1];
		int bell = Integer.parseInt(belt.split(",")[1]);
		boolean trigger = false;
		
		while(value >=10 && bell ==0 )
		{	try {
			if(!trigger) {
			Thread.sleep(10000);
			trigger = true;
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		belt = Memory.memory[size-1];
		bell = Integer.parseInt(belt.split(",")[1]);
		if(bell == 1)
			break;
		
		mutex.semWait(this);
		Sensor sensor = new Sensor();
		sensor.warning();
		mutex.semSignal(this);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 speed = Memory.memory[size];
		 value = Integer.parseInt(speed.split(",")[1]);
		
		}
		
		Memory.remove(this.getPCB().getStackPointer());
		
		Asphalt.dispatcher.run();
		 
	}
		


}
