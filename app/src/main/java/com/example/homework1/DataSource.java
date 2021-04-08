package com.example.homework1;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSource {
    private final List<ListModel> mData;
    private static DataSource sInstance;

    public DataSource(int count) {
        mData = new ArrayList<ListModel>();
        for (int i = 1; i < count + 1; i++) {
            int color;
            if (i % 2 == 0) {
                color = Color.RED;
            } else {
                color = Color.BLUE;
            };
            mData.add(new ListModel(i, color));
        }
    }

    public List<ListModel> getRemoteData() {
        return mData;
    }

    public synchronized static DataSource getInstance(int count) {
        if (sInstance == null) {
            sInstance = new DataSource(count);
        }
        return sInstance;
    }
}
