package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pagina_asma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_asma);

        Intent continuar2 = getIntent();

    }
    public void button_continuar3 (View view){
        Intent continuar3= new Intent(getApplicationContext(), pagina_sintomas.class);

        startActivity(continuar3);
    }
}
