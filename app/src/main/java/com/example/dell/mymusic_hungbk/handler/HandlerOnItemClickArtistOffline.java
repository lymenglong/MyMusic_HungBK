package com.example.dell.mymusic_hungbk.handler;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;

import com.example.dell.mymusic_hungbk.activity_handler_offline.Artist_Action;
import com.example.dell.mymusic_hungbk.bean.Artist;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 16/04/2017.
 */

public class HandlerOnItemClickArtistOffline implements AdapterView.OnItemClickListener {
    ArrayList<Artist> list;
    public FragmentActivity fragmentActivity;

    public HandlerOnItemClickArtistOffline(ArrayList<Artist> list, FragmentActivity fragmentActivity) {
        this.list = list;
        this.fragmentActivity = fragmentActivity;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(fragmentActivity, Artist_Action.class);
        intent.putExtra("artist",list.get(position).getNameArtist());
        fragmentActivity.startActivity(intent);
    }
}
