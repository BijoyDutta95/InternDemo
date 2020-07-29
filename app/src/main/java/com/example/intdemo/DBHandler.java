package com.example.intdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    private static String DBName ="ProjectData";
    private static int DBVersion=1;
    public DBHandler(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ADMIN(ad_Email text primary key, ad_Name text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS ADMIN");
    }

    //FOR INSERTING VALUES INTO TABLE
    public boolean onInsert(String email, String name, String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ad_Email",email);
        contentValues.put("ad_Name",name);
        contentValues.put("password",pass);
        int insFlag= (int) db.insert("ADMIN",null,contentValues);
        if(insFlag==-1)
            return false;
        else
            return true;
    }
    public boolean verifyCredentials(String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM ADMIN WHERE ad_Email=? AND password=?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
