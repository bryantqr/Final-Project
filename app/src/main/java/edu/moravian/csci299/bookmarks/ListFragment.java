package edu.moravian.csci299.bookmarks;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * A Fragment that displays a list of bookmarks added by the user. Its list is a RecyclerView, and when a
 * bookmark is clicked, it will open a WebView of wherever the bookmark is linked to.
 */
public class ListFragment extends Fragment {
    public interface Callbacks {
        /**
         * The callback that is called by this fragment when a bookmark is clicked on the hosting
         * activity
         * @param bookmark the bookmark clicked
         */
        void onBookmarkClicked(Bookmark bookmark);

        /**
         * The callback that is called by this fragment when the setting icon on the menu
         * is clicked on the hosting activity
         */
        void onSettingsClicked();

        /**
         * The callback that is called by this fragment when the bookmark editor is clicked on the hosting
         * activity
         * @param bookmark
         */
        void onEditorClicked(Bookmark bookmark);
    }

    private List<Bookmark> bookmarks = Collections.emptyList();
    private RecyclerView list;
    private Callbacks callbacks;

    /**
<<<<<<< HEAD
     * The factory method to create a new instance of
     * this fragment.
=======
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
>>>>>>> master
     * @return A new instance of fragment ListFragment.
     */
    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private void onChange() {
        BookmarksRepository.get().getBookmarks().observe(this, (bookmarks) -> {
            this.bookmarks = bookmarks;
            list.getAdapter().notifyDataSetChanged();
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onChange();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View base = inflater.inflate(R.layout.fragment_list, container, false);

        BookmarkListAdapter adapter = new BookmarkListAdapter();
        list = base.findViewById(R.id.list_view);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(adapter);

        return base;
    }

    /**
     * Set the callbacks to the hosting context.
     * @param context the hosting activity context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbacks = (Callbacks)context;
    }

    /**
     * Set the callbacks to null.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    /**
     * Create the options menu items.
     * @param menu the menu to add the items to
     * @param inflater the inflater to inflate the menu XML with
     */
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.settings_bookmark_menu, menu);
    }

    /**
     * Handle a menu option being selected. Options are either the settings, or adding a new bookmark.
     * @param item the item being selected
     * @return true if the menu item selection was handled, false otherwise
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            callbacks.onSettingsClicked();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class BookmarkViewHolder extends RecyclerView.ViewHolder {
        private Bookmark bookmark;
        private final TextView textView;

        public BookmarkViewHolder(@NonNull View itemView)
        {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(v -> callbacks.onBookmarkClicked(bookmark));
        }

        public void bind(Bookmark bookmark) {
            this.bookmark = bookmark;
            textView.setText(bookmark.resolvedTitle);
        }
    }

    private class BookmarkListAdapter extends RecyclerView.Adapter<BookmarkViewHolder> {
        @NonNull
        @Override
        public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.bookmark_item ,parent, false);

            return new BookmarkViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
            Bookmark bookmark = bookmarks.get(position);
            holder.bind(bookmark);
        }

        @Override
        public int getItemCount() {
            return bookmarks.size();
        }
    }
}
