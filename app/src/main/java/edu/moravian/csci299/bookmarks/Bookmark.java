package edu.moravian.csci299.bookmarks;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 *  A Bookmark object contains all of the information about the bookmark.
 */

@Entity
public class Bookmark implements Serializable {
    @PrimaryKey
    @NonNull
    public String  itemId;
    public String  resolvedId;
    public String givenUrl;
    public String resolvedUrl;
    public String givenTitle;
    public String resolvedTitle;
    public boolean isFavorite;
    public ItemStatus status;
    public String excerpt;
    public boolean isArticle;
    public ImageStatus imageStatus;
    public VideoStatus videoStatus;
    public int wordCount;
    public String[] tags;
    public String[] authors;
    public ImageData[] images;
    public VideoData[] videos;
}
