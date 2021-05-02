package edu.moravian.csci299.bookmarks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.net.Uri;
import android.os.Bundle;

import edu.moravian.csci299.bookmark.R;

public class MainActivity extends AppCompatActivity implements ListFragment.Callbacks{
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        listFragment = (ListFragment)fragmentManager.findFragmentByTag("list");
        if (listFragment == null) {
            listFragment = ListFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, listFragment, "list")
                    .commit();
        }
    }

    @Override
    public void onBookmarkClicked(Uri uri) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, WebViewFragment.newInstance(uri))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSettingsClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SettingsBookmarkFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onEditorClicked(Bookmark bookmark) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, BookmarkEditorFragment.newInstance(bookmark))
                .addToBackStack(null)
                .commit();
    }

}