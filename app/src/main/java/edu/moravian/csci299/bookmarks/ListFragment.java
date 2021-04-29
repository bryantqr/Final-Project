package edu.moravian.csci299.bookmarks;

public class ListFragment {

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.io.Serializable;
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
        void onBookmarkClicked(Bookmark bookmark);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BOOKMARK = "bookmark";
    private static final String ARG_ID = "id";
    private static final String ARG_URL = "url";

    // TODO: Rename and change types of parameters
    private List<Bookmark> bookmarks = Collections.emptyList(); //list of bookmark items
    private String id; //resolved_id
    private String url; //resolved_url
    private Bookmark bookmark; //bookmark item
    private WebView webView; //WebView to be shown
    private RecyclerView list_view;


    private Callbacks callbacks;

    public static ListFragment newInstance() { return newInstance(new Bookmark());}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param bookmark bookmark to be listed.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(Bookmark bookmark) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_BOOKMARK, (Serializable)bookmark);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookmark = (Bookmark) getArguments().getSerializable(ARG_BOOKMARK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        list_view = v.findViewById(R.id.list_view);
        list_view.setLayoutManager(new LinearLayoutManager(getContext()));
        list_view.setAdapter(new BookmarkAdapter());

        webView = v.findViewById(R.id.bookmarkWebView);

        return v;
    }

    private class BookmarkViewHolder extends RecyclerView.ViewHolder {
        Bookmark bookmark;

        public BookmarkViewHolder(@NonNull View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(v -> callbacks.onBookmarkClicked(bookmark));
        }

        public void bind(Bookmark bookmark) {
            this.bookmark = bookmark;
        }
    }

    private class BookmarkAdapter extends RecyclerView.Adapter<BookmarkViewHolder> {

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
}
