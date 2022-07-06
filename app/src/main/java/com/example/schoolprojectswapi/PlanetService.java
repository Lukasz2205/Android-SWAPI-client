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

public class PlanetService {
    public static final String QUERY_FOR_PLANET_NAME = "https://swapi.dev/api/planets/?search=";

    Context context;
    String planetName;

    public PlanetService(Context context) {
        this.context = context;
    }

    public interface SinglePlanetResponseListener {
        void onError(String message);

        void onResponse(List<PlanetModel> planetModels);
    };

    public void getPlanet(String planetId, final SinglePlanetResponseListener singlePlanetResponseListener) {
        List<PlanetModel> planetModels = new ArrayList<>();
        String url = QUERY_FOR_PLANET_NAME + planetId;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray result = response.getJSONArray("results");

                    PlanetModel singlePlanet = new PlanetModel();

                    JSONObject planet = (JSONObject) result.get(0);
                    singlePlanet.setName(planet.getString("name"));
                    singlePlanet.setRotation_period(planet.getInt("rotation_period"));
                    singlePlanet.setOrbital_period(planet.getInt("orbital_period"));
                    singlePlanet.setDiameter(planet.getInt("diameter"));
                    singlePlanet.setClimate(planet.getString("climate"));
                    singlePlanet.setGravity(planet.getString("gravity"));
                    singlePlanet.setTerrain(planet.getString("terrain"));
                    singlePlanet.setSurface_water(planet.getInt("surface_water"));
                    singlePlanet.setPopulation(planet.getInt("population"));

                    planetModels.add(singlePlanet);

                    singlePlanetResponseListener.onResponse(planetModels);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                singlePlanetResponseListener.onError("Something wrong");

            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
