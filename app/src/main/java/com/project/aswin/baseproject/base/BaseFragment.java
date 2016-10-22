package com.project.aswin.baseproject.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by Aswin on 10/21/2016.
 */

public class BaseFragment extends Fragment {
    ProgressDialog progressDialog;

    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
    }

    public void showProgressDialog(String message, boolean isCancellable) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(message);
        progressDialog.setCancelable(isCancellable);
        progressDialog.show();
    }

    public void progressDialogDismiss() {
        progressDialog = new ProgressDialog(getActivity());
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();

    }
}
