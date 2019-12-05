package com.bsmith.recipe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class File {

    // Reads fileName file
	protected List<String> read(String fileName) {
	   	 
	   	List<String> result = new ArrayList<String>();
	   	
	   	Stream<String> lines = null;
	   	
	   	// Reads file line by line.
		try {
			lines = Files.lines(Paths.get(fileName));
		} catch (NoSuchFileException e) {
			System.out.println("That file does not exsist");
		} catch (IOException e) {
			e.printStackTrace();
		}
	   	
		// Adds items to result if not null
		try {
			result = lines.collect(Collectors.toList());
		} catch (NullPointerException e) {
			System.out.println("Can not add NULL");
		}
	   	
	   	return result;
		
	}
	
	// Changes List<String> to List<String[]>
	protected List<String[]> createListStringArr(List<String> recipes) {
		
		List<String[]> recipesList = new ArrayList<String[]>();
		
		for (String recipe : recipes) {
			recipesList.add(recipe.split(","));
		}

		return recipesList;
	}
    
}
