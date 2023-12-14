package kr.ac.duksung.cookey_bottom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LookActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FrequentlyAdapter adapter;
    private List<FrequentlyItem> dataList;
    private FloatingActionButton addButton;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);

        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the data list
        dataList = new ArrayList<>();
        dataList.add(new FrequentlyItem("감자", 1, "2023-12-05", "9일", "20일","po"));
        dataList.add(new FrequentlyItem("달걀", 8, "2023-12-14", "9일", "10일", "egg"));
        dataList.add(new FrequentlyItem("닭고기", 1, "2023-12-14", "1일", "2일", "chi"));
        dataList.add(new FrequentlyItem("당근", 1, "2023-12-13", "18일", "20일", "carrot"));
        dataList.add(new FrequentlyItem("브로콜리", 1, "2023-12-14", "4일", "5일", "broccoli"));
        dataList.add(new FrequentlyItem("소고기", 3, "2023-12-14", "4일", "5일", "beef"));
        dataList.add(new FrequentlyItem("순두부", 1, "2023-12-14", "13일", "14일", "bean"));
        dataList.add(new FrequentlyItem("치즈", 3, "2023-12-14", "69일", "70일", "che"));
        dataList.add(new FrequentlyItem("토마토", 2, "2023-12-14", "6일", "7일", "tomato"));

//        //임시 Intent
//        Intent intent = new Intent(getApplicationContext(), FrequentlyAdapter.class);
//        intent.putExtra("food", (CharSequence) dataList.get(0));
//        startActivity(intent);

        // Set up RecyclerView
        adapter = new FrequentlyAdapter(dataList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        //쿡키 버튼을 누를 때 메인 페이지로 돌아가기
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finish the current activity (MypageActivity) and start MainActivity
                Intent intent = new Intent(LookActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //네비게이션 바 아이콘 페이지로 이동
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.cook) {
                    // 냉장고 털기 페이지로 이동
                    startActivity(new Intent(LookActivity.this, RecipeActivity.class));
                } else if (item.getItemId() == R.id.cart) {
                    // 원터치 주문 페이지로 직접 URL로 이동
                    String url = "https://www.kurly.com/main";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else if (item.getItemId() == R.id.my) {
                    // 마이페이지로 이동
                    startActivity(new Intent(LookActivity.this, MypageActivity.class));
                }
                return true;
            }
        });
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
