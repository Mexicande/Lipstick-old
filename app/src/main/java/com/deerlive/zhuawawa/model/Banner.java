package com.deerlive.zhuawawa.model;

import java.io.Serializable;

/**
 * Created by fengjh on 16/7/31.
 */
public class Banner implements Serializable{

    private String pic;
    private String title;
    private String type;
    private String jump;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", jump='" + jump + '\'' +
                '}';
    }
}
