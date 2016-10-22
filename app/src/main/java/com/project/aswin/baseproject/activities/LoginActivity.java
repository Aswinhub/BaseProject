package com.project.aswin.baseproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project.aswin.baseproject.R;
import com.project.aswin.baseproject.base.BaseActivity;

/**
 * Created by Aswin on 10/22/2016.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    //xml objects
    EditText etUsername, etPassword;
    Button btLogin;
    TextView tvRegister;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.appbar_title);
        toolbarTitle.setText("Title");

        initialize();
    }

    private void initialize() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvRegister = (TextView) findViewById(R.id.tv_register);

        btLogin = (Button) findViewById(R.id.bt_login);

        initializeOnclick();
    }

    private void initializeOnclick() {
        btLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                break;
            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }
}
