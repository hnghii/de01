package com.example.baovemon.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DPHelper extends SQLiteOpenHelper {
    public DPHelper(@Nullable Context context) {
        super(context, "qlcuahang", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tnguoidung = "CREATE TABLE NGUOIDUNG(maxe Integer primary key autoincrement, tenxe text, giaban Integer, hangxe text, trangthai Integer)";
        db.execSQL(tnguoidung);
        db.execSQL("INSERT INTO NGUOIDUNG VALUES(1, 'vario', 5000, 'honda',1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            onCreate(db);
        }
    }
}
