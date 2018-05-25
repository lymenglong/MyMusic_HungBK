package com.example.dell.mymusic_hungbk.bean;

import android.graphics.Bitmap;

/**
 * Created by Hùng ManUNT on 16/04/2017.
 */

public class Artist {
    private Bitmap imageArtist;
    private String NameArtist;
    private String descrip;

    public Artist() {
    }

    public Artist(Bitmap imageArtist, String nameArtist, String descrip) {
        this.imageArtist = imageArtist;
        NameArtist = nameArtist;
        this.descrip = descrip;
    }

    public Bitmap getImageArtist() {
        return imageArtist;
    }

    public void setImageArtist(Bitmap imageArtist) {
        this.imageArtist = imageArtist;
    }

    public String getNameArtist() {
        return NameArtist;
    }

    public void setNameArtist(String nameArtist) {
        NameArtist = nameArtist;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
