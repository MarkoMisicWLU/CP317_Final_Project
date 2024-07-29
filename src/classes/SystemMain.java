package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SystemMain {
    private boolean matchStatus;
    

    public ArrayList<Meal> generateBestMatch(Preferences userPreferences) {
        String dietaryRestrictions = userPreferences.getUserDietary();
        String userIngredient1 = userPreferences.getUserIngredients().get(0);
        String userIngredient2 = userPreferences.getUserIngredients().get(1);
        String userIngredient3 = userPreferences.getUserIngredients().get(2);
        int userTimeFrame = userPreferences.getUserTimeFrame();

        ArrayList<Meal> meals = new ArrayList<>();

        try {
            String jdbcURL = "jdbc:mysql://172.16.169.45:3306/cp317Project";
            String username = "root";
            String password = "root";
            
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            Statement st = con.createStatement();
            
  
            String sql = "SELECT * FROM Recipes WHERE VEGAN_OR_VEG LIKE '" + dietaryRestrictions + 
                         "' AND INGREDIENT_1 LIKE '" + userIngredient1 + 
                         "' AND INGREDIENT_2 LIKE '" + userIngredient2 + 
                         "' AND INGREDIENT_3 LIKE '" + userIngredient3 + 
                         "' AND TIME_MINS <= " + userTimeFrame;

            
            ResultSet rs = st.executeQuery(sql);
            int columnCount = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                String recipe_name = rs.getString("RECIPE_NAME");
                String ingredient_1 = rs.getString("INGREDIENT_1");
                String ingredient_2 = rs.getString("INGREDIENT_2");
                String ingredient_3 = rs.getString("INGREDIENT_3");
                String dietaryInfo = rs.getString("VEGAN_OR_VEG");
                int time_mins = rs.getInt("TIME_MINS");
                String recipe_instructions = rs.getString("RECIPE_INSTRUCTIONS");
                String ingredients = ingredient_1 + "," + ingredient_2 + "," + ingredient_3;
                
                Recipe returnedRecipe = new Recipe(time_mins, dietaryInfo, ingredients, recipe_instructions);
                
                Meal recommendedMeal = new Meal(recipe_name, returnedRecipe);
                
                meals.add(recommendedMeal);

            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return meals;
    }
}
