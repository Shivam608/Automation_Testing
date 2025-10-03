package com.Practice.RestAssured.Places.Pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PlaceDetails {

    private Location location;
    private int accuracy;
    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String address;

    @JsonDeserialize(using = CommaSeparatedStringDeserializer.class)
    private String[] types;
    private String website;
    private String language;

    public PlaceDetails(Location location, int accuracy, String name, String phoneNumber, String address, String[] types, String website, String language) {
        this.location = location;
        this.accuracy = accuracy;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.types = types;
        this.website = website;
        this.language = language;
    }

    public PlaceDetails() {}

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
