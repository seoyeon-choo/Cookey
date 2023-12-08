package kr.ac.duksung.cookey_bottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View.OnClickListener;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        //return inflater.inflate(R.layout.fragment1, container, false);

        LinearLayout btnShortItem1 = view.findViewById(R.id.btnShortItem1);
        LinearLayout btnShortItem2 = view.findViewById(R.id.btnShortItem2);
        LinearLayout btnShortItem3 = view.findViewById(R.id.btnShortItem3);

        btnShortItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when buttonItem1 is clicked
                Toast.makeText(getContext(), "Button 1 clicked", Toast.LENGTH_SHORT).show();
            }
        });


        btnShortItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when buttonItem1 is clicked
                Toast.makeText(getContext(), "Button 2 clicked", Toast.LENGTH_SHORT).show();
            }
        });


        btnShortItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when buttonItem1 is clicked
                Toast.makeText(getContext(), "Button 3 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

