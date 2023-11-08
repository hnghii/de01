package com.example.baovemon.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baovemon.database.DPHelper;
import com.example.baovemon.models.XE;

import java.util.ArrayList;

public class XEDAO {

    private DPHelper dpHelper;

    public XEDAO(Context context){
        dpHelper = new DPHelper(context);
    }

    public ArrayList<XE> getNguoiDung() {
        ArrayList<XE> list = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = dpHelper.getReadableDatabase();

        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG", null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                list.add(new XE(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getInt(4)));
            }while (cursor.moveToNext());
        }
        return list;

    }
    //them
    public boolean ThemThongTin(XE xe){
        SQLiteDatabase sqLiteDatabase = dpHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tenxe",xe.getTenxe());
        contentValues.put("giaban",xe.getGiaban());
        contentValues.put("hangxe",xe.getHangxe());
        contentValues.put("trangthai",1);

        long check = sqLiteDatabase.insert("NGUOIDUNG", null, contentValues);

        return check != -1;
    }
    //xoa
    public int xoaThongTin(int maxe){
        SQLiteDatabase sqLiteDatabase = dpHelper.getWritableDatabase();

        int check = sqLiteDatabase.delete("NGUOIDUNG", "maxe = ?",new String[]{String.valueOf(maxe)});
        if (check == 0){
            return -1;
        }else {
            return 1;
        }
    }
}
