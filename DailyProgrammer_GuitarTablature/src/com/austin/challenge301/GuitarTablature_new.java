package com.austin.challenge301;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GuitarTablature_new {

	static List<String> notes = Arrays.asList("C","C#","D","D#","E","F","F#","G","G#","A","A#","B");
	
	public static void main(String[] args) throws IOException{
	    char[][] map = Files.lines(new File("Sample2.txt").toPath()).map(String::toCharArray).toArray(char[][]::new);
	    
	    for(int y = 2; y < map[0].length; y++) {
	    	
	        for(int x = 0; x < map.length; x++) {
	        	
	            if(Character.isDigit(map[x][y])){
	            	
	                int value = map[x][y]-'0';
	                
	                while(Character.isDigit(map[x][y+1]))
	                    value = value * 10 + (map[x][++y]-'0');
	                
	                value += notes.indexOf(Character.toString(map[x][0]));
	                
	                System.out.print(notes.get(value%12) + ( (12 - x) / 3 + (value / 12) ) + " ");
	            }
	        }
	    }
	}

}
