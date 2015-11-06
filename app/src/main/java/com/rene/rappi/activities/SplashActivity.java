package com.rene.rappi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.rene.rappi.R;
import com.rene.rappi.utils.CheckNetwork;
import com.rene.rappi.utils.Constants;

import org.json.JSONObject;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        contarEjecucion();



    }

    private void contarEjecucion(){

        int numeroDeEjecucion = Constants.getNumeroDeEjecucion(this);
        if(numeroDeEjecucion==0){
            if(CheckNetwork.isConnected(this)) {
                request();
            }else
                Constants.goErrorRed(SplashActivity.this);
        } else if (numeroDeEjecucion > 0) {
            nextActivity();
        }
        numeroDeEjecucion++;
        Constants.setNumeroDeEjecucion(numeroDeEjecucion, this);

    }


    public void nextActivity() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startActivity = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(startActivity);
                finish();
            }
        }, 1000);
    }

    private void request() {

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET,
                Constants.KEY_URL_JSON,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if(response!=null) {
                            Log.e("response",response.toString());
                            setResponse(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Constants.goErrorRed(SplashActivity.this);
                    }
                });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(jsObjRequest);
    }

    private void setResponse(JSONObject response) {
        Constants.setResponse(response,this);
        nextActivity();
    }

}
