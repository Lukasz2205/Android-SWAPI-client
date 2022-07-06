package com.example.schoolprojectswapi;

import android.os.Parcel;
import android.os.Parcelable;

public class PlanetModel implements Parcelable {
    private String name;
    private int rotation_period;
    private int orbital_period;
    private int diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;

    public PlanetModel(String name, int rotation_period, int orbital_period, int diameter, String climate, String gravity, String terrain, String surface_water, String population) {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.population = population;
    }

    public PlanetModel() {
    }

    protected PlanetModel(Parcel in) {
        name = in.readString();
        rotation_period = in.readInt();
        orbital_period = in.readInt();
        diameter = in.readInt();
        climate = in.readString();
        gravity = in.readString();
        terrain = in.readString();
        surface_water = in.readString();
        population = in.readString();
    }

    public static final Creator<PlanetModel> CREATOR = new Creator<PlanetModel>() {
        @Override
        public PlanetModel createFromParcel(Parcel in) {
            return new PlanetModel(in);
        }

        @Override
        public PlanetModel[] newArray(int size) {
            return new PlanetModel[size];
        }
    };

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(int rotation_period) {
        this.rotation_period = rotation_period;
    }

    public int getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(int orbital_period) {
        this.orbital_period = orbital_period;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(rotation_period);
        parcel.writeInt(orbital_period);
        parcel.writeInt(diameter);
        parcel.writeString(climate);
        parcel.writeString(gravity);
        parcel.writeString(terrain);
        parcel.writeString(surface_water);
        parcel.writeString(population);
    }
}
