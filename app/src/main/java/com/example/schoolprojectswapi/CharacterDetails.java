package com.example.schoolprojectswapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CharacterDetails extends AppCompatActivity {

    TextView characterNameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);

        characterNameView = findViewById(R.id.characterNameView);

        CharacterModel character = getIntent().getParcelableExtra("object");
        characterNameView.setText(character.getBirth_year());

    }
}