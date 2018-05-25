package com.example.dell.mymusic_hungbk;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.dell.mymusic_hungbk.mymusic_tab_home.List_PlayList;
import com.example.dell.mymusic_hungbk.mymusic_tab_home.List_Song;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private LinearLayout ll_vip, ll_other_app, ll_playlist,ll_song;
    private TextView txv_login_home;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_home, container, false);

        txv_login_home = (TextView) V.findViewById(R.id.txv_login);
        ll_vip = (LinearLayout) V.findViewById(R.id.vip);
        ll_other_app = (LinearLayout) V.findViewById(R.id.other_app);
        ll_song = (LinearLayout) V.findViewById(R.id.baihat);
        ll_playlist = (LinearLayout) V.findViewById(R.id.layout_playlistOffline);

        txv_login_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });

        ll_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });
        ll_other_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store?hl=vi "));
                startActivity(i);
            }
        });
        ll_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), List_PlayList.class);
                getActivity().startActivity(i);

            }
        });
        ll_song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), List_Song.class);
                getActivity().startActivity(i);
            }
        });

        return V;
    }

}
