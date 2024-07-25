package classes;

import java.util.ArrayList;

public class Recipe{
    private int recipeTimeFrame;
    private String recipeDietary;
    private String recipeInstructions;
    private ArrayList<String> recipeIngredients;

    public Recipe(int timeFrame, String recipeDiet, ArrayList<String> ingredients){
        this.recipeTimeFrame = timeFrame;
        this.recipeIngredients = ingredients;
        this.recipeDietary = recipeDiet;
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

    public void setRecipeIngredients(ArrayList<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions){
        this.recipeInstructions = recipeInstructions;
    }
}