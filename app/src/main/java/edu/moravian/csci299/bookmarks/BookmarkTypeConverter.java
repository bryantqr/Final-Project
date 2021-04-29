package edu.moravian.csci299.bookmarks;

import androidx.room.TypeConverter;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Supports converting Date to/from Long and Quality to/from String.
 */
public class BookmarkTypeConverter {
    private final String STRING_ARRAY_SEPARATOR = ";";

    @TypeConverter
    public int fromItemStatus(ItemStatus status) {
        if (status == null) { return 0; }
        return status.getValue();
    }

    @TypeConverter
    public ItemStatus toItemStatus(int index) {
        return ItemStatus.values()[index];
    }

    @TypeConverter
    public int fromImageStatus(ImageStatus status) {
        if (status == null) { return 0; }
        return status.getValue();
    }

    @TypeConverter
    public ImageStatus toImageStatus(int index) {
        return ImageStatus.values()[index];
    }

    @TypeConverter
    public int fromVideoStatus(VideoStatus status) {
        if (status == null) { return 0; }
        return status.getValue();
    }

    @TypeConverter
    public VideoStatus toVideoStatus(int index) {
        return VideoStatus.values()[index];
    }

    @TypeConverter
    public String fromStringArray(String[] array) {
        if (array == null) { return ""; }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++)
        {
            builder.append(array[i]);
            if (i < array.length - 1)
                builder.append(STRING_ARRAY_SEPARATOR);
        }
        return builder.toString();
    }

    @TypeConverter
    public String[] toStringArray(String value) {
        return value.split(STRING_ARRAY_SEPARATOR);
    }

    @TypeConverter
    public String fromImageDataArray(ImageData[] array)
    {
        return null;
    }

    @TypeConverter
    public ImageData[] toImageDataArray(String value)
    {
        return null;
    }

    @TypeConverter
    public String fromVideoDataArray(VideoData[] array)
    {
        return null;
    }

    @TypeConverter
    public VideoData[] toVideoDataArray(String value)
    {
        return null;
    }

    @TypeConverter
    public Bookmark toBookmark(String value) { return null; }

    @TypeConverter
    public String fromBookmark(Bookmark bookmark) { return null; }
}
