package com.project.aswin.baseproject.common;

import com.project.aswin.baseproject.service.RequestID;

/**
 * Created by Aswin on 10/21/2016.
 */

public class Constents {

    //variable for base url

    public static final String PREFERENCE_NAME = "aswin";

    //varible for url

    public static final String AUTH_TOKEN = "authtoken";

    //method to set URL for API call

    public static int id;

    //Strings to be used in AppPreference

    private static String BASE_URL = "";

    // method to set get URL for requestID

    public static String getURL(RequestID requestID) {

        String url = null;

        switch (requestID) {
            case REQ_SIGNUP:
                url = BASE_URL + "";
                break;
        }
        return url;
    }
}
