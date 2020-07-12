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
        values.put("nome",nomef);
        values.put("tele",telef);
        values.put("morada",moradaf);
        values.put("idade",idadef);
        values.put("genero",generof);
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
                note.setId(cursor.getInt(cursor.getColumnIndex("id")));
                note.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                note.setTele(cursor.getString(cursor.getColumnIndex("tele")));
                note.setMorada(cursor.getString(cursor.getColumnIndex("morada")));
                note.setIdade(cursor.getString(cursor.getColumnIndex("idade")));
                note.setGenero(cursor.getString(cursor.getColumnIndex("genero")));
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

    //edita dados
    public int updateNote(Data note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", note.getNome());
        values.put("genero", note.getGenero());
        values.put("tele", note.getTele());
        values.put("idade", note.getIdade());
        values.put("morada", note.getMorada());
        values.put("viajar", note.getViajar());
        values.put("asma",note.getAsma());
        values.put("sintomas",note.getSintomas());
        values.put("resultado",note.getResultado());

        return db.update("Questionario", values, "Id" + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public void deleteNote(Data note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Questionario", "Id" + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }
}
