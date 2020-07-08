package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pagina_sintomas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_sintomas);

        Intent continuar3 = getIntent();
    }
    public void button_continuar4 (View view){
        Intent continuar4= new Intent(getApplicationContext(), pagina_resultados.class);

        startActivity(continuar4);
    }
}
