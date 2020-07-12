package pt.ipg.covid_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 99;
    private static final String DATABASE_NAME = "Covid";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Data.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData (String nomef,String telef,String moradaf,String idadef,String generof,String viajarf,String asmaf,String sintomaf,String resultadof){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Nome",nomef);
        values.put("Tele",telef);
        values.put("Morada",moradaf);
        values.put("Idade",idadef);
        values.put("Genero",generof);
        values.put("viajar",viajarf);
        values.put("asma",asmaf);
        values.put("sintomas",sintomaf);
        values.put("resultado",resultadof);
        long id=db.insert("Questionario",null,values);
        db.close();
        return id;
    }

    public List<Data> getAllDataFromDb() {
        List<Data> notes = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + "Questionario";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Data note = new Data();
                note.setNome(cursor.getString(cursor.getColumnIndex("Nome")));
                note.setTele(cursor.getString(cursor.getColumnIndex("Tele")));
                note.setMorada(cursor.getString(cursor.getColumnIndex("Morada")));
                note.setIdade(cursor.getString(cursor.getColumnIndex("Idade")));
                note.setGenero(cursor.getString(cursor.getColumnIndex("Genero")));
                note.setViajar(cursor.getString(cursor.getColumnIndex("viajar")));
                note.setAsma(cursor.getString(cursor.getColumnIndex("asma")));
                note.setSintomas(cursor.getString(cursor.getColumnIndex("sintomas")));
                note.setResultado(cursor.getString(cursor.getColumnIndex("resultado")));
                notes.add(note);
            } while (cursor.moveToNext());
        }
        db.close();
        return notes;
    }
}
