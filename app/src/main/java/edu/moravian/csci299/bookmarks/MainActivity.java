package edu.moravian.csci299.bookmarks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListFragment.Callbacks {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment parent = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (parent == null) {
            ListFragment listFragment = ListFragment.newInstance();
            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, listFragment)
                .commit();
        }
    }

    @Override
    public void onBookmarkClicked(Bookmark bookmark) {
        /*
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, WebViewFragment.newInstance())
            .addToBackStack(null)
            .commit();
         */
    }

    @Override
    public void onSettingsClicked() {
        /*
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, SettingsBookmarkFragment.newInstance())
            .addToBackStack(null)
            .commit();
         */
    }

    @Override
    public void onEditorClicked(Bookmark bookmark) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, BookmarkEditorFragment.newInstance(bookmark))
            .addToBackStack(null)
            .commit();
    }
}
