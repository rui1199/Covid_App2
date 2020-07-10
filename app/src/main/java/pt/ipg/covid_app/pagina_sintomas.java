package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class pagina_sintomas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_sintomas);

        Intent iniciar = getIntent();

        String nome = iniciar.getStringExtra(pagina_nome.EXTRA_NOME);
        String tele = iniciar.getStringExtra(pagina_nome.EXTRA_TELE);
        String idade = iniciar.getStringExtra(pagina_nome.EXTRA_IDADE);
        String morada = iniciar.getStringExtra(pagina_nome.EXTRA_MORADA);
        String genero = iniciar.getStringExtra(pagina_nome.EXTRA_GENERO);

        TextView textViewnome = findViewById(R.id.textViewnome);
        textViewnome.setText(nome);
        TextView textViewtele = findViewById(R.id.textViewphone);
        textViewtele.setText(tele);
        TextView textViewidade = findViewById(R.id.textViewage);
        textViewidade.setText(idade);
        TextView textViewmorada = findViewById(R.id.textViewaddress);
        textViewmorada.setText(morada);
        TextView textViewgenero = findViewById(R.id.textViewgender);
        textViewgenero.setText(genero);
    }

}
