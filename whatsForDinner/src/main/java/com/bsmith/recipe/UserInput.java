package com.bsmith.recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class UserInput extends Pantry {

	final Pantry pantry = new Pantry();

	protected HashSet<String> userInput() {
		

	    //Enter data using BufferReader 
	    BufferedReader reader =  
	               new BufferedReader(new InputStreamReader(System.in)); 
	    HashSet<String> inputSet = new HashSet<String>();
	    String input = " ";
	    
	    // Continues loop until user enters no data
	    while (!input.equals("")) {
		    try {
				input = reader.readLine().trim().toLowerCase();
			} catch (NullPointerException | IOException e) {
				System.out.println("Can not add NULL");
			}
		    if (!input.equals("")) {
			    inputSet.add(input); 
		    }
	    }
		return inputSet;

	}
	
	

}
