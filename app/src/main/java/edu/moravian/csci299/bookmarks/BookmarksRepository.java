package edu.moravian.csci299.bookmarks;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BookmarksRepository {
    // Internal singleton fields of the repository.
    private final AppDatabase database;
    private final BookmarksDao bookmarksDao;
    private final Executor executor = Executors.newSingleThreadExecutor();

    private BookmarksRepository(Context context) {
        database = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "app_database").build();
        bookmarksDao = database.bookmarksDao();
    }

    // The public methods that simply call the DAO methods.
    public LiveData<List<Bookmarks>> getBookmarks() {
        return bookmarksDao.getAllBookmarks();
    }

    public LiveData<Bookmarks> getBookmark(int id) {
        return bookmarksDao.getBookmark(id);
    }

//    public LiveData<List<Bookmarks>> getChildren(int parentId) {
//        return bookmarksDao.getChildren(parentId);
//    }

    // Insert and update methods.
    public void addBookmark(Bookmarks bookmarks) {
        executor.execute(() -> {
            bookmarksDao.addBookmarks(bookmarks);
        });
    }

    public void updateNode(Bookmarks bookmarks) {
        executor.execute(() -> {
            bookmarksDao.updateBookmark(bookmarks);
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
            throw new IllegalStateException("NodeRepository must be initialized");
        }
        return INSTANCE;
    }

}
