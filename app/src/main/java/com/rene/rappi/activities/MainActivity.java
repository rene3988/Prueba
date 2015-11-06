package com.rene.rappi.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.rene.rappi.R;
import com.rene.rappi.adapters.AdapterItems;
import com.rene.rappi.model.Response;
import com.rene.rappi.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    private Response response;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private RecyclerView reciclador;
    private LinearLayoutManager linearManager;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterItems adapterItems;
    private TelephonyManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        if(manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE){
            setContentView(R.layout.activity_main_tablet);
        }else{
            setContentView(R.layout.activity_main);
        }

        sharedPreferences = getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        try {
            JSONObject object = new JSONObject(sharedPreferences.getString(Constants.KEY_RESPONSE,""));
            response = new Response(object);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(response.getFeed().getTitle().getLabel());
/*      RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        ImageRequest imageRequest = new ImageRequest(response.getFeed().getIcon().getLabel(), new com.android.volley.Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {


                Drawable d = new BitmapDrawable(getResources(), response);
                toolbar.setLogo(d);
            }
        }, 45, 45, null, Bitmap.Config.RGB_565, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                toolbar.setLogo(R.mipmap.ic_launcher);
            }
        });
        imageRequest.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(imageRequest);*/
        setSupportActionBar(toolbar);
        getContent();
    }


    public void getContent(){

        reciclador = (RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        if(manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE){
            mLayoutManager = new GridLayoutManager(this, 3);
            reciclador.setLayoutManager(mLayoutManager);
        }else{
            linearManager = new LinearLayoutManager(this);
            reciclador.setLayoutManager(linearManager);
        }

        adapterItems = new AdapterItems(this,response.getFeed().getEntryList());
        adapterItems.setHasStableIds(true);
        //adapterDevice.setOnItemClickListener(context);
        reciclador.setAdapter(adapterItems);
        adapterItems.notifyDataSetChanged();

    }

}
