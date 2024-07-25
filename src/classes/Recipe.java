package classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Recipe{
    private int recipeTimeFrame;
    private String recipeDietary;
    private String recipeInstructions;
    private ArrayList<String> recipeIngredients;

    public Recipe(int timeFrame, String recipeDiet, String ingredients, String instructions){
        this.recipeTimeFrame = timeFrame;
        this.recipeDietary = recipeDiet;
        this.recipeIngredients = new ArrayList<>(Arrays.asList(ingredients.split(",")));
    }

    public int getRecipeTimeFrame() {
        return recipeTimeFrame;
    }

    public void setRecipeTimeFrame(int recipeTimeFrame) {
        this.recipeTimeFrame = recipeTimeFrame;
    }

    public String getRecipeDietary() {
        return recipeDietary;
    }

    public void setRecipeDietary(String recipeDietary) {
        this.recipeDietary = recipeDietary;
    }

    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = new ArrayList<>(Arrays.asList(recipeIngredients.split(",")));
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions){
        this.recipeInstructions = recipeInstructions;
    }
}