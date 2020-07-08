package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pagina_nome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_nome);

        Intent iniciar = getIntent();
    }
    public void button_continue (View view){
        Intent iniciar= new Intent(getApplicationContext(), pagina_viajou.class);

        startActivity(iniciar);
    }
}
