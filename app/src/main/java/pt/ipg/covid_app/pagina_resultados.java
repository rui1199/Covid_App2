package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class pagina_resultados extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_resultados);

        Intent terminar1 = getIntent();

        String Nome1 = terminar1.getStringExtra(pagina_sintomas.EXTRA_NOME1);
        String Tele1 = terminar1.getStringExtra(pagina_sintomas.EXTRA_TELE1);
        String Idade1 = terminar1.getStringExtra(pagina_sintomas.EXTRA_IDADE1);
        String Morada1 = terminar1.getStringExtra(pagina_sintomas.EXTRA_MORADA1);
        String Genero1 = terminar1.getStringExtra(pagina_sintomas.EXTRA_GENERO1);

        TextView textViewnomee = findViewById(R.id.textViewnome);
        textViewnomee.setText(Nome1);
        TextView textViewtelee = findViewById(R.id.textViewtele);
        textViewtelee.setText(Tele1);
        TextView textViewidadee = findViewById(R.id.textViewidade);
        textViewidadee.setText(Idade1);
        TextView textViewmoradaa = findViewById(R.id.textViewmorada);
        textViewmoradaa.setText(Morada1);
        TextView textViewgeneroo = findViewById(R.id.textViewgenero);
        textViewgeneroo.setText(Genero1);

        String selectedRadioValue = terminar1.getStringExtra("rg");
        TextView viajar = (TextView) findViewById(R.id.textViewviajar);
        viajar.setText(selectedRadioValue);

        String selectedRadioValue1 = terminar1.getStringExtra("rgg");
        TextView asma = (TextView) findViewById(R.id.textViewasma);
        asma.setText(selectedRadioValue1);

        String sintomas1 = terminar1.getStringExtra(pagina_sintomas.EXTRA_SINTOMAS);
        TextView sintomas = findViewById(R.id.textViewsintomas);
        sintomas.setText(sintomas1);

        TextView resultado =findViewById(R.id.textViewresultado);

        if(Idade1.length() < 65){
            resultado.setText("COVID");
        }else{
            resultado.setText("n");
        }
    }
}
