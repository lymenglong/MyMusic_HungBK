package com.example.dell.mymusic_hungbk;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dell.mymusic_hungbk.bean.SongBean;
import com.example.dell.mymusic_hungbk.bean.UtilsSong;
import com.example.dell.mymusic_hungbk.playmusic.PlaySlidePagerActivity;
import com.example.dell.mymusic_hungbk.service.Controls;
import com.example.dell.mymusic_hungbk.service.PlayerConstants;
import com.example.dell.mymusic_hungbk.service.SongService;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static Context context;

    static TextView tvMusicSinger;
    static TextView tvMusicName;

    public static List<SongBean> lstSong;

    static ImageButton btnPlay;
    static ImageButton btnNext;
    static ImageButton btnBack;
    static ImageButton btnPause;
    static ImageButton btnDelete;

    static ImageView imgvSong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
//        imgvSong = (ImageView)findViewById(R.id.imgvSong);
//        imgvSong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), PlaySlidePagerActivity.class);
//                startActivity(intent);
//            }
//        });
        getViews();
        setListeners();
        setupTabIcons();
        context = this;

    }
    private void setupTabIcons() {

        TextView tabHome = (TextView) LayoutInflater.from(this).inflate(R.layout.tabs_navigation, null);
        tabHome.setText("Của tui");
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.img_tabs_home, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabHome);

        TextView tabLocal = (TextView) LayoutInflater.from(this).inflate(R.layout.tabs_navigation, null);
        tabLocal.setText("Thiết bị");
        tabLocal.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.img_tabs_local, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabLocal);

        TextView tabOnline = (TextView) LayoutInflater.from(this).inflate(R.layout.tabs_navigation, null);
        tabOnline.setText("Online");
        tabOnline.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.img_tabs_online, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabOnline);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "Của tui");
        adapter.addFrag(new LocalFragment(), "Thiết bị");
        adapter.addFrag(new OnlineFragment(), "Online");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exitByBackKey() {
        new AlertDialog.Builder(this)
                .setMessage ("Bạn có muốn thoát khỏi ứng dụng ?")
                .setPositiveButton ("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                })
                .setNegativeButton ("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }

//update minibar
    public static void updateUI() {
        try {
            SongBean data = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER);
            tvMusicName.setText(data.getMusicName() + " " + data.getArtist() + "-" + data.getAlbumName());
            tvMusicSinger.setText(data.getAlbumName());
            Bitmap albumArt = UtilsSong.getAlbumart(context, data.getAlbum_ID());
            if (albumArt != null) {
                imgvSong.setBackgroundDrawable(new BitmapDrawable(albumArt));
            } else {
                imgvSong.setBackgroundDrawable(new BitmapDrawable(UtilsSong.getDefaultAlbumArt(context)));
            }
        } catch (Exception e) {
        }
    }

    public static void OnPlayItemClick(int position) {
        Log.d("TAG", "TAG Tapped INOUT(IN)");

        try{
            PlayerConstants.SONGS_LIST = MainActivity.lstSong;
            PlayerConstants.SONG_PAUSED = false;
            PlayerConstants.SONG_NUMBER = position;
            boolean isServiceRunning = UtilsSong.isServiceRunning(SongService.class.getName(), context.getApplicationContext());
            if (!isServiceRunning) {
                Intent i = new Intent(context.getApplicationContext(), SongService.class);
                context.startService(i);
            } else {
                PlayerConstants.SONG_CHANGE_HANDLER.sendMessage(PlayerConstants.SONG_CHANGE_HANDLER.obtainMessage());
            }
            updateUI();
            changeButton();
            Log.d("TAG", "TAG Tapped INOUT(OUT)");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
// khi click vào play or pause
    public static void changeButton() {
        if (PlayerConstants.SONG_PAUSED) {
            btnPause.setVisibility(View.GONE);
            btnPlay.setVisibility(View.VISIBLE);
        } else {
            btnPause.setVisibility(View.VISIBLE);
            btnPlay.setVisibility(View.GONE);
        }
    }
// giao diện người dùng
    public static void changeUI() {
        updateUI();
        changeButton();
    }

    private void setListeners() {

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controls.playControl(context.getApplicationContext());
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controls.pauseControl(context.getApplicationContext());
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Controls.nextControl(context.getApplicationContext());
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Controls.previousControl(context.getApplicationContext());
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(), SongService.class);
                stopService(i);
                //linearLayoutPlayingSong.setVisibility(View.GONE);
            }
        });
        //play minibar
        imgvSong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PlaySlidePagerActivity.class);
                startActivity(i);
            }
        });
    }

    private void getViews() {
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnPause = (ImageButton) findViewById(R.id.btnPause);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnDelete = (ImageButton) findViewById(R.id.btnDelete);
        tvMusicSinger = (TextView) findViewById(R.id.tvMusicSinger);
        tvMusicName = (TextView) findViewById(R.id.tvMusicName);
        imgvSong = (ImageView) findViewById(R.id.imgvSong);
    }

}
