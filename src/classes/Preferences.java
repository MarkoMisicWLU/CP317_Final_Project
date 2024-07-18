package classes;
import java.util.ArrayList;

public class Preferences{
    private int userTimeFrame;
    private ArrayList<String> userDietary;
    private ArrayList<String> userIngredients;

    public Preferences(int timeFrame,ArrayList<String> dietList, ArrayList<String> ingredients){
        this.userTimeFrame = timeFrame;
        this.userDietary = dietList;
        this.userIngredients = ingredients;
    }

    public int getUserTimeFrame() {
        return userTimeFrame;
    }

    public void setUserTimeFrame(int userTimeFrame) {
        this.userTimeFrame = userTimeFrame;
    }

    public ArrayList<String> getUserDietary() {
        return userDietary;
    }

    public void setUserDietary(ArrayList<String> userDietary) {
        this.userDietary = userDietary;
    }  

    public ArrayList<String> getUserIngredients() {
        return userIngredients;
    }

    public void setUserIngredients(ArrayList<String> userIngredients) {
        this.userIngredients = userIngredients;
    }

    public void addDietary(String diet){
        this.userDietary.add(diet);
    }

    public void removeDietary(String diet){
        this.userDietary.remove(diet);
    }

    public void addIngredient(String ingredient){
        this.userIngredients.add(ingredient);
    }

    public void removeIngredient(String ingredient){
        this.userIngredients.remove(ingredient);
    }
}