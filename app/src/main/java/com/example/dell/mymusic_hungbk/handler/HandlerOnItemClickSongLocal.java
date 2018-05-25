package com.example.dell.mymusic_hungbk.handler;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.dell.mymusic_hungbk.MainActivity;
import com.example.dell.mymusic_hungbk.bean.SongBean;

import java.util.ArrayList;

/**
 * Created by Hùng ManUnt on 23/03/2017.
 */
// điều khiển luồng
public class HandlerOnItemClickSongLocal implements AdapterView.OnItemClickListener {
    private FragmentActivity fragmentActivity;
//    PlayMusicOnline playMusic;


    public HandlerOnItemClickSongLocal(FragmentActivity fragmentActivity,ArrayList<SongBean> listData) {
        this.fragmentActivity = fragmentActivity;
        MainActivity.lstSong = listData;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("ERROR", MainActivity.lstSong.get(i).getLink());
         MainActivity.OnPlayItemClick(i);
    }
}
