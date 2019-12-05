package com.bsmith.recipe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StartApp {
	private static final String FILE_NAME = "src/main/resources/recipes";
	
	public static void main(String[] args) {

		final File fileObj = new File();
		final Pantry pantry = new Pantry();
		final UserInput uI = new UserInput();
		final List<String> list = fileObj.read(FILE_NAME);
		final List<String[]> listStr = fileObj.createListStringArr(list);		

		final HashMap<String, Recipe> recipeMap = pantry.createRecipeMap(listStr);
		final HashMap<String, Ingredient> ingredientMap = pantry.createIngredientMap(listStr);
	    
	    for (Ingredient ingred : pantry.ingredientMap.values()) {
	    	System.out.print(ingred.name + "\n");
	    }

    	final Ingredient ingredient = new Ingredient();
	    ingredient.createListRecipe(listStr, recipeMap, ingredientMap);
	    
		System.out.println("\nEnter in the ingredients that are missing from the pantry");
		final HashSet<String> input = uI.userInput();

		ingredient.changeAvailable(input, ingredientMap);
		final List<Recipe> availableRecipes = pantry.availableRecipes(recipeMap);

		System.out.println("The available recipes are: ");
		for (Recipe recipe : availableRecipes) {
			System.out.println(recipe.name);
		}
	}
}

