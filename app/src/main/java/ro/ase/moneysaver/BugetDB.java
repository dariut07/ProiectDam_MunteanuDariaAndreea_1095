package ro.ase.moneysaver;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Buget.class}, version = 1,exportSchema = false)
public abstract class BugetDB extends RoomDatabase {
    private static final String dbName = "bugete.db";
    private static BugetDB instance;
    public static BugetDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, BugetDB.class, dbName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract BugetDAO getBugetDAO();
}

