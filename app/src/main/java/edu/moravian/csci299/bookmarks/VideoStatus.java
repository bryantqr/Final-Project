package edu.moravian.csci299.bookmarks;

public enum VideoStatus {
    NO_VIDEO(0),
    HAS_VIDEO(1),
    IS_VIDEO(2);

    private int value;

    VideoStatus(int value) {
        this.value = value;
    }
}
