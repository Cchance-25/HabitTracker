package com.example.chance.habittracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chance.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        SQLiteDatabase db = habitDbHelper.getReadableDatabase();

        MyHabitsManager manager = new MyHabitsManager(habitDbHelper, db);

        manager.addHabit("Jogging ", 5);
        manager.addHabit("Read books ", 4);
        manager.addHabit("Taking care of pets ", 7);
        manager.addHabit("More habits ", 4);
        manager.addHabit("More habits ", 3);
        manager.addHabit("More habits ", 1);

        Cursor c = manager.getHabitsFromDb();

        Log.i(getClass().getSimpleName(), manager.extractDataFromCursor(c));
    }
}
