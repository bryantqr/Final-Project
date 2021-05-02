package edu.moravian.csci299.bookmarks;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.content.res.Resources;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private SwitchCompat darkMode = null;
    private TextView selectLanguage;
    private Button english;
    private Button portuguese;
    private Button spanish;
    private Button italian;
    private Button french;

    private Context context;
    private Resources resources;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        darkMode = v.findViewById(R.id.darkMode);
        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (darkMode.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        selectLanguage = v.findViewById(R.id.selectLanguage);
        english = v.findViewById(R.id.English);
        portuguese = v.findViewById(R.id.Portuguese);
        spanish = v.findViewById(R.id.Spanish);
        italian = v.findViewById(R.id.Italian);
        french = v.findViewById(R.id.French);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = LocaleHelper.setLocale(getContext(), "en");
                resources = context.getResources();
                selectLanguage.setText(resources.getString(R.string.language));
            }
        });

        portuguese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = LocaleHelper.setLocale(getContext(), "pt");
                resources = context.getResources();
                selectLanguage.setText(resources.getString(R.string.language));
            }
        });

        spanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = LocaleHelper.setLocale(getContext(), "es");
                resources = context.getResources();
                selectLanguage.setText(resources.getString(R.string.language));
            }
        });

        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = LocaleHelper.setLocale(getContext(), "it");
                resources = context.getResources();
                selectLanguage.setText(resources.getString(R.string.language));
            }
        });

        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = LocaleHelper.setLocale(getContext(), "fr");
                resources = context.getResources();
                selectLanguage.setText(resources.getString(R.string.language));
            }
        });

        return v;
    }
}