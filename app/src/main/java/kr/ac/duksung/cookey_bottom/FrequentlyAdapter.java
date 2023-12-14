package kr.ac.duksung.cookey_bottom;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

public class FrequentlyAdapter extends RecyclerView.Adapter<FrequentlyAdapter.FrequentlyViewHolder> {

    private List<FrequentlyItem> dataList;

    public FrequentlyAdapter(List<FrequentlyItem> dataList) {
        this.dataList = dataList;
    }

    public void setItemBorderColor(View view, int getremainingDays) {
        if (getremainingDays <= 3) {
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
    public FrequentlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new FrequentlyViewHolder(view);
    }

    // ViewHolder 클래스. +버튼 동작 관련 코드
    public static class FrequentlyViewHolder extends RecyclerView.ViewHolder {

        ImageView ingredientImageView;
        TextView itemTextView;
        View smallButton;

        public FrequentlyViewHolder(View itemView) {
            super(itemView);
            ingredientImageView = itemView.findViewById(R.id.ingredientImageView);
            itemTextView = itemView.findViewById(R.id.itemTextView);
            smallButton = itemView.findViewById(R.id.smallButton);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull FrequentlyViewHolder holder, int position) {
        FrequentlyItem item = dataList.get(position);


        // 텍스트 설정
        String itemText = String.format(Locale.getDefault(),
                "%s\n개수: %d\n소비기한: %s\n남은 기간: %s\n보관일: %s",
                item.getIngredientName(),
                item.getQuantity(),
                item.getExpiryDate(),
                item.getRemainingDays(),
                item.getStorageDuration());
        holder.itemTextView.setText(itemText);

        // 이미지 설정 (이미지는 실제 데이터에 맞게 설정)
        int imageResource = getDrawableResourceId(holder.itemView, item.getImageFileName());
        holder.ingredientImageView.setImageResource(imageResource);

        // Set the border color based on the remaining days
        int remainingDaysValue = calculateRemainingDays(item.getExpiryDate()); // Replace this with your actual logic
        setItemBorderColor(holder.itemView, remainingDaysValue);

        // smallButton에 대한 클릭 이벤트 처리
        if (holder.smallButton != null) {
            holder.smallButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String ingredientName = item.getIngredientName(); // item 변수로 수정
                    String encodedIngredientName = Uri.encode(ingredientName);
                    String url = "https://www.kurly.com/search?sword=" + encodedIngredientName;

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    // 이미지 파일 이름을 이용하여 리소스 아이디를 가져오는 메서드
    private int getDrawableResourceId(View view, String imageName) {
        int resourceId = view.getContext().getResources().getIdentifier(imageName, "drawable", view.getContext().getPackageName());
        Log.d("DrawableResource", "Resource ID for " + imageName + ": " + resourceId);
        return resourceId;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

