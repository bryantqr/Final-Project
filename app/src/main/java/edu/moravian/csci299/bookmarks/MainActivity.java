package edu.moravian.csci299.bookmarks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import static android.content.ContentResolver.setIsSyncable;

public class MainActivity extends AppCompatActivity implements ListFragment.Callbacks {
    public static final String AUTHORITY = "edu.moravian.csci299.bookmarks.provider";
    public static final String ACCOUNT_TYPE = "getpocket.com";
    public static final String ACCOUNT = "placeholderaccount";
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        account = CreateSyncAccount(this);
        sync();

        Fragment parent = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (parent == null) {
            ListFragment listFragment = ListFragment.newInstance();
            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, listFragment)
                .commit();
        }
    }

    /**
     * Create a new placeholder account for the sync adapter
     * @param context The application context
     */
    private static Account CreateSyncAccount(Context context) {
        AccountManager manager = (AccountManager) context.getSystemService(ACCOUNT_SERVICE);
        Account newAccount = new Account(ACCOUNT, ACCOUNT_TYPE);

        boolean success = manager.addAccountExplicitly(newAccount, null, null);
        if (success) {
            setIsSyncable(newAccount, AUTHORITY, 1);
        } else {
            Log.e("MainActivity", "Could not create account.");
        }
        return newAccount;
    }

    private void sync() {
        Bundle settingsBundle = new Bundle();
        settingsBundle.putBoolean(
                ContentResolver.SYNC_EXTRAS_MANUAL, true);
        settingsBundle.putBoolean(
                ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        ContentResolver.requestSync(account, AUTHORITY, settingsBundle);
    }

    @Override
    public void onBookmarkClicked(Bookmark bookmark) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, WebViewFragment.newInstance())
            .addToBackStack(null)
            .commit();
    }

    @Override
    public void onSettingsClicked() {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, SettingsFragment.newInstance())
            .addToBackStack(null)
            .commit();
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
