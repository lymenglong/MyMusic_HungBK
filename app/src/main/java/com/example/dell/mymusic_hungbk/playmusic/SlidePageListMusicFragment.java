package com.example.dell.mymusic_hungbk.playmusic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.dell.mymusic_hungbk.MainActivity;
import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.adapter.CustomListViewSong;
import com.example.dell.mymusic_hungbk.bean.SongBean;
import com.example.dell.mymusic_hungbk.bean.UtilsSong;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlidePageListMusicFragment extends Fragment {
    ArrayList<SongBean> listData;
    CustomListViewSong adapter;
    ListView listView;
    ImageButton btnHide1;


    public SlidePageListMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(R.layout.fragment_playmusic_listmusic, container, false);

        listView = (ListView) rootView.findViewById(R.id.lvShowMusic);

        //lấy dữ liệu bài hát
        UtilsSong utilsSong = new UtilsSong();
        //lấy bài hát đuôi .mp3
        listData = utilsSong.getAllAudio(".mp3", getActivity());
        adapter = new CustomListViewSong(getActivity(), listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.lstSong = listData;
                MainActivity.OnPlayItemClick(position);
            }
        });


        btnHide1 = (ImageButton) rootView.findViewById(R.id.btnHide2);
        btnHide1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return rootView;
    }

}
