package main;

public class WearBelt extends Process implements Runnable {
String disk = "wearing or taking off SeatBelt";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.getPCB().setPriority(3);
		this.getPCB().setStackPointer(Memory.add(disk));
		Asphalt.dispatcher.add(this);
		Asphalt.dispatcher.run();
		int size =Memory.memory.length-1;
		Asphalt.memorys.memory[size-1] = Asphalt.memorys.memory[size-1]=="belt,1"?"belt,0":"belt,1";
		System.err.println(this.getPCB().getStackPointer());
		System.err.println(Asphalt.memorys.toString());
		
		new SeatbeltWarning().start();
		Asphalt.memorys.remove(this.getPCB().getStackPointer());
		Asphalt.dispatcher.run();
		
	}

}
