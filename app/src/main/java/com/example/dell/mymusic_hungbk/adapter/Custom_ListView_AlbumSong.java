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
 * Created by DELL on 15/04/2017.
 */

public class Custom_ListView_AlbumSong extends BaseAdapter {
    private Activity context;
    private LayoutInflater inflater;


    public Custom_ListView_AlbumSong(Activity context, ArrayList<SongBean> listItem) {
        super();
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        MainActivity.lstSong = listItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return MainActivity.lstSong.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return MainActivity.lstSong.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    static class ViewHolder{

        TextView tvArtistsName;
        TextView tvArtistsDescription;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.custom_listview_album_songs, null);


            holder.tvArtistsName = (TextView) convertView.findViewById(R.id.tvAlbumsName);
            holder.tvArtistsDescription = (TextView) convertView.findViewById(R.id.tvAlbumsDescription);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        SongBean song = MainActivity.lstSong.get(position);

        holder.tvArtistsName.setText(song.getMusicName());
        holder.tvArtistsDescription.setText(song.getArtist());

        return convertView;
    }
}
