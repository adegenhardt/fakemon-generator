import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class FakemonGenerator {
	public static void main(String[] args) {
		
		//get name of fakedex file
		String fakedex;
		if (args.length >= 1)
			fakedex = args[0];
		else
			fakedex = "Fakedex.txt";
		
		//clear or create Fakedex and create BufferedWriter for Fakedex
		BufferedWriter bw;
		try {
			File file = new File(fakedex);
			FileWriter fw = new FileWriter(file);
			fw.write("");
			fw.close();
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			System.err.println("Error creating or clearing Fakedex file");
			return;
		}
		
		//generate and print Fakemon
		for (int i = 0; i < 20; i++) {
			Fakemon fm = new Fakemon();
			fm.dex(bw);
		}
		
		//close file
		try {
			bw.close();
		} catch (IOException e) {
			System.err.println("Error closing Fakedex file");
		}
		
		return;
	}
}
