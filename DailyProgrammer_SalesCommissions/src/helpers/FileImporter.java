package helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileImporter {

	public FileImporter() {
		
	}
	
	public String[] getFileAsArray(String fileName) {
		
		try {
			return Files.lines(new File(fileName).toPath())
					.toArray(String[]::new);
		} catch(IOException io) {
			io.printStackTrace();
		}
		
		return null;
	}
	
	public String[][] getFileAs2DArray(String fileName, String regex) {
		
		try {
			return Files.lines(new File(fileName).toPath())
					.filter(line -> !line.trim().isEmpty())
					.map(line -> line.trim().split(regex))
					.toArray(String[][]::new);
		} catch(IOException io) {
			io.printStackTrace();
		}
		
		return null;
	}
}
