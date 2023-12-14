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

// 임박 재료 털기 레시피
public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        //return inflater.inflate(R.layout.fragment1, container, false);

        LinearLayout btnExpItem1 = view.findViewById(R.id.btnExpItem1);
        LinearLayout btnExpItem2 = view.findViewById(R.id.btnExpItem2);
        LinearLayout btnExpItem3 = view.findViewById(R.id.btnExpItem3);

        btnExpItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when buttonItem1 is clicked
                Toast.makeText(getContext(), "Button 1 clicked", Toast.LENGTH_SHORT).show();
            }
        });


        btnExpItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when buttonItem1 is clicked
                Toast.makeText(getContext(), "Button 2 clicked", Toast.LENGTH_SHORT).show();
            }
        });


        btnExpItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when buttonItem1 is clicked
                Toast.makeText(getContext(), "Button 3 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

