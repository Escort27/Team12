package com.example.team12.bean;

public class back_photo {

    //url信息
    private String one_man;
    private String two_man;
    private String three_man;
    private String four_man;

    public String getOne_man() {
        return one_man;
    }

    public void setOne_man(String one_man) {
        this.one_man = one_man;
    }

    public String getTwo_man() {
        return two_man;
    }

    public void setTwo_man(String two_man) {
        this.two_man = two_man;
    }

    public String getThree_man() {
        return three_man;
    }

    public void setThree_man(String three_man) {
        this.three_man = three_man;
    }

    public String getFour_man() {
        return four_man;
    }

    public void setFour_man(String four_man) {
        this.four_man = four_man;
    }

    public back_photo(String one_man, String two_man, String three_man, String four_man) {
        this.one_man = one_man;
        this.two_man = two_man;
        this.three_man = three_man;
        this.four_man = four_man;
    }
}
