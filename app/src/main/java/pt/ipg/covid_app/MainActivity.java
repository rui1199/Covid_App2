package pt.ipg.covid_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_1, menu);


        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent base_dados = new Intent(this, RecyclerView.class);;
        if (id == R.id.outroquestionario) {
            startActivity(base_dados);
        }
        return super.onOptionsItemSelected(item);
        }

    public void button_iniciar (View view){
        Intent iniciar = new Intent(getApplicationContext(), pagina_nome.class);

        startActivity(iniciar);
    }

    public void button_sair (View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
