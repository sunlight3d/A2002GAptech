package com.example.myapp;

import org.json.JSONObject;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String email;

    private String phone;
    private String website;
    private String company;
    //relation ?
    //1 user has 1 address !
    public Address address;
    public static User createFromJSONObject(JSONObject object) {
        try {
            User user = new User();
            user.id = object.getInt("id");
            user.name = object.getString("name");
            user.username = object.getString("username");
            user.email = object.getString("email");
            //user.address = object.getString("address");
            user.phone = object.getString("phone");
            user.website = object.getString("website");
            user.address = Address.createFromJSONObject(object.getJSONObject("address"));
            JSONObject objectCompany = object.getJSONObject("company");
            user.company = objectCompany.getString("name")
                    + objectCompany.getString("catchPhrase");
            return user;
        } catch (Exception e) {
            return null;
        }

    }
    public String getAddress() {
        return address.toString();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
