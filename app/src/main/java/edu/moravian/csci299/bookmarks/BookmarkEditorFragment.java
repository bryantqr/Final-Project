package edu.moravian.csci299.bookmarks;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Date;
import java.util.UUID;

/**
 * The fragment for a single event. It allows editing all of the details of the event, either with
 * text edit boxes (for the name and description) or popup windows (for the date, start time,
 * time and type). The event is not updated in the database until the user leaves this fragment.
 */
public class BookmarkEditorFragment extends Fragment {
    private static final String ARG_NAME = "Name";
    private static final String ARG_EVENT_ID = "event_id";
    private static final String ARG_URL = "Url";
//    private static final int REQUEST_DATE = 0;
//    private static final int REQUEST_TIME = 1;
//    private static final int REQUEST_EVENT_TYPE = 2;

    private Bookmark bookmark;

    private ImageView typeView;
    private TextView dateView;

    private EditText descriptionView;


    public static BookmarkEditorFragment newInstance(Bookmark bookmark) {
        BookmarkEditorFragment fragment = new BookmarkEditorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Upon creation load the data. Once the data is loaded, update the UI.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        updateUI();
    }

    /**
     * Create the view from the layout, save references to all of the important
     * views within in, then hook up the listeners.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View base = inflater.inflate(R.layout.activity_main, container, false);
//
//        typeView = base.findViewById(R.id.eventType);
//        typeView.setOnClickListener(v -> showEventTypePicker());
//        nameView = base.findViewById(R.id.eventName);
//        nameView.addTextChangedListener(this);
//        dateView = base.findViewById(R.id.eventDate);
//        dateView.setOnClickListener(v -> showDatePicker());
//        startTimeView = base.findViewById(R.id.eventStartTime);
//        startTimeView.setOnClickListener(v -> showTimePicker(true));
//        tillView = base.findViewById(R.id.till);
//        endTimeView = base.findViewById(R.id.eventEndTime);
//        endTimeView.setOnClickListener(v -> showTimePicker(false));
//        descriptionView = base.findViewById(R.id.eventDescription);
//        descriptionView.addTextChangedListener(this);

        return base;
    }

    /**
     * When the fragment is stopped we need to update the event in the database.
     */
    @Override
    public void onStop() {
        super.onStop();
        BookmarksRepository.get().updateBookmark(this.bookmark);
    }

    /**
     * Show the event type picker dialog.
     */
//    private void showEventTypePicker() {
//        EventTypePickerFragment picker = EventTypePickerFragment.newInstance(event.type);
//        picker.setTargetFragment(this, REQUEST_EVENT_TYPE);
//        picker.show(requireFragmentManager(), DIALOG_EVENT_TYPE);
//    }

    /**
     * When a new event type is picked on the event type picker dialog we
     * update the type of the event.
     * @param type the event type to update to
     */
//    @Override
//    public void onTypeSelected(EventType type) {
//        event.type = type;
//        updateUI();
//    }

    /**
     * Show the date picker dialog.
     */
//    private void showDatePicker() {
//        DatePickerFragment picker = DatePickerFragment.newInstance(event.startTime);
//        picker.setTargetFragment(this, REQUEST_DATE);
//        picker.show(requireFragmentManager(), DIALOG_DATE);
//    }

    /**
     * When a new date is picked on the date picker dialog we update the start
     * and end times to use the new date but keep the same time.
     * @param date the date to update to
     */
//    @Override
//    public void onDateSelected(Date date) {
//        event.startTime = DateUtils.combineDateAndTime(date, event.startTime);
//        if (event.endTime != null) {
//            event.endTime = DateUtils.combineDateAndTime(date, event.endTime);
//        }
//        updateUI();
//    }

    /**
     * Show the time picker dialog.
     * @param isStartTime if we are picking the start or end time
     */
//    private void showTimePicker(boolean isStartTime) {
//        TimePickerFragment picker = TimePickerFragment.newInstance(isStartTime, isStartTime ? event.startTime : event.endTime);
//        picker.setTargetFragment(this, REQUEST_TIME);
//        picker.show(requireFragmentManager(), DIALOG_TIME);
//    }

    /**
     * When a time is selected on the time picker dialog, update the start
     * and/or end times. This also handles keeping the end time appropriate
     * based on the start time (if the start time changes, the end time is kept
     * the same distance away from it, if the end time changes, it is 'fixed'
     * to make sure it is actually after the start time and within 1 day).
     *
     * @param isStartTime if we are setting the start or end time directly
     * @param time the time we are setting the start or end time to
     */
//    @Override
//    public void onTimeSelected(boolean isStartTime, Date time) {
//        if (isStartTime) {
//            Date origStartTime = event.startTime;
//            event.startTime = DateUtils.combineDateAndTime(origStartTime, time);
//            if (event.endTime != null) {
//                event.endTime = DateUtils.getNewEndTime(origStartTime, event.startTime, event.endTime);
//            }
//        } else {
//            event.endTime = DateUtils.fixEndTime(event.startTime, time);
//        }
//        updateUI();
//    }

    /** Updates the UI to match the event. */
    private void updateUI() {
//        typeView.setImageResource(event.type.iconResourceId);
//        nameView.setText(event.name);
//        dateView.setText(DateUtils.toFullDateString(event.startTime));
//        startTimeView.setText(DateUtils.toTimeString(event.startTime));
//        if (event.endTime == null) {
//            tillView.setVisibility(View.INVISIBLE);
//            endTimeView.setVisibility(View.INVISIBLE);
//        } else {
//            tillView.setVisibility(View.VISIBLE);
//            endTimeView.setVisibility(View.VISIBLE);
//            endTimeView.setText(DateUtils.toTimeString(event.endTime));
//        }
//        descriptionView.setText(event.description);
    }

}


