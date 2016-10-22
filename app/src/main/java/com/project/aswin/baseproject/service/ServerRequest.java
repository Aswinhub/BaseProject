package com.project.aswin.baseproject.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.project.aswin.baseproject.common.AppPreference;
import com.project.aswin.baseproject.common.Constents;
import com.project.aswin.baseproject.common.Utility;
import com.project.aswin.baseproject.interfaces.ServerResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aswin on 10/22/2016.
 */

public class ServerRequest {

    private static ServerRequest serverRequest;
    Context context;
    RequestID requestID;
    private ServerResponse serverResponse;

    //default constructor created as private for restrict object

    private ServerRequest(Context context) {
        this.context = context;
    }

    //Singleton object function

    public static synchronized ServerRequest getInstance(Context context) {
        if (serverRequest == null) {
            serverRequest = new ServerRequest(context);
        }
        return serverRequest;
    }

    //method to get json data from API

    public void jsonObjectwithHeaderRequest(final ServerResponse serverResponse, final Map hashMap, int method, final RequestID requestID, final JSONObject jsonObject) {
        if (isNetworkAvailable()) {
            this.requestID = requestID;
            this.serverResponse = serverResponse;

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, Constents.getURL(requestID),
                    jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("response", response.toString());
                    if (response != null) {
                        try {
                            resultHandler(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    NetworkResponse networkResponse = error.networkResponse;

                    if (networkResponse != null) {
                        Log.e("ID", "" + new String(networkResponse.data));
                        serverResponse.onError("Enter valid number", requestID);
                    }

                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> header = new HashMap<>();
                    header.put("Authorization", "" + AppPreference.getInstance(context).getString(Constents.AUTH_TOKEN));
                    return header;
                }
            };
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Volley.newRequestQueue(context).add(jsonObjectRequest);
        } else {
            Utility.with(context).showAlert("No Internet", "please check your Internet connection");
        }
    }

    // method to get gson data from json object

    private void resultHandler(JSONObject response) throws JSONException {
        boolean status = response.getBoolean("status");
        if (status) {

            Object object = getGsonModel(response, requestID);
            serverResponse.onSuccess(object, requestID);

        } else {
            //if status false
            //cleare user login details in AppPreference
            serverResponse.onError(response.getString("message"), requestID);
        }
    }

    //method to set gson model class for object

    private Object getGsonModel(JSONObject response, RequestID requestID) {
        Object object = null;
        Gson gson = new Gson();

        object = gson.fromJson(response.toString(), GetGsonModel.getModel(requestID));

        return object;
    }

    // method to check network

    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
