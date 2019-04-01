package main;

public class Gas extends Process implements Runnable{
	
	String disk = "speeding up";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.getPCB().setPriority(2);
		this.getPCB().setStackPointer(Memory.add(disk));
		Asphalt.dispatcher.add(this);
		System.err.println("after dispatcher");
		Asphalt.dispatcher.run();
		int size = Asphalt.memorys.memory.length-1;
		int speed = Integer.parseInt(Asphalt.memorys.memory[size].split(",")[1]);
		String mem = "";
		for(int i = 0 ; i< 5 ; i++)
		{
			speed+= 5;
			mem = "speed,"+speed;
			Asphalt.memorys.memory[size] = mem;
			size = Asphalt.memorys.memory.length-1;
			speed = Integer.parseInt(Asphalt.memorys.memory[size].split(",")[1]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		new SpeedWarning().start();
		Asphalt.memorys.remove(this.getPCB().getStackPointer());
		Asphalt.dispatcher.run();
		
	}

}
