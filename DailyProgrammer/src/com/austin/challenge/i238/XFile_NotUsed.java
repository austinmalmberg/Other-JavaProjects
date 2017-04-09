package com.austin.challenge.i238;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Split file of specified path into separate files by word length.
 * 
 * @author mac9812e
 *
 */
public class XFile_NotUsed {
	
	List<File> files;
	List<PrintWriter> writers;
	
	public XFile_NotUsed(String source, String destination) {
		files = new ArrayList<>();
		writers = new ArrayList<>();
		
		initResources(destination);
		splitSourceFile(source);
		closePrintWriters();
		
		System.out.println("File split completed.");
	}
	
	private void initResources(String destination) {
		// init files and printwriters
		for(int i = 0; i < 29; i++) {
			
			try {
				String path = getClass().getClassLoader().getResource("").getPath() + destination + i + ".txt";
				path = path.replaceAll("%20", " ");
				path = path.replaceAll("bin", "src");
				
				File file = new File(path);
				file.getParentFile().mkdirs();
				
				PrintWriter writer = new PrintWriter(file);
				
				files.add(file);
				writers.add(writer);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void splitSourceFile(String source) {
		try {	// get contents of source file
			File f = new File(getClass().getResource(source).toURI());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			
			String line;
			while((line = br.readLine()) != null) {	// read each line and write it to the appropriate file
				line = line.trim();
				writers.get(line.length()).println(line);
			}
			
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void closePrintWriters() {
		for(PrintWriter writer : writers) {
			try {
				if(writer != null) writer.close(); 
			} catch(Exception e){
				System.out.println(writer.getClass().getName() + " not closed.");
			}
		}
	}
	
	public void purgeInsufficientFiles(int listLength) {		
		for(int i = files.size() - 1; i >= 0; i--) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(files.get(i))));
				
				int lines = 0;
				while(br.readLine() != null) {
					lines++;
					
					if(lines >= listLength) break;
				}
				
				br.close();
				
				// delete file if list does not contain more than desired lines
				if(lines < listLength) {
					if(files.get(i).delete()) files.remove(i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public File getFile(int wordLength) throws NullPointerException {
		for(File f : files) {
			if(f.getName().equals("wordLength" + wordLength + ".txt")) {
				return f;
			}
		}
		
		System.out.println("File not found.");
		return null;
	}
}
