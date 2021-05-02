package edu.moravian.csci299.bookmarks;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BookmarksRepository {
    private final BookmarksDAO dao;
    private final Executor executor;

    private BookmarksRepository(Context context) {
        AppDatabase database = Room.databaseBuilder(
            context.getApplicationContext(),
            AppDatabase.class,
            "app_database").build();
        dao = database.bookmarksDao();
        executor = Executors.newSingleThreadExecutor();
    }

    // The public methods that call the DAO methods.
    public LiveData<List<Bookmark>> getBookmarks() {
        return dao.getAllBookmarks();
    }
    public LiveData<Bookmark> getBookmark(String id) {
        return dao.getBookmark(id);
    }

    // Insert and update methods.
    public void addBookmark(Bookmark bookmark) {
        executor.execute(() -> {
            dao.addBookmark(bookmark);
        });
    }

    public void removeBookmark(Bookmark bookmark) {
        executor.execute(() -> {
            dao.removeBookmark(bookmark);
        });
    }

    public void updateBookmark(Bookmark bookmark) {
        executor.execute(() -> {
            dao.updateBookmark(bookmark);
        });
    }

    // Single instance of the repository.
    private static BookmarksRepository INSTANCE;
    public static void initialize(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new BookmarksRepository(context);
        }
    }
    public static BookmarksRepository get() {
        if (INSTANCE == null) {
            throw new IllegalStateException("BookmarkRepository must be initialized");
        }
        return INSTANCE;
    }
}
