package com.example.dell.mymusic_hungbk.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.bean.SongBean;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 06/05/2017.
 */

public class AdapterSongs extends BaseAdapter {
    private Activity mContext;
    private ArrayList<SongBean> mArraySongs;
    private LayoutInflater inflater;

    public AdapterSongs(ArrayList<SongBean> mArraySongs, Activity mContext) {
        this.mArraySongs = mArraySongs;
        this.mContext = mContext;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mArraySongs.size();
    }

    @Override
    public Object getItem(int position) {
        return mArraySongs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * xay dung phuong thuc tao ra cac item cho listview ung voi moi phan tu cua mang
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) { //neu item ma chua co thi tao moi
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.layout_item_song, null);

            //khoi tao toan bo thanh phan cau

            holder.textViewNameSongs = (TextView) convertView.findViewById(R.id.textViewSongs);
            holder.textViewNameSingser = (TextView) convertView.findViewById(R.id.textViewASinger);
            holder.checkBoxChooseSongs = (CheckBox) convertView.findViewById(R.id.checkSongs);

            //khi da khao tao cho cac view cau tao len item cuar listview roi se luu lai trong viewholder
            convertView.setTag(holder);

        } else { //khong thi se lay ra tu viewholder ma no da duoc luu
            holder = (ViewHolder) convertView.getTag();
        }

        //set gia tri cho cac thanh phan cau tao len item
        //moi phan tu cua mang se duoc tao ra 1 item cua listview
        final SongBean songs = mArraySongs.get(position);
        //set name cho textview
        holder.textViewNameSongs.setText(songs.getMusicName());
        holder.textViewNameSingser.setText(songs.getArtist());

        //fix truong hop da checked, sau do keo len keo xuong bi bo checked
        holder.checkBoxChooseSongs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                songs.setSongsChecked(b);
            }
        });
        holder.checkBoxChooseSongs.setChecked(songs.isSongsChecked());

        return convertView;
    }

    public class ViewHolder {

        public TextView textViewNameSongs;
        public TextView textViewNameSingser;
        public CheckBox checkBoxChooseSongs;

    }
}
