package com.example.dell.mymusic_hungbk.handler;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;

import com.example.dell.mymusic_hungbk.activity_handler_offline.Album_Action;
import com.example.dell.mymusic_hungbk.bean.Albums;

import java.util.ArrayList;

/**
 * Created by Hùng manUNT on 15/04/2017.
 */

public class HandlerOnItemClickAlbumOffline implements AdapterView.OnItemClickListener {

    ArrayList<Albums> mlistData;
    private FragmentActivity fragmentActivity;

    public HandlerOnItemClickAlbumOffline(FragmentActivity activity, ArrayList<Albums> listAlbum) {
        this.fragmentActivity = activity;
        this.mlistData = listAlbum;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(fragmentActivity, Album_Action.class);
        intent.putExtra("album",mlistData.get(position).getNameAlbum());
        fragmentActivity.startActivity(intent);
    }
}
