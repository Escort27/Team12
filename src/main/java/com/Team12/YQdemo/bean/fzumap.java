package com.Team12.YQdemo.bean;


public class fzumap {
    private String address;
    private String activity_name;


    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public fzumap(String address, String activity_name) {
        this.address = address;
        this.activity_name = activity_name;
    }
}
