package com.example.telovendo.activities;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telovendo.R;

public class FloresDetailFragment extends Fragment {
    public static String floresNombre;

    public FloresDetailFragment() {
          }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_flores_detail, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            floresNombre = bundle.getString("floresNombre");
        } else {
            floresNombre = "Dalia (PD)";
        }
        TextView nameFloresText = (TextView)
                getView().findViewById(R.id.nombreFloresText);

        nameFloresText.setText(floresNombre);

        TextView descriptionFloresText = (TextView)
                getView().findViewById(R.id.descripcionTextoFlores);
            descriptionFloresText.setMovementMethod(new
                ScrollingMovementMethod());
    }
}
