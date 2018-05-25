package com.example.dell.mymusic_hungbk.fragment_child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.adapter.CustomListViewFolderOffLine;
import com.example.dell.mymusic_hungbk.bean.Folder;
import com.example.dell.mymusic_hungbk.bean.UtilsFolder;
import com.example.dell.mymusic_hungbk.handler.HandlerOnItemClickFolderOffline;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoldersOfLocalFragment extends Fragment {
    private ListView listViewFolder;
    CustomListViewFolderOffLine adapter;
    private ArrayList<Folder> listFolder;
    private FragmentActivity fragmentActivity;

    public FoldersOfLocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View V = inflater.inflate(R.layout.fragment_folders_of_local, container, false);
        listViewFolder = (ListView)V.findViewById(R.id.listViewArtist);
        UtilsFolder utilsfolder = new UtilsFolder();
        listFolder = utilsfolder.getAllAudio(".mp3",getActivity());
        adapter = new CustomListViewFolderOffLine(getActivity(),listFolder);

        listViewFolder.setAdapter(adapter);
        listViewFolder.setOnItemClickListener(new HandlerOnItemClickFolderOffline(listFolder,getActivity()));

        return V;
    }

}
