package edu.moravian.csci299.bookmarks;

import android.content.Context;

import androidx.room.Room;

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

//    // The public methods that simply call the DAO methods.
//    public LiveData<List<Node>> getNodes() {
//        return bookmarksDao.getAllNodes();
//    }
//
//    public LiveData<Node> getNode(int id) {
//        return bookmarksDao.getNode(id);
//    }
//
//    public LiveData<List<Node>> getChildren(int parentId) {
//        return bookmarksDao.getChildren(parentId);
//    }
//
//    // Insert and update methods.
//    public void addNode(Node nodes) {
//        executor.execute(() -> {
//            bookmarksDao.addNodes(nodes);
//        });
//    }
//
//    public void updateNode(Node nodes) {
//        executor.execute(() -> {
//            bookmarksDao.updateNode(nodes);
//        });
//    }

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
