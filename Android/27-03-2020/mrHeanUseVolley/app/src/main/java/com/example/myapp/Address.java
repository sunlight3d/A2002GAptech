package com.example.myapp;

import androidx.annotation.NonNull;

import org.json.JSONObject;

import java.util.Hashtable;

public class Address {
    private String street, suite, city, zipCode;
    private Hashtable<String, Float> geo = new Hashtable<>();
    public static Address createFromJSONObject(JSONObject object) {
        Address address = new Address();
        try {
            address.street = object.getString("street");
            address.suite = object.getString("suite");
            address.city = object.getString("city");
            address.zipCode = object.getString("zipcode");
            //geo ?
            address.geo.put("lat", Float.valueOf(object.getJSONObject("geo").getString("lat")));
            address.geo.put("lng", Float.valueOf(object.getJSONObject("geo").getString("lng")));
            return address;
        } catch (Exception e) {
            return address;
        }
    }
    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Hashtable<String, Float> getGeo() {
        return geo;
    }

    public void setGeo(Hashtable<String, Float> geo) {
        this.geo = geo;
    }

    @NonNull
    @Override
    public String toString() {
        return this.city + ", " +
                this.street + ", " +
                this.zipCode + ", " +
                this.geo.get("lat") + ", " +
                this.geo.get("lng") + ", " ;
    }
}
