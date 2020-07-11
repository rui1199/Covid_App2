package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class pagina_sintomas extends AppCompatActivity {

    public static final String EXTRA_NOME1 = "pt.ipg.covid_app.NOME";
    public static final String EXTRA_GENERO1 ="pt.ipg.covid_app.GENERO" ;
    public static final String EXTRA_IDADE1 ="pt.ipg.covid_app.IDADE" ;
    public static final String EXTRA_MORADA1 ="pt.ipg.covid_app.MORADA" ;
    public static final String EXTRA_TELE1 = "pt.ipg.covid_app.TELE";
    public static final String EXTRA_SINTOMAS = "pt.ipg.covid_app.SINTOMAS";

    RadioButton Rsim;
    RadioButton Rnao;
    RadioButton Rsim1;
    RadioButton Rnao1;

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
    public  void terminar (View view){

        Intent terminar1= new Intent(getApplicationContext(), pagina_resultados.class);


        TextView nome1 = findViewById(R.id.textViewnome);
        String Nome1 = nome1.getText().toString();
        terminar1.putExtra(EXTRA_NOME1, Nome1);

        TextView tele1 = findViewById(R.id.textViewphone);
        String Tele1 = tele1.getText().toString();
        terminar1.putExtra(EXTRA_TELE1, Tele1);

        TextView morada1 = findViewById(R.id.textViewaddress);
        String Morada1 = morada1.getText().toString();
        terminar1.putExtra(EXTRA_MORADA1, Morada1);

        TextView idade1 = findViewById(R.id.textViewage);
        String Idade1 = idade1.getText().toString();
        terminar1.putExtra(EXTRA_IDADE1, Idade1);

        TextView genero1 = findViewById(R.id.textViewgender);
        String Genero1 = genero1.getText().toString();
        terminar1.putExtra(EXTRA_GENERO1, Genero1);


        RadioGroup rg = (RadioGroup) findViewById(R.id.grupo1);
        String selectedRadioValue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        terminar1.putExtra("rg", selectedRadioValue);

        RadioGroup rgg = (RadioGroup) findViewById(R.id.grupo2);
        String selectedRadioValue1 = ((RadioButton) findViewById(rgg.getCheckedRadioButtonId())).getText().toString();
        terminar1.putExtra("rgg", selectedRadioValue1);

        EditText sintomas = (EditText) findViewById(R.id.sintomas);
        String sintomas1 = sintomas.getText().toString();
        if(sintomas1.length()<= 0){
            sintomas.setError("diga se teve ou nao sintomas");
            sintomas.requestFocus();
            return;
        }
        terminar1.putExtra(EXTRA_SINTOMAS,sintomas1);

        startActivity(terminar1);
    }
}
