package edu.moravian.csci299.bookmarks;

/**
 *  An Image status object contains all of the information about the image status.
 */
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
