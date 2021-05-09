package com.example.newproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbconecter extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "UserPayment";
    private static final String TABLE_NAME = "newUsers";

    private static final String Vnumber = "vnumber";
    private static final String Accno = "accno";
    private static final String Mounthlyin = "mounthlyin";
    private static final String Amount = "amount";
    private static final String Cardty = "cardty";
    private static final String Cardno = "cardno";
    private static final String Name = "name";


    public dbconecter(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + Vnumber + " TEXT  ,"
                + Accno + " TEXT PRIMARY KEY,"
                + Mounthlyin + " TEXT,"
                + Amount + " TEXT,"
                + Cardty + " TEXT,"
                + Cardno + " TEXT,"
                + Name + " TEXT" +
                ");";
        db.execSQL(TABLE_CREATE_QUERY);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        // Create tables again
        onCreate(db);

    }

    //inserting data into database
    public void insertUser(usermodel usermodel) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Vnumber, usermodel.getVnumber());
        contentValues.put(Accno, usermodel.getAccno());
        contentValues.put(Mounthlyin, usermodel.getMounthlyin());
        contentValues.put(Amount, usermodel.getAmount());
        contentValues.put(Cardty, usermodel.getCardty());
        contentValues.put(Cardno, usermodel.getCardno());
        contentValues.put(Name, usermodel.getName());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        //close database
        sqLiteDatabase.close();
    }

}
