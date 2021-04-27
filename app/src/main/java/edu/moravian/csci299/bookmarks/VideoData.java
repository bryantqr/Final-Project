package edu.moravian.csci299.bookmarks;

public class VideoData implements java.io.Serializable {
    public String source;
    public int width;
    public int height;
    public int type;
    public String vid;

    public VideoData(String source, int width, int height, int type, String vid) {
        this.source = source;
        this.width = width;
        this.height = height;
        this.type = type;
        this.vid = vid;
    }
}
