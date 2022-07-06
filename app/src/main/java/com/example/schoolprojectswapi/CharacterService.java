package com.example.schoolprojectswapi;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CharacterService {
    public static final String QUERY_FOR_CHARACTER_NAME = "https://swapi.dev/api/people/?search=";
    public static final String QUERY_FOR_CHARACTER_LIST = "https://swapi.dev/api/people/";

    Context context;
    String characterName;

    public CharacterService(Context context) {
        this.context = context;
    }

    public interface SpecificCharacterResponseListener {
        void onError(String message);

        void onResponse(List<CharacterModel> characterModels);
    };

    public void getCharacter(String characterId, final SpecificCharacterResponseListener specificCharacterResponseListener) {
        List<CharacterModel> characterModels = new ArrayList<>();
        String url = QUERY_FOR_CHARACTER_NAME + characterId;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray result = response.getJSONArray("results");


                    for (int i = 0; i < result.length() ; i++) {
                        JSONObject specific_character_api = (JSONObject) result.get(i);

                        CharacterModel single_character = new CharacterModel();

                        single_character.setName(specific_character_api.getString("name"));
                        single_character.setHair_color(specific_character_api.getString("hair_color"));
                        single_character.setSkin_color(specific_character_api.getString("skin_color"));
                        single_character.setBirth_year(specific_character_api.getString("birth_year"));
                        single_character.setGender(specific_character_api.getString("gender"));
                        single_character.setHomeworld(specific_character_api.getString("homeworld"));
                        single_character.setHeight(specific_character_api.getString("height"));
                        single_character.setMass(specific_character_api.getString("mass"));

                        characterModels.add(single_character);
                    }

                    specificCharacterResponseListener.onResponse(characterModels);

                    //get the first item
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                specificCharacterResponseListener.onError("Something wrong");

            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }


    public interface CharacterResponseListener {
        void onError(String message);

        void onResponse(List<CharacterModel> characterModels);
    };

    public void getAllCharacters(CharacterResponseListener characterResponseListener){
        List<CharacterModel> characterModels = new ArrayList<>();

        String url = QUERY_FOR_CHARACTER_LIST;
        //get json object
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");

                    for (int i=0; i < results.length(); i++){
                        CharacterModel character = new CharacterModel();

                        JSONObject first_character_api = (JSONObject) results.get(i);
                        character.setName(first_character_api.getString("name"));
                        character.setHair_color(first_character_api.getString("hair_color"));
                        character.setSkin_color(first_character_api.getString("skin_color"));
                        character.setBirth_year(first_character_api.getString("birth_year"));
                        character.setGender(first_character_api.getString("gender"));
                        character.setHomeworld(first_character_api.getString("homeworld"));
                        character.setHeight(first_character_api.getString("height"));
                        character.setMass(first_character_api.getString("mass"));

                        characterModels.add(character);
                    }
                    characterResponseListener.onResponse(characterModels);

                    //get the first item
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
