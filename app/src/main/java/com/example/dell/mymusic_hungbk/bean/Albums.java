package com.example.dell.mymusic_hungbk.bean;

/**
 * Created by Hùng ManUNT on 15/04/2017.
 */

public class Albums {
    private String NameAlbum;
    private String NameSongs;
    private String imageAlbum;
    private int Album_ID;

    public Albums(String nameAlbum, String nameSongs, String imageAlbum, int album_ID) {
        NameAlbum = nameAlbum;
        NameSongs = nameSongs;
        this.imageAlbum = imageAlbum;
        Album_ID = album_ID;
    }

    public Albums() {
    }

    public String getNameAlbum() {
        return NameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        NameAlbum = nameAlbum;
    }

    public String getNameSongs() {
        return NameSongs;
    }

    public void setNameSongs(String nameSongs) {
        NameSongs = nameSongs;
    }

    public String getImageAlbum() {
        return imageAlbum;
    }

    public void setImageAlbum(String imageAlbum) {
        this.imageAlbum = imageAlbum;
    }

    public int getAlbum_ID() {
        return Album_ID;
    }

    public void setAlbum_ID(int album_ID) {
        Album_ID = album_ID;
    }
}