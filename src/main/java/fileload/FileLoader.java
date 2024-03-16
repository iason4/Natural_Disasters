package fileload;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileLoader {
	
	
	
	private String path;
	private String deli;
	private Scanner inputs;
	
	
	
	
	public FileLoader(String path,String deli)
	{
		this.path=path;
		this.deli=deli;
	}
	
	
	public ArrayList<String[]> load() throws FileNotFoundException
	{
		
		ArrayList<String[]> disasters = new ArrayList<String[]>();
		
		
			File f = new File(path);
			
			inputs= new Scanner(f);			
			while(inputs.hasNext())
			{
				String[] p =inputs.nextLine().split(deli);
				
				disasters.add(p);
				
			}
		
		return disasters;
	}
}

