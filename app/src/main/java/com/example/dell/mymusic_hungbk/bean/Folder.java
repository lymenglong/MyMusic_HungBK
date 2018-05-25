package com.example.dell.mymusic_hungbk.bean;

import android.graphics.Bitmap;

/**
 * Created by DELL on 17/04/2017.
 */

public class Folder {
    private String NameFolder;
    private String fullPath;

    public Folder() {
    }

    public Folder(String nameFolder, String fullPath) {
        NameFolder = nameFolder;
        this.fullPath = fullPath;
    }

    public String getNameFolder() {
        return NameFolder;
    }

    public void setNameFolder(String nameFolder) {
        NameFolder = nameFolder;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }
}
