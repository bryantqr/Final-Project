package edu.moravian.csci299.bookmarks;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * Database to save thee bookmarks
 */
@Database(entities = {Bookmark.class}, version = 1)
@TypeConverters(BookmarkTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookmarksDao bookmarksDao();
}
