package edu.moravian.csci299.bookmarks;

import android.content.Context;
import android.net.Uri;
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

import edu.moravian.csci299.bookmark.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    public interface Callbacks {
        /**
         * The callback that is called by this fragment when a bookmark is clicked on the hosting
         * activity
         * @param uri the uri of the bookmark clicked
         */
        void onBookmarkClicked(Uri uri);

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

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_URI = "uri";

    private List<Bookmark> bookmarks = Collections.emptyList(); //list of bookmark items
    private RecyclerView list;
    private Uri uri; //resolved_url
    private Callbacks callbacks;

    //public static ListFragment newInstance() { return newInstance(new Bookmark());}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param uri uri of bookmark to be listed.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        //args.putParcelable(ARG_URI, uri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        uri = getArguments().getParcelable(ARG_URI);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View base = inflater.inflate(R.layout.fragment_list, container, false);

        BookmarkViewAdapter adapter = new BookmarkViewAdapter();
        list = base.findViewById(R.id.list_view);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BookmarkViewAdapter();
        list.setAdapter(adapter);

        return base;
    }

    private class BookmarkViewHolder extends RecyclerView.ViewHolder {
        Bookmark bookmark;
        Uri uri;
        TextView bookmarkView;

        public BookmarkViewHolder(@NonNull View itemView)
        {
            super(itemView);
            bookmarkView = itemView.findViewById(R.id.bookmarkView);
            itemView.setOnClickListener(v -> callbacks.onBookmarkClicked(uri));
        }

        public void bind(Bookmark bookmark) {
            bookmarkView.setText(bookmark.resolvedTitle);
            this.bookmark = bookmark;
        }
    }

    private class BookmarkViewAdapter extends RecyclerView.Adapter<BookmarkViewHolder> {

        @NonNull
        @Override
        public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_item ,parent, false);
            return new BookmarkViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
            holder.bind(bookmarks.get(position));
        }

        @Override
        public int getItemCount() {
            return bookmarks.size();
        }
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
     * Handle a menu option being selected.
     * @param item the item being selected
     * @return true if the menu item selection was handled, false otherwise
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            callbacks.onSettingsClicked();
            return true;
        } else if (item.getItemId() == R.id.new_bookmark) {
            Bookmark bookmark = new Bookmark();
            BookmarksRepository.get().addBookmark(bookmark);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}