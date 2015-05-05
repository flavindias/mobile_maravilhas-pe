package com.citrus.maravilhaspe.wonder.domain;

/**
 * Created by Erick on 29/04/2015.
 */
public class Wonder {
    private String name;
    private String description;
    private String city;
    private String street;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String toString(){
        return this.name;
    }
}
