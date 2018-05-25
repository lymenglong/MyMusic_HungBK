package com.example.dell.mymusic_hungbk.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.mymusic_hungbk.MainActivity;
import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.bean.SongBean;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 17/04/2017.
 */

public class Custom_listview_FolderSongs extends BaseAdapter {
    private Activity context;
    private LayoutInflater inflater;


    public Custom_listview_FolderSongs(Activity context, ArrayList<SongBean> data) {
        super();
        this.context = context;

        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        MainActivity.lstSong = data;
    }

    @Override
    public int getCount() {
        return MainActivity.lstSong.size();
    }

    @Override
    public Object getItem(int position) {
        return MainActivity.lstSong.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder{
        public TextView NameSongs;
//        public TextView NameSinger;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Custom_listview_ArtistSongs.ViewHolder holder;
        if(convertView == null){
            holder = new Custom_listview_ArtistSongs.ViewHolder();
            convertView = inflater.inflate(R.layout.custom_listview_folder_songs,null);

            holder.NameSongs = (TextView) convertView.findViewById(R.id.tvFolderNameSong);
            holder.NameSinger = (TextView) convertView.findViewById(R.id.tvArtistsDescriptionSong);

            convertView.setTag(holder);
        }
        else {
            holder = (Custom_listview_ArtistSongs.ViewHolder)convertView.getTag();
        }
        SongBean foldersSongs = MainActivity.lstSong.get(position);
        holder.NameSongs.setText(foldersSongs.getMusicName());
        holder.NameSinger.setText(foldersSongs.getArtist());
        return convertView;
    }
}
