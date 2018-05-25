package com.example.dell.mymusic_hungbk.bean;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;


/**
 * Created by Hùng ManUNT on 17/04/2017.
 */

public class UtilsFolder {
    public ArrayList<Folder> getAllAudio(final String endWith, Context context) {
        ArrayList<Folder> arrayFolder = null;
        try {

            Folder objSong;
            arrayFolder = new ArrayList<Folder>();
            Uri uri;
            Cursor mCursor;

            String[] m_data = {
                    MediaStore.Audio.Media.ARTIST,
                    MediaStore.Audio.Media.DISPLAY_NAME,
                    MediaStore.Audio.Media.DATA};

            //Lay danh sach file nhac trong bo nho may
//            uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
//            mCursor = context.getContentResolver().query(uri, null,MediaStore.Audio.Media.IS_MUSIC + " !=0 ", null, null);;
//            boolean check1 = false;
//
//            if (mCursor != null) {
//                for (mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
//                    objSong = new Folder();
//                    objSong.setNameFolder(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
//                    //objSong.setDescrip(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
//                    if(arrayFolder.size() > 0){
//                        for(int i=0;i< arrayFolder.size() ;i++){
//                            if(arrayFolder.get(i).getNameFolder().equals(objSong.getNameFolder())){
//                                check1 = true;
//                                break;
//                            }
//                        }
//                        if(!check1){
//                            arrayFolder.add(objSong);
//                        }
//                    }else {
//                        arrayFolder.add(objSong);
//                    }
//                }
//            }
            //Lay danh sach file nhac trong the nho ngoai
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            mCursor = context.getContentResolver().query(uri, null, MediaStore.Audio.Media.IS_MUSIC + " != 0 ", null, null);
            boolean check = false;
            if (mCursor != null) {
                for (mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
                    objSong = new Folder();
                    objSong.setNameFolder(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)));
                    objSong.setFullPath(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));

                    if(arrayFolder.size() > 0){
                        for(int i=0;i <arrayFolder.size(); i++){
                            if(arrayFolder.get(i).getNameFolder().equals(objSong.getNameFolder())){
                                check = true;
                                break;
                            }

                        }
                        if(! check){
                            arrayFolder.add(objSong);
                        }
                    }
                    else {
                        arrayFolder.add(objSong);
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return arrayFolder;
    }

}
