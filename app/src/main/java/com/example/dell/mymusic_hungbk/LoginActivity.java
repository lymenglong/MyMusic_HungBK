package com.example.dell.mymusic_hungbk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends Activity {
    private Button close;
    private ImageButton login_facebook,login_google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        close = (Button) findViewById(R.id.Bt_close);
        login_facebook = (ImageButton) findViewById(R.id.login_facebook);
        login_google = (ImageButton) findViewById(R.id.login_google);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, HomeFragment.class);
                finish();
            }
        });

        login_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.facebook.com/ "));
                startActivity(i);
            }
        });
        login_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://plus.google.com/u/0/collections/ "));
                startActivity(i);
            }
        });

    }
}
