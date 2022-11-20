package com.example.team12.bean;

public class campus_scenery {
    String pic_url;
    int thumbs_up;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getThumbs_up() {
        return thumbs_up;
    }

    public void setThumbs_up(int thumbs_up) {
        this.thumbs_up = thumbs_up;
    }

    public campus_scenery(String pic_url, int thumbs_up) {
        this.pic_url = pic_url;
        this.thumbs_up = thumbs_up;
    }
}
