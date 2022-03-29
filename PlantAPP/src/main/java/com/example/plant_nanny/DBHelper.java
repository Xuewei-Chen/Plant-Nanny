package com.example.plant_nanny;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME ="login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db_user) {
        db_user.execSQL("create table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db_user, int oldVersion, int newVersion) {
        db_user.execSQL("drop table if exists users");

    }

    //Insert Data Function
    public Boolean insertData(String username, String password){
        SQLiteDatabase db_user = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = db_user.insert("users", null, values);
        if(result == 1) return false;
        else {
            return true;
        }
    }

    //CheckUsername function
    public Boolean checkUsername(String username){
        SQLiteDatabase db_user = this.getWritableDatabase();
        Cursor cursor = db_user.rawQuery("select * from users where username =?", new String[]{username});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    //CheckUsername password function
    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase db_user = this.getWritableDatabase();
        Cursor cursor = db_user.rawQuery("select * from users where username =? and password = ?", new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

}
