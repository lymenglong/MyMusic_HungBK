package com.example.dell.mymusic_hungbk.service;

import android.content.Context;

import com.example.dell.mymusic_hungbk.bean.UtilsSong;

// điều khiển chức năng của nhạc
public class Controls {

    static String LOG_CLASS = "Controls";
    public static void playControl(Context context) {
        sendMessage("Play");
    }

    public static void pauseControl(Context context) {
        sendMessage("Pause");
    }

    public static void nextControl(Context context) {
        boolean isServiceRunning = UtilsSong.isServiceRunning(SongService.class.getName(), context);
        if (!isServiceRunning)
            return;
        if(PlayerConstants.SONGS_LIST.size() > 0 ){
            if(PlayerConstants.SONG_NUMBER < (PlayerConstants.SONGS_LIST.size()-1)){
                PlayerConstants.SONG_NUMBER++;
                PlayerConstants.SONG_CHANGE_HANDLER.sendMessage(PlayerConstants.SONG_CHANGE_HANDLER.obtainMessage());
            }else{
                PlayerConstants.SONG_NUMBER = 0;
                PlayerConstants.SONG_CHANGE_HANDLER.sendMessage(PlayerConstants.SONG_CHANGE_HANDLER.obtainMessage());
            }
        }
        PlayerConstants.SONG_PAUSED = false;
    }

    public static void previousControl(Context context) {
        boolean isServiceRunning = UtilsSong.isServiceRunning(SongService.class.getName(), context);
        if (!isServiceRunning)
            return;
        if(PlayerConstants.SONGS_LIST.size() > 0 ){
            if(PlayerConstants.SONG_NUMBER > 0){
                PlayerConstants.SONG_NUMBER--;
                PlayerConstants.SONG_CHANGE_HANDLER.sendMessage(PlayerConstants.SONG_CHANGE_HANDLER.obtainMessage());
            }else{
                PlayerConstants.SONG_NUMBER = PlayerConstants.SONGS_LIST.size() - 1;
                PlayerConstants.SONG_CHANGE_HANDLER.sendMessage(PlayerConstants.SONG_CHANGE_HANDLER.obtainMessage());
            }
        }
        PlayerConstants.SONG_PAUSED = false;
    }

    private static void sendMessage(String message) {
        try{
            PlayerConstants.PLAY_PAUSE_HANDLER.sendMessage(PlayerConstants.PLAY_PAUSE_HANDLER.obtainMessage(0, message));
        }catch(Exception e){}
    }
}
