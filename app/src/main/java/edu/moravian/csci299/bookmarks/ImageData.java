package edu.moravian.csci299.bookmarks;

public class ImageData implements java.io.Serializable {
    public String source;
    public int width;
    public int height;
    public String credit;
    public String caption;

    public ImageData(String source, int width, int height, String credit, String caption) {
        this.source = source;
        this.width = width;
        this.height = height;
        this.credit = credit;
        this.caption = caption;
    }
}
