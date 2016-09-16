package com.herprogramacion.crmleads;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import java.util.Date;
import java.util.GregorianCalendar;

import static android.icu.util.Calendar.getInstance;

public class Detalle extends AppCompatActivity {
    TextView edtxDescripcion;
    Button btnInscripcion;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        edtxDescripcion = (TextView) findViewById(R.id.txViewDescripcion);
        btnInscripcion = (Button) findViewById(R.id.btnInscripcion);
        recuperarDatos();

    }

    /**
     * se recuperan los datos del JSON para mostrarse
     */
    public void recuperarDatos() {
        String json = getIntent().getStringExtra("objeto");
        Lead currentLead = new Gson().fromJson(json, Lead.class);
        edtxDescripcion.setText(currentLead.getDescripcion());
    }

@Override
    protected void onResume(){
        super.onResume();
         btnInscripcion.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View view){
            Intent intentWebBrowser = new Intent(Intent.ACTION_VIEW);
            intentWebBrowser.setData(Uri.parse("https://it-okcenter.com/calendario/"));
            startActivity(intentWebBrowser);
        }
    });
}

    //*  @Override
    //* protected void onResume(){
    //*  super.onResume();
    //* btnInscripcion.setOnClickListener(){
    //*  btnInscripcion.setText("Inscripcion");
    //*  }

    //* }


}




