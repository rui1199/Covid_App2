package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class pagina_resultados extends AppCompatActivity {

    TextView nomef, generof, moradaf, telef, idadef, viajarf, asmaf, sintomaf, resultadof;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_resultados);

        //base dados
        db=new DataBaseHelper(this);
        //id
        nomef = findViewById(R.id.textViewnome);
        telef = findViewById(R.id.textViewtele);
        idadef = findViewById(R.id.textViewidade);
        moradaf = findViewById(R.id.textViewmorada);
        generof = findViewById(R.id.textViewgenero);
        viajarf = findViewById(R.id.textViewviajar);
        sintomaf = findViewById(R.id.textViewsintomas);
        resultadof = findViewById(R.id.textViewresultado);

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

    public void terminar(View view){
        String saveNome=nomef.getText().toString();
        String savetele=telef.getText().toString();
        String savemorada=moradaf.getText().toString();
        String saveidade=idadef.getText().toString();
        String savegenero=generof.getText().toString();
        String saveasma=asmaf.getText().toString();
        String saveviajar=viajarf.getText().toString();
        String savesintoma=sintomaf.getText().toString();
        String saveresultado=resultadof.getText().toString();

        db.insertData(saveNome,savetele,savemorada,saveidade,savegenero,saveviajar,saveasma,savesintoma,saveresultado);

    }
}
