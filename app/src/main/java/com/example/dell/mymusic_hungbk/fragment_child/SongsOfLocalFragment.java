package com.example.dell.mymusic_hungbk.fragment_child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.adapter.CustomListViewSongLocal;
import com.example.dell.mymusic_hungbk.bean.SongBean;
import com.example.dell.mymusic_hungbk.bean.UtilsSong;
import com.example.dell.mymusic_hungbk.handler.HandlerOnItemClickSongLocal;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsOfLocalFragment extends Fragment {
    ArrayList<SongBean> listData;
    CustomListViewSongLocal adapter;
    ListView lvSongOffline;
    private LinearLayout linearSongSearch;


    public SongsOfLocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_songs_of_local, container, false);
        lvSongOffline = (ListView) V.findViewById(R.id.lvSongsOffline);
        linearSongSearch = (LinearLayout) V.findViewById(R.id.searchSongsOffline);

        //lấy dữ liệu bài hát
        UtilsSong utilsSong = new UtilsSong();
        //lấy bài hát đuôi .mp3
        listData = utilsSong.getAllAudio(".mp3", getActivity());

        adapter = new CustomListViewSongLocal(getActivity(), listData);
        lvSongOffline.setAdapter(adapter);
        lvSongOffline.setOnItemClickListener(new HandlerOnItemClickSongLocal(getActivity(), listData));

        return V;
    }
}

