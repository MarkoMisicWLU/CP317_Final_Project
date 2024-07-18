package classes;

import java.util.ArrayList;

public class Recipe{
    private int recipeTimeFrame;
    private ArrayList<String> recipeDietary;
    private ArrayList<String> recipeIngredients;

    public Recipe(int timeFrame, ArrayList<String> recipeDiet, ArrayList<String> ingredients){
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

    public ArrayList<String> getRecipeDietary() {
        return recipeDietary;
    }

    public void setRecipeDietary(ArrayList<String> recipeDietary) {
        this.recipeDietary = recipeDietary;
    }

    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(ArrayList<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}