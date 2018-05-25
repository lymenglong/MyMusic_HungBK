package com.example.dell.mymusic_hungbk.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.bean.Folder;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 17/04/2017.
 */

public class CustomListViewFolderOffLine extends BaseAdapter {
    private Activity context;
    private LayoutInflater inflater;
    private ArrayList<Folder> listItem;

    public CustomListViewFolderOffLine(Activity context, ArrayList<Folder> listItem) {
        this.context = context;
        this.listItem = listItem;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder{

        TextView textViewNameFolderOff;
        TextView textViewFullPathOff;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.custom_listview_folder_offline,null);

            holder.textViewFullPathOff = (TextView) convertView.findViewById(R.id.tvfullPathOff);
            holder.textViewNameFolderOff = (TextView) convertView.findViewById(R.id.tvFolderNameOff);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Folder folder = listItem.get(position);
        holder.textViewNameFolderOff.setText(folder.getNameFolder());
        holder.textViewFullPathOff.setText(folder.getFullPath());

        return convertView;
    }
}
