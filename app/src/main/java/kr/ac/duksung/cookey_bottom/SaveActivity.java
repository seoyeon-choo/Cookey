package kr.ac.duksung.cookey_bottom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SaveActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private FloatingActionButton addButton;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        List<RecipeItem> recipeItems = new ArrayList<>();
        recipeItems.add(new RecipeItem("Recipe 1", "Recipe content 1"));
        recipeItems.add(new RecipeItem("Recipe 2", "Recipe content 2"));
        recipeItems.add(new RecipeItem("Recipe 3", "Recipe content 3"));

        // Set up the adapter
        adapter = new MyAdapter(recipeItems);
        recyclerView.setAdapter(adapter);

        //쿡키 버튼을 누를 때 메인 페이지로 돌아가기
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finish the current activity (MypageActivity) and start MainActivity
                Intent intent = new Intent(SaveActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //네비게이션 바 아이콘 페이지로 이동
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.refrigerator) {
                    // 냉장고 페이지로 이동
                    startActivity(new Intent(SaveActivity.this, LookActivity.class));
                } else if (item.getItemId() == R.id.cook) {
                    // 냉장고 털기 페이지로 이동
                    startActivity(new Intent(SaveActivity.this, RecipeActivity.class));
                } else if (item.getItemId() == R.id.cart) {
                    // 원터치 주문 페이지로 직접 URL로 이동
                    String url = "https://www.kurly.com/main";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else if (item.getItemId() == R.id.my) {
                    // 마이페이지로 이동
                    startActivity(new Intent(SaveActivity.this, MypageActivity.class));
                }
                return true;
            }
        });

    }

    // Define a simple data model class
    public class RecipeItem {
        private String name;
        private String recipeContent;

        public RecipeItem(String name, String recipeContent) {
            this.name = name;
            this.recipeContent = recipeContent;
        }

        public String getName() {
            return name;
        }

        public String getRecipeContent() {
            return recipeContent;
        }
    }

    // Create a simple RecyclerView adapter
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private List<RecipeItem> items;

        public MyAdapter(List<RecipeItem> items) {
            this.items = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Implement this method
            return null;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            RecipeItem item = items.get(position);
            holder.nameTextView.setText(item.getName());
            holder.recipeContentTextView.setText(item.getRecipeContent());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView nameTextView;
            TextView recipeContentTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                // Implement this constructor
            }
        }
    }
}
