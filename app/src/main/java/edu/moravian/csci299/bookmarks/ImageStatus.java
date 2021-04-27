package edu.moravian.csci299.bookmarks;

public enum ImageStatus {
    NO_IMAGE(0),
    HAS_IMAGE(1),
    IS_IMAGE(2);

    private int value;

    ImageStatus(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
