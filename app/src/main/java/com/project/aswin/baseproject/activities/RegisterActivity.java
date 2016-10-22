package com.project.aswin.baseproject.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.project.aswin.baseproject.R;
import com.project.aswin.baseproject.base.BaseActivity;

/**
 * Created by Aswin on 10/22/2016.
 */

public class RegisterActivity extends BaseActivity {

    //xml objects
    Toolbar toolbar;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.appbar_title);
        toolbarTitle.setText("Title");
    }
}
