package com.example.dell.mymusic_hungbk.fragment_child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.mymusic_hungbk.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistsOfOnlineFragment extends Fragment {


    public ArtistsOfOnlineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artists_of_online, container, false);
    }

}
