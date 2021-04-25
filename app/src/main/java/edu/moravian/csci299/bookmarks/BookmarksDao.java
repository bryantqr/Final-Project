package edu.moravian.csci299.bookmarks;

import androidx.room.Dao;

/**
 * Data access object for the nodes in the hierarchical database.
 */
@Dao
public interface BookmarksDao {
//    /**
//     * Gets all bookmarks in the database.
//     *
//     * @return a live data view of all bookmarks in the database
//     */
//    @Query("SELECT * FROM Bookmarks")
//    LiveData<List<Bookmarks>> getAllBookmarks();
//
//    /**
//     * Gets a single node from the database by its id.
//     *
//     * @param id
//     * @return a live data view of the node from the database
//     */
//    @Query("SELECT * FROM Node WHERE id = (:id) LIMIT 1")
//    LiveData<Node> getNode(int id);
//
//    /**
//     * Gets all of the nodes that are the children of a specific node given by its parent id.
//     *
//     * @param parentId the parent id to get the children of, if given -1 this will get all root
//     *                 nodes
//     * @return a live data view of all children nodes that are children of the given parent node
//     */
//    @Query("SELECT * FROM Node WHERE parentId = (:parentId)")
//    LiveData<List<Node>> getChildren(int parentId);
//
//    /**
//     * Add any number of nodes to our database. The ... simply lets you specify
//     * the argument any number of times.
//     */
//    @Insert
//    void addNodes(Node... node);
//
//    /**
//     * Remove a single item in the database.
//     */
//    @Delete
//    void removeNode(Node node);
//
//    /**
//     * Update an item in the database.
//     */
//    @Update
//    void updateNode(Node node);
}
