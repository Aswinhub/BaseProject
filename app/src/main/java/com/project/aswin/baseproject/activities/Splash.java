package com.project.aswin.baseproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.project.aswin.baseproject.R;
import com.project.aswin.baseproject.base.BaseActivity;

/**
 * Created by Aswin on 10/22/2016.
 */

public class Splash extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, LoginActivity.class));
            }
        }, 3000);
    }
}
