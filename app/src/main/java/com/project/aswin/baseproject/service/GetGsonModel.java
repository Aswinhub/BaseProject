package com.project.aswin.baseproject.service;

/**
 * Created by Aswin on 10/22/2016.
 */

public class GetGsonModel {

    public static Class getModel(RequestID requestID) {
        Class modelClass = null;

        switch (requestID) {
            case REQ_SIGNUP:
                break;
            default:
                modelClass = String.class;
                break;
        }
        return modelClass;
    }
}
