package com.example.schoolprojectswapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CharacterDetails extends AppCompatActivity {

    TextView characterNameView, characterHairColorView, characterSkinColorView, characterBirthYearView, characterGenderView, characterHomeWorldView, characterHeightView, characterMassView;
    Button backToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);

        characterNameView = findViewById(R.id.characterNameView);
        characterHairColorView = findViewById(R.id.characterHairColorView);
        characterSkinColorView = findViewById(R.id.characterSkinColorView);
        characterBirthYearView = findViewById(R.id.characterBirthYearView);
        characterGenderView = findViewById(R.id.characterGenderView);
        characterHomeWorldView = findViewById(R.id.characterHomeWorldView);
        characterHeightView = findViewById(R.id.characterHeightView);
        characterMassView = findViewById(R.id.characterMassView);

        backToMainActivity = findViewById(R.id.btn_backToMainActivity);

        CharacterModel character = getIntent().getParcelableExtra("object");
        characterNameView.setText("Nazwa: " + character.getName());
        characterHairColorView.setText("Kolor włosów: " + character.getHair_color());
        characterSkinColorView.setText("Kolor skóry: " + character.getSkin_color());
        characterBirthYearView.setText("Rok urodzenia: " + character.getBirth_year());
        characterGenderView.setText("Płeć: " + character.getGender());
        characterHomeWorldView.setText("Miejsce urodzenia: " + character.getHomeworld());
        characterHeightView.setText("Wzrost: " + character.getHeight() + " cm");
        characterMassView.setText("Waga:  " +character.getMass() + " kg");


        backToMainActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterDetails.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}