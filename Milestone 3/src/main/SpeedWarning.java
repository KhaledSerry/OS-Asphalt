package main;

public class SpeedWarning extends Process implements Runnable {
	String disk = "Run speed warning";

	public SpeedWarning() {
		super();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		this.getPCB().setPriority(5);
		this.getPCB().setStackPointer(Memory.add(disk));
		Asphalt.dispatcher.add(this);
		System.err.println("after dispatcher");
		Asphalt.dispatcher.run();
		System.err.println("after run dispatcher");
		int size = Asphalt.memorys.memory.length - 1;
		String speed = Memory.memory[size];
		int value = Integer.parseInt(speed.split(",")[1]);

		while (value >= 140) {
			mutex.semWait(this);
			System.err.println("in the loop");
			Sensor sensor = new Sensor();
			sensor.warning();
			mutex.semSignal(this);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			speed = Asphalt.memorys.memory[size];
			value = Integer.parseInt(speed.split(",")[1]);

		}
		System.err.println(this.getPCB().getStackPointer());
		System.err.println(Asphalt.memorys.toString());
		Asphalt.memorys.remove(this.getPCB().getStackPointer());
		Asphalt.dispatcher.run();
	}

	public static void main(String[] args) {

	}
}
