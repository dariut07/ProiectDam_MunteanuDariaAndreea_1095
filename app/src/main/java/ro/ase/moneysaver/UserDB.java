package ro.ase.moneysaver;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database (entities = {ContUser.class}, version = 1, exportSchema = false)
public abstract class UserDB extends RoomDatabase {
    private static final String dbName = "useri.db";
    private static UserDB instance;
    public static UserDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, UserDB.class, dbName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDAO getUserDAO();
}
