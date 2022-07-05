package com.example.schoolprojectswapi;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class CharacterService {
    public static final String QUERY_FOR_CHARACTER_NAME = "https://swapi.dev/api/people/";

    Context context;
    String characterName;

    public CharacterService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String characterName);
    };

    public void getCharacter(String characterId, final VolleyResponseListener volleyResponseListener) {
        String url = QUERY_FOR_CHARACTER_NAME + characterId;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                characterName = "";
                try {
                    characterName = response.getString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(context, "Nazwa: " + characterName, Toast.LENGTH_SHORT).show();
                volleyResponseListener.onResponse(characterName);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Something wrong");

            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
//        return characterName;
    }
}
