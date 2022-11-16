package com.example.team12.bean;

public class user_photo {
    private String user_name;
    private String userpicture_address;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUserpicture_address() {
        return userpicture_address;
    }

    public void setUserpicture_address(String userpicture_address) {
        this.userpicture_address = userpicture_address;
    }

    public user_photo(String user_name, String userpicture_address) {
        this.user_name = user_name;
        this.userpicture_address = userpicture_address;
    }
}
