package com.dwiputri.greatfood;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.dwiputri.greatfood.SQLite.Login;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView image = (ImageView) findViewById(R.id.imageView);
                android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                image.startAnimation(animation1);
                final Intent mainIntent = new Intent(getApplicationContext(),
                        Login.class);
                startActivity(mainIntent);
                finish();
            }
        }, 3000); //delay 3 detik
    }
}
