package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class pagina_nome extends AppCompatActivity {
    public static final String EXTRA_NOME = "pt.ipg.covid_app.NOME";
    public static final String EXTRA_GENERO ="pt.ipg.covid_app.GENERO" ;
    public static final String EXTRA_IDADE ="pt.ipg.covid_app.IDADE" ;
    public static final String EXTRA_MORADA ="pt.ipg.covid_app.MORADA" ;
    public static final String EXTRA_TELE = "pt.ipg.covid_app.TELE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_nome);


        Intent iniciar = getIntent();
    }
    public void button_continue (View view){
        Intent iniciar= new Intent(getApplicationContext(), pagina_sintomas.class);

        EditText textinputnome = (EditText) findViewById(R.id.textinputnome);
        EditText textinputmorada = (EditText) findViewById(R.id.textinputmorada);
        EditText textinputtele = (EditText) findViewById(R.id.textinputtele);
        EditText textinputidade = (EditText) findViewById(R.id.textinputidade);
        EditText textinputgenero = (EditText) findViewById(R.id.textinputgenero);

        String nome = textinputnome.getText().toString();
        if(nome.length()<= 0){
            textinputnome.setError("diga um nome");
            textinputnome.requestFocus();
            return;
        }
        String tele = textinputtele.getText().toString();
        if(tele.length()<= 0) {
            textinputtele.setError("indique um numero de telemovel");
            textinputtele.requestFocus();
            return;
        }
        String idade = textinputidade.getText().toString();
        int idadee;
        try {
            idadee = Integer.parseInt(idade);
        }catch (NumberFormatException e){
            textinputidade.setError("diga a sua idade");
            textinputidade.requestFocus();
            return;
        }
        if(idadee <= 0){
            textinputidade.setError("Idade inválida");
            textinputidade.requestFocus();
            return;
        }
        String morada = textinputmorada.getText().toString();
        if(morada.length()<= 0){
            textinputmorada.setError("indique uma morada");
            textinputmorada.requestFocus();
            return;}
        String genero = textinputgenero.getText().toString();
        if(genero.length()<= 0){
            textinputgenero.setError("diga o seu genero");
            textinputgenero.requestFocus();
            return;}

        iniciar.putExtra(EXTRA_NOME, nome);
        iniciar.putExtra(EXTRA_TELE,tele);
        iniciar.putExtra(EXTRA_IDADE, idade);
        iniciar.putExtra(EXTRA_MORADA, morada);
        iniciar.putExtra(EXTRA_GENERO, genero);

       startActivity(iniciar);
    }
}
