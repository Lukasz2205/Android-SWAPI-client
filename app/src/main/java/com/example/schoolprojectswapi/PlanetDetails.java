package com.example.schoolprojectswapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlanetDetails extends AppCompatActivity {

    TextView planetNameView, planetRotationPeriodView, planetOrbitalPeriodView, planetDiameterView, planetClimateView, planetGravityView, planetTerrainView, planetSurfaceWaterView, planetPopulationView;
    Button btn_backToMainActivity2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);

        planetNameView = findViewById(R.id.planetNameView);
        planetRotationPeriodView = findViewById(R.id.planetRotationPeriodView);
        planetOrbitalPeriodView = findViewById(R.id.planetOrbitalPeriodView);
        planetDiameterView = findViewById(R.id.planetDiameterView);
        planetClimateView = findViewById(R.id.planetClimateView);
        planetGravityView = findViewById(R.id.planetGravityView);
        planetTerrainView = findViewById(R.id.planetTerrainView);
        planetSurfaceWaterView = findViewById(R.id.planetSurfaceWaterView);
        planetPopulationView = findViewById(R.id.planetPopulationView);

        btn_backToMainActivity2 = findViewById(R.id.btn_backToMainActivity2);

        PlanetModel planetModel = getIntent().getParcelableExtra("object");
        planetNameView.setText("Nazwa: " + planetModel.getName());
        planetRotationPeriodView.setText("Okres obrotów: " + planetModel.getRotation_period());
        planetOrbitalPeriodView.setText("Okres orbitalny: " + planetModel.getOrbital_period());
        planetDiameterView.setText("średnica: " + planetModel.getDiameter());
        planetClimateView.setText("Klimat: " + planetModel.getClimate());
        planetGravityView.setText("Grawitacja: " + planetModel.getGravity());
        planetTerrainView.setText("Terren: " + planetModel.getTerrain());
        planetSurfaceWaterView.setText("Woda na powierzchni:  " +planetModel.getSurface_water());
        planetPopulationView.setText("Populacja:  " + planetModel.getPopulation());

        btn_backToMainActivity2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanetDetails.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}