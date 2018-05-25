package com.example.dell.mymusic_hungbk;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.mymusic_hungbk.fragment_child.AlbumsOfLocalFragment;
import com.example.dell.mymusic_hungbk.fragment_child.ArtistsOfLocalFragment;
import com.example.dell.mymusic_hungbk.fragment_child.FoldersOfLocalFragment;
import com.example.dell.mymusic_hungbk.fragment_child.SongsOfLocalFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocalFragment extends Fragment {

    private FragmentTabHost tabHost;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        tabHost = new FragmentTabHost(getActivity());
        tabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_local);

        tabHost.addTab(tabHost.newTabSpec("song").setIndicator(this.getTabIndicator(tabHost.getContext(),R.string.title_tabs_local_one)), SongsOfLocalFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("album").setIndicator(this.getTabIndicator(tabHost.getContext(),R.string.title_tabs_local_two)), AlbumsOfLocalFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("artist").setIndicator(this.getTabIndicator(tabHost.getContext(),R.string.title_tabs_local_three)), ArtistsOfLocalFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("folder").setIndicator(this.getTabIndicator(tabHost.getContext(),R.string.title_tabs_local_four)), FoldersOfLocalFragment.class, null);

        return tabHost;
    }
    private View getTabIndicator(Context context, int title) {
        View view = LayoutInflater.from(context).inflate(R.layout.tabs_child_navigation, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_nav);
        tv.setText(title);
        return view;
    }
}
