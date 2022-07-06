package com.example.schoolprojectswapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_getCharacters, btn_getPlanet, btn_getCharactersList, btn_getPlanetsList;
    EditText sw_dataInput;
    ListView sw_dataContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign values to control on the layout
        btn_getCharacters = findViewById(R.id.btn_getCharacters);
        btn_getPlanet = findViewById(R.id.btn_getPlanet);
        btn_getCharactersList = findViewById(R.id.btn_getCharactersList);
        btn_getPlanetsList = findViewById(R.id.btn_getPlanetsList);

        sw_dataInput = findViewById(R.id.sw_dataInput);
        sw_dataContainer = findViewById(R.id.sw_dataContainer);

        btn_getCharacters.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CharacterService characterService = new CharacterService(MainActivity.this);

                characterService.getCharacter(sw_dataInput.getText().toString(), new CharacterService.SpecificCharacterResponseListener(){
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<CharacterModel> characterModels) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, characterModels);
                        sw_dataContainer.setAdapter(arrayAdapter);
                        sw_dataContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                CharacterModel obj = characterModels.get(position);
                                Intent intent = new Intent(MainActivity.this, CharacterDetails.class);
                                intent.putExtra("object", obj);
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });

        btn_getCharactersList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CharacterService characterService = new CharacterService(MainActivity.this);

                characterService.getAllCharacters(new CharacterService.CharacterResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<CharacterModel> characterModels) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, characterModels);
                            sw_dataContainer.setAdapter(arrayAdapter);
                    }
                });
            }
        });

        btn_getPlanet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                PlanetService planetService = new PlanetService(MainActivity.this);

                planetService.getPlanet(sw_dataInput.getText().toString(), new PlanetService.SinglePlanetResponseListener(){
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<PlanetModel> planetModels) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, planetModels);
                        sw_dataContainer.setAdapter(arrayAdapter);
                    }
                });
            }
        });

        btn_getPlanetsList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                PlanetService planetService = new PlanetService(MainActivity.this);

                planetService.getAllPlanets(sw_dataInput.getText().toString(), new PlanetService.PlanetResponseListener(){
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<PlanetModel> planetModels) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, planetModels);
                        sw_dataContainer.setAdapter(arrayAdapter);
                    }
                });
            }
        });
    }
}