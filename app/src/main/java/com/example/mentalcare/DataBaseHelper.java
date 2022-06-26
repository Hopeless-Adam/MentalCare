package com.example.mentalcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String MOOD_TABLE = "MOOD_TABLE";
    public static final String COLUMN_INFO_TEXT = "INFO_TEXT";
    public static final String COLUMN_MOOD_VALUE = "MOOD_VALUE";
    public static final String COLUMN_DAY_VALUE = "DAY_VALUE";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "mood.db", null, 1);
    }

    //called is called the first time the database is accessed. Should be code to generate a new table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + MOOD_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_INFO_TEXT + " TEXT, " + COLUMN_MOOD_VALUE + " INT, " + COLUMN_DAY_VALUE + " INT)";

        db.execSQL(createTableStatement);
    }

    //called whenever the version number changes. prevents previous users apps from crashing when database design changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(EntryModel entryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_MOOD_VALUE, entryModel.getMoodValue());
        cv.put(COLUMN_DAY_VALUE, entryModel.getDayValue());
        cv.put(COLUMN_INFO_TEXT, entryModel.getInfoText());

        long insert = db.insert(MOOD_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }


    //GETS ALL ENTRYS WITH ALL COLUMNS
    public List<EntryModel> getAllEntrys() {
        List<EntryModel> returnList = new ArrayList<>();
        //Get data from database
        String queryString = "SELECT * FROM " + MOOD_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int entryId = cursor.getInt(0);
                String infoText = cursor.getString(1);
                String moodValue = cursor.getString(2);
                int dayVal = cursor.getInt(3);

                EntryModel entryModel = new EntryModel(entryId, moodValue, dayVal, infoText);
                returnList.add(entryModel);
            } while (cursor.moveToNext());

        } else {
            //failure. do not add anything to the list
        }
        //close cursor and database when done
        cursor.close();
        db.close();
        return returnList;
    }

    //GETS ALL ENTRYS WITH THEIR MOOD TEXT AND ID
    public List<Integer> getAllEntryXCoords() {
        List<Integer> returnXCoordList = new ArrayList<>();
        //Get data from database
        String queryString = "SELECT " + COLUMN_ID + " FROM " + MOOD_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int entryId = cursor.getInt(0);
                returnXCoordList.add(entryId);
            } while (cursor.moveToNext());
        } else {
            //failure. do not add anything to the list
        }
        //close cursor and database when done
        cursor.close();
        db.close();
        return returnXCoordList;

    }
    //GETS ALL ENTRYS WITH THEIR MOOD TEXT AND ID
    public List<String> getAllEntryMoods() {
        List<String> returnYCoordList = new ArrayList<>();
        //Get data from database
        String queryString = "SELECT " + COLUMN_MOOD_VALUE + " FROM " + MOOD_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                String mood = cursor.getString(0);
                returnYCoordList.add(mood);
            } while (cursor.moveToNext());
        } else {
            //failure. do not add anything to the list
        }
        //close cursor and database when done
        cursor.close();
        db.close();
        return returnYCoordList;

    }
}
