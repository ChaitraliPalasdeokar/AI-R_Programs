package com.example.android.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.autofill.UserData;

import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    public DatabaseHelper(Context context) {
        super(context,"Login.db",null,1);
        


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table user(email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");
        onCreate(sqLiteDatabase);

    }

    public boolean insert(String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1) return false;
        else
            return true;

    }

    public Boolean checkmail(String email){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0){
            cursor.close(); //added by me
            return false;
        }
        else {

            cursor.close();//added by me
            return true;
        }
    }

    public Boolean validation(String email, String password){

        SQLiteDatabase db=this.getReadableDatabase();

            Cursor cursor = db.rawQuery("Select * from user where email=? and password=?", new String[]{email, password});
            try{
            if (cursor.getCount() == 1) return true;//changes here instead of >0
            else
                return false;
        }
        finally{
            cursor.close();
        }
    }
//added by me
    public void showData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user",null);

    }






}
