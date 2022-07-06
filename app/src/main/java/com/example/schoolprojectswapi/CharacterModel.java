package com.example.schoolprojectswapi;

import android.os.Parcel;
import android.os.Parcelable;

public class CharacterModel implements Parcelable {
    private String name, hair_color, skin_color, birth_year, gender, homeworld, height, mass;

    public CharacterModel(String name, String hair_color, String skin_color, String birth_year, String gender, String homeworld, String height, String mass) {
        this.name = name;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.height = height;
        this.mass = mass;
    }

    public CharacterModel() {
    }

    protected CharacterModel(Parcel in) {
        name = in.readString();
        hair_color = in.readString();
        skin_color = in.readString();
        birth_year = in.readString();
        gender = in.readString();
        homeworld = in.readString();
        height = in.readString();
        mass = in.readString();
    }

    public static final Creator<CharacterModel> CREATOR = new Creator<CharacterModel>() {
        @Override
        public CharacterModel createFromParcel(Parcel in) {
            return new CharacterModel(in);
        }

        @Override
        public CharacterModel[] newArray(int size) {
            return new CharacterModel[size];
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

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(hair_color);
        parcel.writeString(skin_color);
        parcel.writeString(birth_year);
        parcel.writeString(gender);
        parcel.writeString(homeworld);
        parcel.writeString(height);
        parcel.writeString(mass);
    }
}
