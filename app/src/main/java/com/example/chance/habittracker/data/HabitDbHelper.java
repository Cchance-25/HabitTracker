package com.example.chance.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.chance.habittracker.data.HabitsContract.HabitEntry;
/**
 * Created by chance on 8/14/17.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "habits.db";
    public static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HABITS_TABLES = "CREATE TABLE "+ HabitEntry.TABLE_NAME + "("
                +HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +HabitEntry.HABIT_NAME + " TEXT NOT NULL, "
                +HabitEntry.HABIT_DOING_FREQUENCY + " INTEGER NOT NULL DEFAULT 1);";

        db.execSQL(CREATE_HABITS_TABLES);
        Log.i(getClass().getSimpleName(), "OnCreate - Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
