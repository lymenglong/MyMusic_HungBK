package com.example.dell.mymusic_hungbk.activity_handler_offline;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dell.mymusic_hungbk.MainActivity;
import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.adapter.Custom_ListView_AlbumSong;
import com.example.dell.mymusic_hungbk.bean.SongBean;
import com.example.dell.mymusic_hungbk.bean.UtilsSong;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 15/04/2017.
 */

public class Album_Action extends Activity{
    private ListView listView;
    Custom_ListView_AlbumSong adapter;
    ArrayList<SongBean> listData;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_album_show_list_music);
        init();
    }

    private void init() {
        linearLayout = (LinearLayout)findViewById(R.id.layout_playlistAlbum);
        listView = (ListView)findViewById(R.id.lvArtist_listmusic);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String albumName = getIntent().getStringExtra("album");
        try {
            listData = UtilsSong.getAllAudioByAlbum(albumName,Album_Action.this);

            adapter = new Custom_ListView_AlbumSong(Album_Action.this, listData);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MainActivity.lstSong = listData;
                    MainActivity.OnPlayItemClick(position);
                }
            });
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
