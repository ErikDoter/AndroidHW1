package com.example.homework1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    private final TextView number;
    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        number = itemView.findViewById(R.id.number_item);
    }

    public void bind(ListModel model) {
        number.setText(String.valueOf(model.number));
        number.setTextColor(model.color);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) number.getContext();
                activity.bigNumber(model);
            }
        });
    }
}
