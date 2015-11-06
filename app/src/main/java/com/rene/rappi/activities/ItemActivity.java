package com.rene.rappi.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rene.rappi.R;
import com.rene.rappi.model.Entry;

public class ItemActivity extends AppCompatActivity {

    private static final String EXTRA_NAME     = "com.rene.rappi.name";
    private static final String EXTRA_DRAWABLE = "com.rene.rappi.drawable";
    private static final String EXTRA_URI      = "com.rene.rappi.uri";
    private static final String EXTRA_SUMMARY  = "com.rene.rappi.summary";
    private static final String EXTRA_CATEGORY = "com.rene.rappi.category";
    private static final String EXTRA_RIGHTS   = "com.rene.rappi.rights";

    private String name ;
    private String drawable;
    private String uri;
    private String summary ;
    private String category ;
    private String rights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        name = i.getStringExtra(EXTRA_NAME);
        drawable = i.getStringExtra(EXTRA_DRAWABLE);
        uri = i.getStringExtra(EXTRA_URI);
        summary = i.getStringExtra(EXTRA_SUMMARY);
        category = i.getStringExtra(EXTRA_CATEGORY);
        rights = i.getStringExtra(EXTRA_RIGHTS);

        CollapsingToolbarLayout collapser =
                (CollapsingToolbarLayout) findViewById(R.id.collapser);
        collapser.setTitle(name); // Cambiar título

        loadImageParallax(drawable);// Cargar Imagen

        TextView textSummary = (TextView) findViewById(R.id.desc);
        textSummary.setText(summary);
        TextView textCategory = (TextView) findViewById(R.id.category);
        textCategory.setText(category);
        TextView textRights = (TextView) findViewById(R.id.rights);
        textRights.setText(rights);
        // Setear escucha al FAB
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(uri));
                        startActivity(i);
                        //showSnackBar("Opción de Chatear");
                    }
                }
        );
    }

    public static void createInstance(Activity activity, Entry entry) {
        Intent intent = getLaunchIntent(activity, entry);
        activity.startActivity(intent);
    }

    public static Intent getLaunchIntent(Context context, Entry entry) {
        Intent intent = new Intent(context, ItemActivity.class);
        intent.putExtra(EXTRA_NAME, entry.getTitle().getLabel());
        intent.putExtra(EXTRA_DRAWABLE, entry.getImageList().get(0).getLabel());
        intent.putExtra(EXTRA_URI, entry.getLink().getAttributes().getHref());
        intent.putExtra(EXTRA_RIGHTS, entry.getRights().getLabel());
        intent.putExtra(EXTRA_CATEGORY, entry.getCategory().getAttributes().getLabel());
        intent.putExtra(EXTRA_SUMMARY, entry.getSummary().getLabel());
        return intent;
    }

    /**
     * Se carga una imagen aleatoria para el detalle
     */
    private void loadImageParallax(String id) {
        ImageView image = (ImageView) findViewById(R.id.image_paralax);
        // Usando Glide para la carga asíncrona
        Glide.with(this)
                .load(id)
                .centerCrop()
                .into(image);
    }

    /**
     * Proyecta una {@link Snackbar} con el string usado
     *
     * @param msg Mensaje
     */
    private void showSnackBar(String msg) {
        Snackbar
                .make(findViewById(R.id.coordinator), msg, Snackbar.LENGTH_LONG)
                .show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_share:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Sharing");
                i.putExtra(Intent.EXTRA_TEXT, uri);
                startActivity(Intent.createChooser(i, "Share"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
