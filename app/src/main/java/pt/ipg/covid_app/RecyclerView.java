package pt.ipg.covid_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends AppCompatActivity {
    private List<Data> notesList = new ArrayList<>();
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    DataBaseHelper db;
    public static NotesAdapter mAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerview);
        //where you use object of databasehelper (db)
        //you have to initialize it.
        db = new DataBaseHelper(this);
        //get all data from database and store in list (noteslist)
        //then pass to recyclerview.

        notesList.addAll(db.getAllDataFromDb());
        mAdapter1 = new NotesAdapter(this, notesList);
        androidx.recyclerview.widget.RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter1);
    }
}
