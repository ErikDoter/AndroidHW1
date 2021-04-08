package com.example.homework1;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FirstFragment extends Fragment {
    private int count = 100;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("fragment", "onCreate: ssssss");
        if(savedInstanceState != null) {
            count = savedInstanceState.getInt("countNumber", 100);
        }
        View v = inflater.inflate(R.layout.activity_main, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), getResources().getConfiguration().orientation + 2));
        ListAdapter adapter = new ListAdapter(count);
        recyclerView.setAdapter(adapter);
        Button button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = adapter.data.size();
                if (adapter.data.size() % 2 == 0) {
                    adapter.data.add(new ListModel(adapter.data.size() + 1, Color.BLUE));
                } else {
                    adapter.data.add(new ListModel(adapter.data.size() + 1, Color.RED));
                }
                adapter.notifyItemInserted(position);
                count++;
            }
        });
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("countNumber", count);
    }
}
