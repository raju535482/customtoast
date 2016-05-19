package com.example.sony.customtoast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by SONY on 11-02-2016.
 */
public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_version= 2;
    public static final String DATABASE_NAME="menu_dbs";
    public static final String Table_Name="mnu";

    public Database(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String s = " CREATE TABLE " + Table_Name + "(id Integer, salad TEXT, sabji TEXT, papad TEXT, cold TEXT, dal TEXT, sweet TEXT);";
            db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist" + Table_Name);
    }

    public void insert(Menu m1) {
        SQLiteDatabase sh1 = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", m1.getOrder());
        cv.put("salad", m1.getSalad());
        cv.put("sabji", m1.getSabji());
        cv.put("papad", m1.getPapad());
        cv.put("cold", m1.getCold());
        cv.put("dal", m1.getDal());
        cv.put("sweet", m1.getSweet());
        sh1.insert(Table_Name, null, cv);
        Log.e("Inserted...", "Successfully..");

    }

    public ArrayList<Menu>showdata() {
        SQLiteDatabase sh1 = getReadableDatabase();
        ArrayList<Menu> alist = new ArrayList<Menu>();
        Cursor c = sh1.rawQuery("SELECT * FROM "+Table_Name, null);
        c.moveToFirst();
        if (c != null) {

            do {
                Menu m1 = new Menu();
                m1.setOrder(c.getInt(0));
                m1.setSalad(c.getString(1));
                m1.setSabji(c.getString(2));
                m1.setPapad(c.getString(3));
                m1.setCold(c.getString(4));
                m1.setDal(c.getString(5));
                m1.setSweet(c.getString(6));
                alist.add(m1);
            } while (c.moveToNext());

        }
        return alist;

    }
    public void update(Menu m1) {
        SQLiteDatabase sd = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", m1.getOrder());
        cv.put("salad", m1.getSalad());
        cv.put("sabji", m1.getSabji());
        cv.put("papad", m1.getPapad());
        cv.put("cold", m1.getCold());
        cv.put("dal", m1.getDal());
        cv.put("sweet", m1.getSweet());
        sd.update(Table_Name, cv, "id=?", new String[]{String.valueOf(m1.getOrder())});
        Log.e("Updated..", "update");
    }
    public void delete(Menu m1){

        SQLiteDatabase st=getWritableDatabase();
        st.delete(Table_Name, "id=?", new String[]{String.valueOf(m1.getOrder())});
    }
    }