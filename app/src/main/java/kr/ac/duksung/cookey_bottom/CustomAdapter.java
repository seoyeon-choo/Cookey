package kr.ac.duksung.cookey_bottom;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> items;

    public CustomAdapter(Context context, ArrayList<String> items) {
        super(context, R.layout.list_item_layout, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_layout, parent, false);

        // Find views in the layout
        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView textView = rowView.findViewById(R.id.textView);

        // Set data to views
        textView.setText(items.get(position));
        // Set image
        imageView.setImageResource(R.drawable.pic);

        return rowView;
    }
}

