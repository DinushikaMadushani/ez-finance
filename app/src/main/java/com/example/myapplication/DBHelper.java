package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 5;
    private static final String DB_NAME = "UserArrangers";
    private static final String TABLE_NAME = "newUsers";

    //Column names
    private static final String name = "name";
    private static final String nic = "nic";
    private static final String address = "address";
    private static final String con = "con";
    private static final String mail = "mail";
    private static final String job = "job";
    private static final String income = "income";

    public DBHelper(@Nullable Context context) {

        super(context, DB_NAME, null, VERSION);
    }
    //creating database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + name + " TEXT  ,"
                + nic + " TEXT PRIMARY KEY,"
                + address + " TEXT,"
                + con + " TEXT,"
                + mail + " TEXT,"
                + job + " TEXT,"
                + income + " TEXT" +
                ");";

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    //inserting data into database
    public void insertUser(useModelClass usemodelclass) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(name, usemodelclass.getName());
        contentValues.put(nic, usemodelclass.getNic());
        contentValues.put(address, usemodelclass.getAddress());
        contentValues.put(con, usemodelclass.getCon());
        contentValues.put(mail, usemodelclass.getMail());
        contentValues.put(job, usemodelclass.getJob());
        contentValues.put(income, usemodelclass.getIncome());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        //close database
        sqLiteDatabase.close();
    }

    public Integer deleteUser(String nic){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, "nic = ?",new String[]{nic});

    }

}


