package com.example.schoolprojectswapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_getCharacters, btn_getPlanet, btn_getCharactersList;
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

        sw_dataInput = findViewById(R.id.sw_dataInput);
        sw_dataContainer = findViewById(R.id.sw_dataContainer);

        btn_getCharacters.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CharacterService characterService = new CharacterService(MainActivity.this);

                characterService.getCharacter(sw_dataInput.getText().toString(), new CharacterService.SingleCharacterResponseListener(){
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<CharacterModel> characterModels) {
                        Toast.makeText(MainActivity.this, "The character name is: " + characterModels.toString(), Toast.LENGTH_SHORT).show();

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

                planetService.getPlanet(sw_dataInput.getText().toString(), new PlanetService.VolleyResponseListener(){
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String planetName) {
                        Toast.makeText(MainActivity.this, "The character name is: " + planetName, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}