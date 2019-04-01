package main;

public class ParkingSensor extends Process implements Runnable{
	String disk = "running ParkingSensor";
	public ParkingSensor()
	{
		
	}
	@Override
	public void run() {
		
		this.getPCB().setPriority(3);
		this.getPCB().setStackPointer(Memory.add(disk));
		Asphalt.dispatcher.add(this);
		Asphalt.dispatcher.run();
		int size =Memory.memory.length-3;
		String reverese = Memory.memory[size];
		int value = Integer.parseInt(reverese.split(",")[1]);
		
		
		while(value ==0)
		{
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
		 
		 reverese = Memory.memory[size];
		 value = Integer.parseInt(reverese.split(",")[1]);
		
		}
		Memory.remove(this.getPCB().getStackPointer());
		Asphalt.dispatcher.run();
	}

}
