package edu.moravian.csci299.bookmarks;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Data access object for the bookmarks in the bookmarks database.
 */
@Dao
public interface BookmarksDao {
    /**
     * Gets all bookmarks in the database.
     *
     * @return a live data view of all bookmarks in the database
     */
    @Query("SELECT * FROM Bookmarks")
    LiveData<List<Bookmarks>> getAllBookmarks();

    /**
     * Gets a single bookmark from the database by its id.
     *
     * @param id
     * @return a live data view of the bookmark from the database
     */
    @Query("SELECT * FROM Bookmarks WHERE id = (:id) LIMIT 1")
    LiveData<Bookmarks> getBookmark(int id);

//    /**
//     * Gets all of the nodes that are the children of a specific node given by its parent id.
//     *
//     * @param parentId the parent id to get the children of, if given -1 this will get all root
//     *                 nodes
//     * @return a live data view of all children nodes that are children of the given parent node
//     */
//    @Query("SELECT * FROM Bookmarks WHERE parentId = (:parentId)")
//    LiveData<List<Node>> getChildren(int parentId);

    /**
     * Add any number of bookmarks to our database. The ... simply lets you specify
     * the argument any number of times.
     */
    @Insert
    void addBookmarks(Bookmarks... bookmarks);

    /**
     * Remove a single bookmark in the database.
     */
    @Delete
    void removeBookmark(Bookmarks bookmarks);

    /**
     * Update an bookmark in the database.
     */
    @Update
    void updateBookmark(Bookmarks bookmarks);
}
