
package edu.moravian.csci299.bookmarks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        listFragment = (ListFragment)fragmentManager.findFragmentByTag("list");
//        if (listFragment == null) {
//            BookmarkFragment calendarFragment = BookmarkFragment.newInstance();
//            listFragment = ListFragment.newInstance();
//            fragmentManager.beginTransaction()
//                    .add(R.id.fragment_container, calendarFragment, "calendar")
//                    .add(R.id.fragment_container, listFragment, "list")
//                    .commit();
//
        }
}


//    /**
//     * When a day is changed in the calendar, update the list to show the events on that day.
//     * @param date the date that was clicked
//     */
//    @Override
//    public void onDayChanged(Date date) {
//        listFragment.setDay(date);
//    }
//
//    /**
//     * The
//     * @param event
//     */
//    @Override
//    public void onEventClicked(Event event) {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, EventFragment.newInstance(event))
//                .addToBackStack(null)
//                .commit();
//    }