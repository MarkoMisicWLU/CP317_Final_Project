package classes;

public class Meal {
    private String mealName;
    private Recipe mealRecipe;
    public Meal(String name, Recipe recipe){
        this.mealName = name;
        this.mealRecipe = recipe;
    }
    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Recipe getMealRecipe() {
        return mealRecipe;
    }

    public void setMealRecipe(Recipe mealRecipe) {
        this.mealRecipe = mealRecipe;
    }
}
