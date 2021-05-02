package edu.moravian.csci299.bookmarks;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.io.Serializable;


/**
 * A fragment that displays a bookmark editor. When a bookmark is clicked, a callback method
 * is called to inform the hosting activity. This allows the bookmark to be edited.
 */
public class BookmarkEditorFragment extends Fragment {
    /**
     * The callbacks that can be called by this fragment on the hosting Activity.
     */
    public interface Callbacks {
        /**
         * Called whenever a bookmark is changed.
         * @param bookmark clicked
         */
        void onBookmarkClicked(Bookmark bookmark);
        void onEditorClicked(Bookmark bookmark);
    }


    // fragment initialization parameters
    private static final String ARG_BOOKMARK = "bookmark";

    // the hosting activity callbacks
    private Callbacks callbacks;



    /**
     * Use this factory method to create a new instance of this fragment that
     * highlights today initially.
     * @return a new instance of fragment BookmarkEditorFragment.
     */
    public static BookmarkEditorFragment newInstance() {
        return newInstance(new Bookmark());
    }

    /**
     * Use this factory method to create a new instance of this fragment that
     * edit bookmarks.
     * @param bookmark the bookmark that is being edit.
     * @return a new instance of fragment BookmarkEditorFragment.
     */
    public static BookmarkEditorFragment newInstance(Bookmark bookmark) {
        BookmarkEditorFragment fragment = new BookmarkEditorFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_BOOKMARK, (Serializable) bookmark);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Create the view of this fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // The date to initially highlight
        //Date date = DateUtils.useDateOrNow((Date) getArguments().getSerializable(ARG_DATE));
        //callbacks.onDayChanged(date);

        // Inflate the layout for this fragment
        View base = inflater.inflate(R.layout.fragment_bookmark, container, false);
        // TODO: Setup the calendar

        //CalendarView calendarView = base.findViewById(R.id.calendarView);
//        calendarView.setDate(date.getTime());
//        calendarView.setOnDateChangeListener(this);

        // Return the base view
        return base;
    }



    /**
     * When attaching to a hosting activity, use that context for the callbacks.
     * @param context the hosting activity context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbacks = (Callbacks)context;
    }

    /**
     * When detaching from a hosting activity, remove the callbacks.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }
}

