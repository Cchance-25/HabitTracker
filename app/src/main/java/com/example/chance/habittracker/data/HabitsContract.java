package com.example.chance.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by chance on 8/14/17.
 */

public class HabitsContract {

    private HabitsContract() {
        // This class should not be initialized
    }

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String HABIT_NAME = "habit_name";
        // How often do you do this habit in days.
        public static final String HABIT_DOING_FREQUENCY = "habit_frequency";

    }

}
