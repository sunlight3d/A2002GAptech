package com.hean.sqlitecrud.database;

import android.provider.BaseColumns;

public class User {

    public static final class UserDetails implements BaseColumns{
        public static final String TABLE_NAME="user";
        public static final String COL_ID="id";
        public static final String COL_NAME="name";
        public static final String COL_EMAIL="email";
        public static final String COL_PHONE="phone";
    }
    private int id;
    private String name;
    private String email;
    private String phone;

    public User(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
