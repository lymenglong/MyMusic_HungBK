package com.example.dell.mymusic_hungbk.fragment_child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.adapter.CustomListViewAlbumOffline;
import com.example.dell.mymusic_hungbk.bean.Albums;
import com.example.dell.mymusic_hungbk.bean.UtilsAlbum;
import com.example.dell.mymusic_hungbk.handler.HandlerOnItemClickAlbumOffline;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumsOfLocalFragment extends Fragment {
    private ListView listViewAlbum;
    CustomListViewAlbumOffline adapter;
    private ArrayList<Albums> listAlbum1;
    private FragmentActivity fragmentActivity;

    public AlbumsOfLocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_albums_of_local, container, false);
        listViewAlbum = (ListView)V.findViewById(R.id.listAlbum);
        UtilsAlbum utilsAlbum = new UtilsAlbum();

        listAlbum1 = utilsAlbum.getAllAudio(".mp3",getActivity());
        adapter = new CustomListViewAlbumOffline(getActivity(),listAlbum1);
        listViewAlbum.setAdapter(adapter);
        listViewAlbum.setOnItemClickListener(new HandlerOnItemClickAlbumOffline(getActivity(),listAlbum1));
        return V;
    }

}
