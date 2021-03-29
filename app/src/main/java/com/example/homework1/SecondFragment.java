package com.example.homework1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    int number;
    int color;
    public SecondFragment(ListModel model) {
        number = model.number;
        color = model.color;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.big_number, container, false);
        TextView text = v.findViewById(R.id.number);
        text.setText(String.valueOf(number));
        text.setTextColor(color);
        return v;
    }
}
