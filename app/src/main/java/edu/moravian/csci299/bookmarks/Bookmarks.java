package edu.moravian.csci299.bookmarks;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bookmarks {
    @PrimaryKey
    public int id;
    public String name;
}
