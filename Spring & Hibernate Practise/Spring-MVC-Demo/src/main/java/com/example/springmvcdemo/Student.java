package com.example.springmvcdemo;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String countries;
    private LinkedHashMap<String, String> countryOptions;
    private String favoriteLanguage;
    private LinkedHashMap<String,String> favoriteLanguageOptions;
    private String[] OperatingSystems;

    public String[] getOperatingSystems() {
        return OperatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        OperatingSystems = operatingSystems;
    }

    public Student() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("Ind", "India");
        countryOptions.put("usa", "USA");
        countryOptions.put("brz", "Brazil");
        countryOptions.put("pks", "Pakistan");

        favoriteLanguageOptions = new LinkedHashMap<>();
        favoriteLanguageOptions.put("java","Java");
        favoriteLanguageOptions.put("py","Python");

    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }


    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getFirstName() {
        System.out.println("called getFirstname");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("called setFirstName");
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println("called getLastname");
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println("called setLastName");
        this.lastName = lastName;
    }

}
