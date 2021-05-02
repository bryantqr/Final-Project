package edu.moravian.csci299.bookmarks;

import android.app.Application;

/**
 * The class for the entire application. Adds the additional feature of
 * initializing the repository singleton.
 */
public class BookmarksApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BookmarksRepository.initialize(this);
    }
}
