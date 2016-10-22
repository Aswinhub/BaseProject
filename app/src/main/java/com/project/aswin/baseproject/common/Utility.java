package com.project.aswin.baseproject.common;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aswin on 10/21/2016.
 */

public class Utility {
    private static Utility utility;
    Context context;

    private Utility(Context context) {
        this.context = context;
    }

    public static synchronized Utility with(Context context) {

        if (utility == null) {

            utility = new Utility(context);
        }

        return utility;
    }

    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String title, String message) {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle(title);
        builder1.setMessage(message);

        builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        builder1.show();
    }

    public String dateFormat(String datetime) {


        DateFormat writeFormat = new SimpleDateFormat("EEEE, MMMM d \nK:mm aa");
        DateFormat readFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = readFormat.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String formattedDate = "";

        if (date != null) {
            formattedDate = writeFormat.format(date);
        }
        return formattedDate;

    }

    public String numberFormat(String value) {

        if (value.isEmpty()) {
            return "0.00";
        } else {
            return String.format("%.2f", Double.parseDouble(value));
        }

    }

}
