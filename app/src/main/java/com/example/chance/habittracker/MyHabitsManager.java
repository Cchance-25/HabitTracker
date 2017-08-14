package com.example.chance.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chance.habittracker.data.HabitsContract.HabitEntry;

/**
 * Created by chance on 8/14/17.
 */

public class MyHabitsManager {

    private SQLiteOpenHelper mHelper;
    private SQLiteDatabase mDb;


    public MyHabitsManager(SQLiteOpenHelper mHelper, SQLiteDatabase mDb) {
        this.mHelper = mHelper;
        this.mDb = mDb;
    }

    public void addHabit(String habit, int frequency) {
        ContentValues cv = new ContentValues();
        cv.put(HabitEntry.HABIT_NAME, habit);
        cv.put(HabitEntry.HABIT_DOING_FREQUENCY, frequency);

        mDb.insert(HabitEntry.TABLE_NAME, null, cv);

    }

    public Cursor getHabitsFromDb() {

        mDb = mHelper.getReadableDatabase();

        String[] projection = {
                HabitEntry._ID,
                HabitEntry.HABIT_NAME,
                HabitEntry.HABIT_DOING_FREQUENCY
        };

        Cursor c = mDb.query(
                HabitEntry.TABLE_NAME, // database table name
                projection, // columns to retrieve
                null,
                null,
                null,
                null,
                null);
        return c;

    }

    public String extractDataFromCursor(Cursor c) {

        String tableHeader = HabitEntry._ID + "\t" + HabitEntry.HABIT_NAME;

        StringBuilder output = new StringBuilder();


        int idColumnIndex = c.getColumnIndex(HabitEntry._ID);
        int habitColumnIndex = c.getColumnIndex(HabitEntry.HABIT_NAME);
        int habitFrequencyColumnIndex = c.getColumnIndex(HabitEntry.HABIT_DOING_FREQUENCY);
        try {
            while (c.moveToNext()) {
                int id = c.getInt(idColumnIndex);
                String habitName = c.getString(habitColumnIndex);
                int habitFrequency = c.getInt(habitFrequencyColumnIndex);
                output.append(id + "\t" + habitName + habitFrequency + " Days a week." + "\n");
            }

        } finally {
            c.close();
        }
        return output.toString();
    }
}
