package com.austin.challenge.i245;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gggg {

	public Gggg() { }
	
	public void encode(String s) {
		
	}
	
	public void decode(String filename) {
		String[] decoder = {};
		StringBuilder message = new StringBuilder();
		
		// compile the decoder and get message
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getClass().getResource(filename).toURI()))));

			decoder = br.readLine().trim().split("[ ]");
			
			String line;
			while((line = br.readLine()) != null) {
				message.append(line);
			}
			
			br.close();
			
			if(decoder == null) { throw new Exception("Problem compiling the decoder."); }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// decode the message
		int endex = message.length();
		for(int i = 1; i < decoder.length; i+=2) {
			
			while(endex != -1) {
				endex = message.lastIndexOf(decoder[i], endex);
				message.replace(endex, decoder[i].length(), decoder[i-1]);

			}
			
		}
		
		System.out.println(message.toString());
	}
}
