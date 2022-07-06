package com.example.schoolprojectswapi;

public class CharacterModel {
    private String name;
    private String hair_color;
    private String skin_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private int height;
    private int mass;

    public CharacterModel(String name, String hair_color, String skin_color, String birth_year, String gender, String homeworld, int height, int mass) {
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

    @Override
    public String toString() {
        return "CharacterModel{" +
                "name='" + name + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", birth_year='" + birth_year + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                '}';
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
