package com.example.team12.bean;

public class campus_scenery {
    String pic_url;
    int thumbs_up;
    int flag;

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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public campus_scenery(String pic_url, int thumbs_up, int flag) {
        this.pic_url = pic_url;
        this.thumbs_up = thumbs_up;
        this.flag = flag;
    }
}
