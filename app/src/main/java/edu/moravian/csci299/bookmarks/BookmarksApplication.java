package edu.moravian.csci299.bookmarks;

import android.app.Application;

public class BookmarksApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BookmarksRepository.initialize(this);
    }
}
