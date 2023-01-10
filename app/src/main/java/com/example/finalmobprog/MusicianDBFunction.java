package com.example.finalmobprog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MusicianDBFunction {
    DBHelper dbHelper;

    public MusicianDBFunction(Context context){
        dbHelper = new DBHelper(context, "BeeMusic", null, 1);
    }

    public void insert(Musician musician){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", musician.name);
        cv.put("qty", musician.age);

        db.insert("msmusician", null, cv);
        db.close();
    }

    public ArrayList<Musician> getAllMusician(){
        ArrayList<Musician> listMusician = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from msmusician", null);
        Musician musician = null;
        while (cursor.moveToNext()){
            musician = new Musician();
            musician.id = cursor.getInt(cursor.getColumnIndex("id"));
            musician.name = cursor.getString(cursor.getColumnIndex("name"));
            musician.age = cursor.getInt(cursor.getColumnIndex("age"));
            listMusician.add(musician);
        }
        return listMusician;
    }
}
