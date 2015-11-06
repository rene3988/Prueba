package com.rene.rappi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.rene.rappi.activities.ErrorActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rene on 03/11/2015.
 */
public class Constants {


    public static final String APP_PREFERENCES      = "Rappi";
    public static final String KEY_NUMERO_EJECUCION = "nEjecucion";
    public static final String KEY_RESPONSE         = "Response";

    public static final String KEY_URL_JSON = "https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json";

    public static void goErrorRed(Activity context) {

        Intent startActivity = new Intent(context, ErrorActivity.class);
        context.startActivity(startActivity);
        context.finish();
    }

    public static void setNumeroDeEjecucion(int numeroDeEjecucion, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_NUMERO_EJECUCION, numeroDeEjecucion);
        editor.apply();
    }

    public static int getNumeroDeEjecucion(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Constants.KEY_NUMERO_EJECUCION, 0);
    }


    public static void setResponse(JSONObject object, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.KEY_RESPONSE, object.toString());
        editor.apply();
    }

    public static JSONObject getRespose(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        JSONObject object = null;
        try {
            object = new JSONObject(sharedPreferences.getString(Constants.KEY_RESPONSE, ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }
}
