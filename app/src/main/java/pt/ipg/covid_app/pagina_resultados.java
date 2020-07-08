package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pagina_resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_resultados);

        Intent continuar4 = getIntent();
    }
    public void button_final (View view){
        Intent fim= new Intent(getApplicationContext(), MainActivity.class);

        startActivity(fim);
    }
}
