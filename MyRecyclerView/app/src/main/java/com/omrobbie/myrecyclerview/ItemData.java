package com.omrobbie.myrecyclerview;

/**
 * Created by omrobbie on 04/02/2018.
 */

public class ItemData {

    private int avatar;
    private String judul;
    private String content;

    public ItemData(int avatar, String judul, String content) {
        this.avatar = avatar;
        this.judul = judul;
        this.content = content;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
