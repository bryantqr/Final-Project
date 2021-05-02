package edu.moravian.csci299.bookmarks;


/**
 *  An Item status object contains all of the information about the item.
 */
public enum ItemStatus {
    DEFAULT(0),
    ARCHIVED(1),
    DELETED(2);

    private int value;

    ItemStatus(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
