package com.example.tpmeteo;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "meteo.db";
    public static final String TABLE_NAME = "historique_meteo";
    public static final String COL_1 = "NomVille";
    public static final String COL_2 = "Temperature";
    public static final String COL_3 = "Condition";

    public BD(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE table " + TABLE_NAME + "(NomVille text primary key, Temperature text, Condition text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists "+TABLE_NAME);
    }

    public void insertData(String NomVille, String Temperature, String Condition){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_1, NomVille);
        cv.put(COL_2, Temperature);
        cv.put(COL_3, Condition);

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result=db.rawQuery("select * from " + TABLE_NAME,null);
        return result;
    }
}
