package com.example.dell.mymusic_hungbk.fragment_child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.adapter.CustomListViewArtistOffLine;
import com.example.dell.mymusic_hungbk.bean.Artist;
import com.example.dell.mymusic_hungbk.bean.UtilsArtist;
import com.example.dell.mymusic_hungbk.handler.HandlerOnItemClickArtistOffline;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistsOfLocalFragment extends Fragment {
    private ListView listViewArtist;
    CustomListViewArtistOffLine adapter;
    private ArrayList<Artist> listArtist;
    private FragmentActivity fragmentActivity;


    public ArtistsOfLocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View V = inflater.inflate(R.layout.fragment_artists_of_local, container, false);
        listViewArtist = (ListView)V.findViewById(R.id.listViewArtist);
        UtilsArtist utilsArtist = new UtilsArtist();
        listArtist = utilsArtist.getAllAudio(".mp3",getActivity());
        adapter = new CustomListViewArtistOffLine(getActivity(),listArtist);

        listViewArtist.setAdapter(adapter);
        listViewArtist.setOnItemClickListener(new HandlerOnItemClickArtistOffline(listArtist,getActivity()));

        return V;
    }

}
