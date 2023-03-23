package com.example.telovendo.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.telovendo.R;

public class HomeFragment extends Fragment {
        private static final String HOLA_STATE_KEY="HOLA_KEY";
        private static final String TEXT_VIEW_KEY ="TEXT_KEY";
        private static final String TAG = "HomeFragment";

        private NavController navController;

    TextView textView;
    String holaState;
    String textViewText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textViewText = getResources().getString(R.string.textView_text);
        holaState = "0";

        if (savedInstanceState != null) {
            holaState = savedInstanceState.getString(HOLA_STATE_KEY);
            textViewText = savedInstanceState.getString(TEXT_VIEW_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        textView = (TextView) getView().findViewById(R.id.textView);
        textView.setText(textViewText);

        Button buttonIngreso = (Button) getView().findViewById(R.id.buttonIngreso);
        buttonIngreso.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int holaStateInt = Integer.parseInt(holaState);
                holaStateInt++;
                textViewText = textViewText.split(" - ")[0] + " - " + holaStateInt;
                holaState = String.valueOf(holaStateInt);
                textView.setText(textViewText);
            }
        });
                 Button InfoButton = (Button) getView().findViewById(R.id.info_button);

        InfoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }
        @Override
        public void onSaveInstanceState(Bundle outState) {
            outState.putString(HOLA_STATE_KEY, holaState);
            Log.d(TAG, "onSaveInstanceState:: holaState: " + holaState);
            outState.putString(TEXT_VIEW_KEY, textViewText);

            super.onSaveInstanceState(outState);

        }

    }