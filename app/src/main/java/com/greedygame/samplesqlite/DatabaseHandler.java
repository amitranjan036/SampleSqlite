package com.greedygame.samplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by nikhil on 29/3/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="FoodManager.db";
    public static final String TABLE_NAME="FoodDetail";
    public static final String COL_1="id";
    public static final String COL_2="FOOD_NAME";

    public DatabaseHandler(Context context)
    {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)

    {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FOOD_NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String foodName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,foodName);
        long result = db.insert(TABLE_NAME,null,contentValues);

            return result != -1;
    }

    public ArrayList<String> getAllFood() {
        ArrayList<String> foodList = new ArrayList<String>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                //Food food = new Food();
                //food.setid(Integer.parseInt(cursor.getString(0)));
                //food.setfoodName(cursor.getString(1));
                foodList.add(cursor.getString(1));
            }
            while(cursor.moveToNext());
        }
        return foodList;
    }
}
