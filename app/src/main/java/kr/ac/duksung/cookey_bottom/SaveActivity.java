package kr.ac.duksung.cookey_bottom;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SaveActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;

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
