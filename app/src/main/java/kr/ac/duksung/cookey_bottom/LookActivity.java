package kr.ac.duksung.cookey_bottom;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LookActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FrequentlyAdapter adapter;
    private List<FrequentlyItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);

        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the data list
        dataList = new ArrayList<>();
        dataList.add(new FrequentlyItem("양파", 5, "2023-12-31", "10일", "1주"));
        dataList.add(new FrequentlyItem("당근", 3, "2023-12-25", "2일", "3일"));

        // Set up RecyclerView
        adapter = new FrequentlyAdapter(dataList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_default) {
            // 기본 정렬
        } else if (id == R.id.action_alphabetical) {
            // 알파벳순 정렬
            sortAlphabetically();
        } else if (id == R.id.action_frequent) {
            // 빈도순 정렬
            sortFrequently();
        }

        // Notify the adapter that the data set has changed
        adapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }


    private void sortAlphabetically() {
        // Sort alphabetically by ingredient name
        Collections.sort(dataList, new Comparator<FrequentlyItem>() {
            @Override
            public int compare(FrequentlyItem item1, FrequentlyItem item2) {
                return item1.getIngredientName().compareTo(item2.getIngredientName());
            }
        });
    }

    private void sortFrequently() {
        // Sort by frequency (you can customize the sorting logic based on your requirements)
        // For now, let's just reverse the order
        Collections.reverse(dataList);
    }
}
