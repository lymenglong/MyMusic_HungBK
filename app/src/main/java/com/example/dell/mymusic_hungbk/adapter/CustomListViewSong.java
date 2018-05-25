package com.example.dell.mymusic_hungbk.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.bean.SongBean;
import com.example.dell.mymusic_hungbk.bean.UtilsSong;

import java.util.ArrayList;

/**
 * Created by Hùng ManUNT on 24/04/2017.
 */

public class CustomListViewSong extends BaseAdapter{
    UtilsSong utilsSong = new UtilsSong();
    private Activity context;
    private LayoutInflater inflater;
    private ArrayList<SongBean> listItem;

    public CustomListViewSong(Activity context, ArrayList<SongBean> listItem) {
        super();
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listItem = listItem;
    }
    // đếm số phần tử trong mảng arraylist
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listItem.size();
    }
    // lấy ra 1 vị trí item
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    /**
     * do khi cuộn lên, cuộn xuống các item sẽ đc tạo ra mới, neu dieu nay
     * xay ra nhieu lan thi he thong se ton rat nhieu bo nho cho listview
     * và sẽ gây ra hiện tượng giật màn hình,  trường hợp xấu có thể bị force close
     * Do đó ng ta sẽ dùng 1 class ViewHold để lưu những view (những item cuar listview) đã
     * tạo ra, khi item đó ấn thì view đó sẽ đc lưu lại, lần sau hiển thị sẽ đc lấy ra mà không
     * cần tạo mới
     */
    static class ViewHolder {
        //itemt cua list view duoc cau tao boi cac view nao thi se khai bao tai day
//        ImageView imgArtists;
        TextView tvArtistsName;
        TextView tvArtistsDescription;

    }
    //hàm hiện thị từng item lên listview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        CustomListViewSongLocal.ViewHolder holder;
        //lấy layout cho từng item
        if (convertView == null) {
            holder = new CustomListViewSongLocal.ViewHolder();
            convertView = inflater.inflate(R.layout.custom_listview_slidepager_playlist, null);

            //khoi tao toan bo thanh phan cau.........//lấy các ImageView,textview trong mỗi view
//            holder.imgArtists = (ImageView) convertView.findViewById(R.id.imgArtists);
            holder.tvArtistsName = (TextView) convertView.findViewById(R.id.textViewSongs);
            holder.tvArtistsDescription = (TextView) convertView.findViewById(R.id.textViewASinger);

            convertView.setTag(holder);
        } else {
            holder = (CustomListViewSongLocal.ViewHolder) convertView.getTag();
        }

        SongBean songLocal = listItem.get(position);

        if (songLocal != null){
            holder.tvArtistsName.setText(songLocal.getMusicName());
            holder.tvArtistsDescription.setText(songLocal.getArtist());
//            holder.imgArtists.setImageBitmap(songLocal.getAlbumImage());

        }
        return convertView;
    }
}
