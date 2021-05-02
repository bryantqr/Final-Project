package edu.moravian.csci299.bookmarks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * A bound Service that instantiates the authenticator
 * when started.
 */
public class AuthenticatorService extends Service {
    private PocketAccountAuthenticator authenticator;

    @Override
    public void onCreate() {
        authenticator = new PocketAccountAuthenticator(this);
        Log.d("AService", "onCreate()");
    }

    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
}
