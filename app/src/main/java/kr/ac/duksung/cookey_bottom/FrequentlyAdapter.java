package kr.ac.duksung.cookey_bottom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FrequentlyAdapter extends RecyclerView.Adapter<FrequentlyAdapter.ViewHolder> {

    private List<FrequentlyItem> dataList;

    public FrequentlyAdapter(List<FrequentlyItem> dataList) {
        this.dataList = dataList;
    }

    public void setItemBorderColor(View view, int remainingDays) {
        if (remainingDays <= 3) {
            view.setBackgroundResource(R.drawable.red_border_background); // Use a red border drawable
        } else {
            // Use the default border drawable or any other color as needed
            view.setBackgroundResource(R.drawable.border_background);
        }
    }

    private int calculateRemainingDays(String expiryDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        try {
            Date expirationDate = sdf.parse(expiryDate);
            Date currentDate = Calendar.getInstance().getTime();

            // Calculate the difference in days
            long diff = expirationDate.getTime() - currentDate.getTime();
            return (int) (diff / (24 * 60 * 60 * 1000));

        } catch (ParseException e) {
            e.printStackTrace();
            return 0; // Return 0 in case of an error
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FrequentlyItem item = dataList.get(position);

        // 텍스트 설정
        String itemText = String.format(Locale.getDefault(),
                "%s\n개수: %d\n소비기한: %s\n남은 기간: %s\n보관일: %s",
                item.getIngredientName(),
                item.getQuantity(),
                item.getExpiryDate(),
                item.getRemainingDays(),
                item.getStorageDuration());
        holder.textView.setText(itemText);

        // 이미지 설정 (이미지는 실제 데이터에 맞게 설정)
        holder.imageView.setImageResource(R.drawable.onion);

        // Set the border color based on the remaining days
        int remainingDaysValue = calculateRemainingDays(item.getExpiryDate()); // Replace this with your actual logic
        setItemBorderColor(holder.itemView, remainingDaysValue);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.itemTextView);
            imageView = itemView.findViewById(R.id.ingredientImageView);
        }
    }
}
