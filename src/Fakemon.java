import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class Fakemon {
	
	//stats
	int bst, HP, atk, def, spatk, spdef, speed;
	
	//constants
	public static final int DEFAULT_BSTMIN = 18;
	public static final int DEFAULT_BSTMAX = 60;
	
	//constructor
	public Fakemon(int bstmin, int bstmax) {
		
		//make random number generator
		Random rand = new Random();
		
		//generate base stat total
		//check if bstmax and bstmin are valid. if not, use defaults
		if (bstmin > bstmax) {
			bstmin = DEFAULT_BSTMIN;
			bstmax = DEFAULT_BSTMAX;
		}
		//now actually generate it
		bst = rand.nextInt(bstmax - bstmin) + bstmin;
		
		//generate base stats
		int HPo, atko, defo, spatko, spdefo, speedo;
		HPo = rand.nextInt(100);
		atko = rand.nextInt(100);
		defo = rand.nextInt(100);
		spatko = rand.nextInt(100);
		spdefo = rand.nextInt(100);
		speedo = rand.nextInt(100);
		int total = HPo + atko + defo + spatko + spdefo + speedo;
		float HPr, atkr, defr, spatkr, spdefr, speedr;
		HPr = ((float) HPo) / ((float) total);
		atkr = ((float) atko) / ((float) total);
		defr = ((float) defo) / ((float) total);
		spatkr = ((float) spatko) / ((float) total);
		spdefr = ((float) spdefo) / ((float) total);
		speedr = ((float) speedo) / ((float) total);
		HP = (int) (((float) (bst - 6)) * HPr) + 1;
		atk = (int) (((float) (bst - 6)) * atkr) + 1;
		def = (int) (((float) (bst - 6)) * defr) + 1;
		spatk = (int) (((float) (bst - 6)) * spatkr) + 1;
		spdef = (int) (((float) (bst - 6)) * spdefr) + 1;
		speed = (int) (((float) (bst - 6)) * speedr) + 1;
	}
	
	//default constructor
	public Fakemon() {
		this(DEFAULT_BSTMIN, DEFAULT_BSTMAX);
	}
	
	//print fakemon data to fakedex file
	public void dex(BufferedWriter writer) {
		try {
			writer.write("Fakemon:");
			writer.newLine();
			writer.write("Base Stat Total: " + bst);
			writer.newLine();
			writer.write("HP: " + HP);
			writer.newLine();
			writer.write("Attack: " + atk);
			writer.newLine();
			writer.write("Defense: " + def);
			writer.newLine();
			writer.write("Special Attack: " + spatk);
			writer.newLine();
			writer.write("Special Defense: " + spdef);
			writer.newLine();
			writer.write("Speed: " + speed);
			writer.newLine();
			writer.newLine();
		}
		catch (IOException e) {
			System.err.println("Error writing to Fakedex");
		}
	}
}
