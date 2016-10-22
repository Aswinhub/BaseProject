package com.project.aswin.baseproject.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Aswin on 10/21/2016.
 */

public class BaseActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    AlertDialog dia;
    ProgressBar progressBar;

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public final static boolean ispasswordmatch(CharSequence password, CharSequence repassword) {
        if (password.equals(repassword)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(BaseActivity.this);
    }

    public void showProgressDialog(String title, String message, boolean isCancellable) {

        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(isCancellable);
        progressDialog.show();

    }

    public void showProgressDialog(String message, boolean isCancellable) {

        progressDialog.setMessage(message);
        progressDialog.setCancelable(isCancellable);
        progressDialog.show();

    }

    public void progressDialogDismiss() {
        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

    public void showToast(String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String title, String message) {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(BaseActivity.this);
        builder1.setTitle(title);
        builder1.setMessage(message);
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void snack(String message) {
        //all parent layout id should be snack
        // Snackbar.make(findViewById(R.id.snack), message, Snackbar.LENGTH_LONG).show();
    }


    public void logD(String logMessage) {
        if (logMessage == null) {
            Log.d("BaseActivityLog", "");

        } else {
            Log.d("BaseActivityLog", logMessage);

        }
    }

    public Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

}
