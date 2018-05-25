package com.example.dell.mymusic_hungbk.bean;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 16/04/2017.
 */

public class UtilsArtist {
    public ArrayList<Artist> getAllAudio(final String endWith, Context context) {
        ArrayList<Artist> arrayArtist = null;
        try {

            Artist objSong;
            arrayArtist = new ArrayList<Artist>();
            Uri uri;
            Cursor mCursor;

            String[] m_data = {
                    MediaStore.Audio.Media.ARTIST,
                    MediaStore.Audio.Media.ARTIST_ID,
                    MediaStore.Audio.Media.ARTIST_KEY,
                    MediaStore.Audio.Media.DISPLAY_NAME,
                    MediaStore.Audio.Media.DATA};

            //Lay danh sach file nhac trong bo nho may
//            uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
//            mCursor = context.getContentResolver().query(uri, null,MediaStore.Audio.Media.IS_MUSIC + " !=0 ", null, null);;
//            boolean check1 = false;
//
//            if (mCursor != null) {
//                for (mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
//                    objSong = new Artist();
//                    objSong.setNameArtist(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)));
//                    //objSong.setDescrip(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
//                    if(arrayArtist.size() > 0){
//                        for(int i=0;i< arrayArtist.size() ;i++){
//                            if(arrayArtist.get(i).getNameArtist().equals(objSong.getNameArtist())){
//                                check1 = true;
//                                break;
//                            }
//                        }
//                        if(!check1){
//                            arrayArtist.add(objSong);
//                        }
//                    }else {
//                        arrayArtist.add(objSong);
//                    }
//                }
//            }
            //Lay danh sach file nhac trong the nho ngoai
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            mCursor = context.getContentResolver().query(uri, null, MediaStore.Audio.Media.IS_MUSIC + " != 0 ", null, null);
            boolean check = false;
            if (mCursor != null) {
                for (mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
                    objSong = new Artist();
                    objSong.setNameArtist(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)));
                    // objSong.setDescrip(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
                    if(arrayArtist.size() > 0){
                        for(int i=0;i <arrayArtist.size(); i++){
                            if(arrayArtist.get(i).getNameArtist().equals(objSong.getNameArtist())){
                                check = true;
                                break;
                            }

                        }
                        if(! check){
                            arrayArtist.add(objSong);
                        }
                    }
                    else {
                        arrayArtist.add(objSong);
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return arrayArtist;
    }
}
