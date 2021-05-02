package edu.moravian.csci299.bookmarks;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.io.Serializable;
import java.util.UUID;

/**
 * A fragment that displays a bookmark editor. When a bookmark is clicked, a callback method
 * is called to inform the hosting activity. This allows the bookmark to be edited.
 */
public class BookmarkEditorFragment extends Fragment implements TextWatcher {
    /** needed to be implemented */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    /** needed to be implemented */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    /**
     * updates bookmark after text changes.
     * @param s the Editable that changed.
     */
    @Override
    public void afterTextChanged(Editable s) {
        this.bookmark.givenTitle = s.toString();
    }

    /**
     * Updates the UI to match the bookmark.
     */
    private void updateUI() {
        nameView.setText(bookmark.givenTitle);
    }

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

    private EditText nameView;
    private Bookmark bookmark;

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
        args.putSerializable(ARG_BOOKMARK, bookmark);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Initializes bookmark field from arguments object.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookmark = (Bookmark) getArguments().getSerializable(ARG_BOOKMARK);
    }

    /**
     * Create the view of this fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View base = inflater.inflate(R.layout.fragment_bookmark, container, false);

        nameView = base.findViewById(R.id.bookmarkName);
        nameView.addTextChangedListener(this);
        updateUI();

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

    /**
     * updates the database with the edited bookmark.
     */
    @Override
    public void onStop() {
        super.onStop();
        BookmarksRepository.get().updateBookmark(bookmark);
    }
}
