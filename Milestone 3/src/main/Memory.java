package main;

import java.util.ArrayList;

public class Memory {
	static String[] memory;
	static int pointer ;
	static boolean[] deleted;
	public Memory(int size)
	{
		memory = new String[size];
		pointer = size-1;
		memory[pointer]="Speed,120";
		memory[pointer-1]="Belt,0";
		memory[pointer-2]="Reverese,0";
		memory[pointer-3]="CruiseControl,0";
		deleted = new boolean[size];
		deleted[pointer] = true;
		deleted[pointer-3] = true;
		deleted[pointer-1] = true;
		deleted[pointer-2] = true;
		
	}
	
	public static int add(String s)
	{	int i = 0;
		for(i = memory.length-1; i >=0 ; i--)
		{
			if(!deleted[i])
			{
				memory[i] = s;
				deleted[i] = true;
				break;
			}
			
		}
		return i;
		
	}
	public static void remove(int index)
	{
		deleted[index] = false;
	}
	public String toString()
	{
		String s ="";
		for(int i = memory.length-1; i>=0 ; i--)
		{
			s+=i+" : "+ memory[i] +"  "+ deleted[i]+'\n';
		}
		return s;
	}
	
}
