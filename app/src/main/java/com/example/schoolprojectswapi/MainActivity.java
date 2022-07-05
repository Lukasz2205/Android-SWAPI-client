package com.example.schoolprojectswapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_getCharacters;
    EditText sw_dataInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign values to control on the layout
        btn_getCharacters = findViewById(R.id.btn_getCharacters);
        sw_dataInput = findViewById(R.id.sw_dataInput);

        btn_getCharacters.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CharacterService characterService = new CharacterService(MainActivity.this);

                characterService.getCharacter(sw_dataInput.getText().toString(), new CharacterService.VolleyResponseListener(){
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String characterName) {
                        Toast.makeText(MainActivity.this, "The character name is: " + characterName, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}