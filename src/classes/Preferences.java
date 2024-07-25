package classes;
import java.util.ArrayList;
import java.util.Arrays;

public class Preferences{
    private int userTimeFrame;
    private String userDietary;
    private ArrayList<String> userIngredients;

    public Preferences(int timeFrame,String dietList, String userIngredients){
        this.userTimeFrame = timeFrame;
        this.userDietary = dietList;
        this.userIngredients = new ArrayList<>(Arrays.asList(userIngredients.split(",")));
    }

    public int getUserTimeFrame() {
        return userTimeFrame;
    }

    public void setUserTimeFrame(int userTimeFrame) {
        this.userTimeFrame = userTimeFrame;
    }

    public String getUserDietary() {
        return userDietary;
    }

    public void setUserDietary(String userDietary) {
        this.userDietary = userDietary;
    }  

    public ArrayList<String> getUserIngredients() {

        return userIngredients;
    }

    public void setUserIngredients(String userIngredients) {
        this.userIngredients = new ArrayList<>(Arrays.asList(userIngredients.split(",")));
    }
}