package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        String mainName = "";
        List<String> alsoKnownAs = new ArrayList<String>();
        String placeOfOrigin = "";
        String description = "";
        String image = "";
        List<String> ingredients = new ArrayList<String>();

        JSONObject sandwichObj = null;
        try {
            sandwichObj = new JSONObject(json);
            JSONObject name = sandwichObj.getJSONObject("name");
            mainName = name.getString("mainName");

            JSONArray akas = name.getJSONArray("alsoKnownAs");
            for(int i=0; i<akas.length(); i++){
                alsoKnownAs.add((String)akas.get(i));
            }
            placeOfOrigin = sandwichObj.getString("placeOfOrigin");
            description = sandwichObj.getString("description");
            image = sandwichObj.getString("image");

            JSONArray ingredientsArray = name.getJSONArray("ingredients");
            for(int i=0; i<ingredientsArray.length(); i++){
                ingredients.add((String)ingredientsArray.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return new Sandwich();
        }
        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
