package com.example.tripplanner.plan;

import android.content.Context;

import java.util.List;

public class CustomListAdapter {
    private final Context context;
    private final List<ListItem> items;

    public CustomListAdapter(Context context, List<ListItem> items) {
        this.context = context;
        this.items = items;
    }
    
}