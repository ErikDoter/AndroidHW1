package com.example.homework1;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.TtsSpan;
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), getResources().getConfiguration().orientation + 2));
        ListAdapter adapter = new ListAdapter();
        recyclerView.setAdapter(adapter);
        Button button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.elements % 2 == 0) {
                    adapter.data.add(new ListModel(adapter.elements + 1, Color.BLUE));
                } else {
                    adapter.data.add(new ListModel(adapter.elements + 1, Color.RED));
                }
                adapter.notifyDataSetChanged();
                adapter.elements++;
            }
        });
        return v;
    }
}
