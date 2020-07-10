package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent fim = getIntent();
    }
    public void button_iniciar (View view){
        Intent iniciar = new Intent(getApplicationContext(), pagina_nome.class);

        startActivity(iniciar);
    }

    public void button_sair (View view){

    }
}
