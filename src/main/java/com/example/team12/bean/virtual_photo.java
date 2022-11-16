package com.example.team12.bean;

public class virtual_photo {
    private String user_name;
    private String virtual_combination;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getVirtual_combination() {
        return virtual_combination;
    }

    public void setVirtual_combination(String virtual_combination) {
        this.virtual_combination = virtual_combination;
    }

    public virtual_photo(String user_name, String virtual_combination) {
        this.user_name = user_name;
        this.virtual_combination = virtual_combination;
    }
}
