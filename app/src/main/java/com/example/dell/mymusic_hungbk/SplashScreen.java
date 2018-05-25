package com.example.dell.mymusic_hungbk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Hùng ManUNT on 10/04/2017.
 */
public class SplashScreen extends Activity {
    static private int SPLASH_TIME = 4000;
    private TextView secretTextviewSplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //put the splash screen into full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        bindView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //Finish the splash activity so it can't be returned to.
                SplashScreen.this.finish();
                // Create an Intent that will start the main activity.
                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);
                //overridePendingTransition(R.anim.bottom_in,R.anim.top_out);
            }
        }, SPLASH_TIME);

    }
    private void bindView() {
        secretTextviewSplash = (TextView) findViewById(R.id.secret_textview_splash);

        String customHtml = getString(R.string.text_splash);

        secretTextviewSplash.setText(Html.fromHtml(customHtml));
        secretTextviewSplash.startAnimation(AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade_in));
    }
}
