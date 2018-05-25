package com.example.dell.mymusic_hungbk.activity_handler_offline;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dell.mymusic_hungbk.MainActivity;
import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.adapter.Custom_listview_ArtistSongs;
import com.example.dell.mymusic_hungbk.adapter.Custom_listview_FolderSongs;
import com.example.dell.mymusic_hungbk.bean.Folder;
import com.example.dell.mymusic_hungbk.bean.SongBean;
import com.example.dell.mymusic_hungbk.bean.UtilsSong;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 17/04/2017.
 */

public class Folder_Action extends Activity{
    private ListView listView;
    Custom_listview_FolderSongs adapter;
    ArrayList<SongBean> listData;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_folder_showlist_songs);
        init();
    }
    public  void init(){
        linearLayout = (LinearLayout)findViewById(R.id.layout_playlistFolder);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView = (ListView)findViewById(R.id.listSongsFolder);
        String folderName = getIntent().getStringExtra("folder");
        try{
            listData = UtilsSong.getAllAudioByAlbum(folderName,Folder_Action.this);
            adapter = new Custom_listview_FolderSongs(Folder_Action.this,listData);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MainActivity.lstSong = listData;
                    MainActivity.OnPlayItemClick(position);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
