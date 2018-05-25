package com.example.dell.mymusic_hungbk.handler;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;

import com.example.dell.mymusic_hungbk.activity_handler_offline.Folder_Action;
import com.example.dell.mymusic_hungbk.bean.Folder;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 17/04/2017.
 */

public class HandlerOnItemClickFolderOffline implements AdapterView.OnItemClickListener{
    ArrayList<Folder> list;
    public FragmentActivity fragmentActivity;

    public HandlerOnItemClickFolderOffline(ArrayList<Folder> list, FragmentActivity fragmentActivity) {
        this.list = list;
        this.fragmentActivity = fragmentActivity;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(fragmentActivity, Folder_Action.class);
        intent.putExtra("folder",list.get(position).getNameFolder());
        fragmentActivity.startActivity(intent);
    }
}
