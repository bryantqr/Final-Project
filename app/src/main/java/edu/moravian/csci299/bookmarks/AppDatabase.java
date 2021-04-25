package edu.moravian.csci299.bookmarks;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Bookmarks.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookmarksDao bookmarksDao();
}
