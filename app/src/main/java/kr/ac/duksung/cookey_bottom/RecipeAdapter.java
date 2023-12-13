package kr.ac.duksung.cookey_bottom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        super(context, 0, recipes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Implement the logic to display a recipe item in the ListView
        // You might want to use a custom layout for each item
        // Example: View itemView = LayoutInflater.from(getContext()).inflate(R.layout.recipe_item, parent, false);

        // Get the current recipe
        Recipe recipe = getItem(position);

        // Set the recipe details in the item view
        // Example: TextView titleTextView = itemView.findViewById(R.id.titleTextView);
        // titleTextView.setText(recipe.getTitle());

        return convertView; // Return the populated item view
    }
}

