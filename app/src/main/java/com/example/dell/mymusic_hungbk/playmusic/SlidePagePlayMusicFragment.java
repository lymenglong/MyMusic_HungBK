package com.example.dell.mymusic_hungbk.playmusic;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dell.mymusic_hungbk.R;
import com.example.dell.mymusic_hungbk.bean.UtilsSong;
import com.example.dell.mymusic_hungbk.service.Controls;
import com.example.dell.mymusic_hungbk.service.PlayerConstants;
import com.example.dell.mymusic_hungbk.service.SongService;



public class SlidePagePlayMusicFragment extends Fragment {

    ImageButton btnHide;
    ImageButton btnBack;
    static ImageButton btnPause;
    ImageButton btnNext;
    static ImageButton btnPlay;
    ImageButton btnShuffle;
    ImageButton btnRepeat;

    private boolean isShuffle = false;
    private boolean isRepeat = false;

    static TextView textNowPlaying;
    static TextView textAlbumArtist;
    static TextView textComposer;
    SeekBar seekBar;
    static Context context;
    TextView textBufferDuration, textDuration;


    public SlidePagePlayMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(R.layout.fragment_playmusic_play, container, false);
        getViews(rootView);
        init();

        return rootView;

    }

    private void init() {

        setListeners();
        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        PlayerConstants.PROGRESSBAR_HANDLER = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Integer i[] = (Integer[]) msg.obj;
                textBufferDuration.setText(UtilsSong.getDuration(i[0]));
                textDuration.setText(UtilsSong.getDuration(i[1]));
                seekBar.setProgress(i[2]);
            }
        };
    }

    private void setListeners() {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controls.previousControl(getActivity());
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controls.pauseControl(getActivity());
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Controls.playControl(getActivity());
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controls.nextControl(getActivity());
            }
        });

        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        //nút Lặp lại
        btnRepeat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(isRepeat){
                    isRepeat = false;
                    Toast.makeText(getActivity(), "Repeat is OFF", Toast.LENGTH_SHORT).show();
                    btnRepeat.setImageResource(R.drawable.btn_equalizer);
                }else{
                    // make repeat to true...làm lại cho đúng
                    isRepeat = true;
                    Toast.makeText(getActivity(), "Repeat is ON", Toast.LENGTH_SHORT).show();
                    // make shuffle to false...làm xáo trộn để sai
                    isShuffle = false;
                    btnRepeat.setImageResource(R.drawable.btn_repeat_focused);
                    btnShuffle.setImageResource(R.drawable.btn_shuffle);
                }
            }
        });

       //nút xáo trộn
        btnShuffle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(isShuffle){
                    isShuffle = false;
                    Toast.makeText(getActivity(), "Shuffle is OFF", Toast.LENGTH_SHORT).show();
                    btnShuffle.setImageResource(R.drawable.btn_shuffle);
                }else{
                    // make repeat to true...làm lại cho đúng
                    isShuffle= true;
                    Toast.makeText(getActivity(), "Shuffle is ON", Toast.LENGTH_SHORT).show();
                    // make shuffle to false...làm xáo trộn để sai
                    isRepeat = false;
                    btnShuffle.setImageResource(R.drawable.btn_shuffle_focused);
                    btnRepeat.setImageResource(R.drawable.btn_equalizer);
                }
            }
        });

    }

    public static void changeUI() {
        updateUI();
        changeButton();
    }

    private void getViews(View view) {
        btnHide = (ImageButton) view.findViewById(R.id.btnHide);
        btnBack = (ImageButton) view.findViewById(R.id.Previous);
        btnPause = (ImageButton) view.findViewById(R.id.Pause);
        btnNext = (ImageButton) view.findViewById(R.id.Next);
        btnPlay = (ImageButton) view.findViewById(R.id.Play);
        textNowPlaying = (TextView) view.findViewById(R.id.tvSongTitle);
        textAlbumArtist = (TextView) view.findViewById(R.id.tvNameArtist);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        textBufferDuration = (TextView) view.findViewById(R.id.tvSecbarStart);
        textDuration = (TextView) view.findViewById(R.id.tvSecbarEnd);
        textNowPlaying.setSelected(true);
        textAlbumArtist.setSelected(true);
        btnShuffle = (ImageButton) view.findViewById(R.id.btnShuffle);
        btnRepeat = (ImageButton) view.findViewById(R.id.btnRepeat);

    }

    @Override
    public void onResume() {
        super.onResume();
        boolean isServiceRunning = UtilsSong.isServiceRunning(SongService.class.getName(), getActivity());
        if (isServiceRunning) {
            updateUI();
        }
        changeButton();
    }

    public static void changeButton() {
        if (PlayerConstants.SONG_PAUSED) {
            btnPause.setVisibility(View.GONE);
            btnPlay.setVisibility(View.VISIBLE);
        } else {
            btnPause.setVisibility(View.VISIBLE);
            btnPlay.setVisibility(View.GONE);
        }
    }

    private static void updateUI() {
        try {
            String songName = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getMusicName();
            String artist = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getArtist();
            String album = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getAlbumName();
            String composer = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getComposerName();
            textNowPlaying.setText(songName);
            textAlbumArtist.setText(artist + " - " + album);
            if (composer != null && composer.length() > 0) {
                textComposer.setVisibility(View.VISIBLE);
                textComposer.setText(composer);
            } else {
                textComposer.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            long albumId = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getAlbum_ID();
            Bitmap albumArt = UtilsSong.getAlbumart(context, albumId);
            if (albumArt != null) {

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
