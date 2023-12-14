package kr.ac.duksung.cookey_bottom;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CalendarView;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import android.widget.TextView;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView timeTextView;
    private TextView progressTextView;
    private Handler handler;
    private RecyclerView recyclerView;
    private BottomNavigationView bottomNavigationView;
    private NotificationManager notificationManager;
    // Moved NOTIFICATION_ID initialization to a more suitable location
    private static final String CHANNEL_ID = "channel_id";
    private static final String CHANNEL_NAME = "Channel Name";
    private static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);
        timeTextView = findViewById(R.id.timeTextView);
        progressTextView = findViewById(R.id.progressTextView);

        setCalendarHeaderTextColor(calendarView, android.R.color.primary_text_light);

        displayCurrentTime();

        List<FrequentlyItem> dataList = new ArrayList<>();
        dataList.add(new FrequentlyItem("감자", 1, "2023-12-05", "9일", "20일","po"));
        dataList.add(new FrequentlyItem("달걀", 8, "2023-12-14", "9일", "10일", "egg"));
        dataList.add(new FrequentlyItem("치즈", 3, "2023-12-14", "69일", "70일", "che"));

        FrequentlyAdapter adapter = new FrequentlyAdapter(dataList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.refrigerator) {
                    // 냉장고 페이지로 이동
                    startActivity(new Intent(MainActivity.this, LookActivity.class));
                } else if (item.getItemId() == R.id.cook) {
                    // 냉장고 털기 페이지로 이동
                    startActivity(new Intent(MainActivity.this, RecipeActivity.class));
                } else if (item.getItemId() == R.id.cart) {
                    // 원터치 주문 페이지로 직접 URL로 이동
                    String url = "https://www.kurly.com/main";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else if (item.getItemId() == R.id.my) {
                    // 마이페이지로 이동
                    startActivity(new Intent(MainActivity.this, MypageActivity.class));
                }
                return true;
            }
        });

        handler = new Handler();
        handler.postDelayed(updateTimeRunnable, 100);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        createNotificationChannel();
    }


    private int getSaturationLevel() {
        // 여기에 실제로 포화도를 가져오는 로직을 구현합니다.
        // 예를 들어, 냉장고 정보를 가상으로 설정하거나, 센서 값을 반환하도록 구현할 수 있습니다.
        // 가상으로 90%를 반환하는 예시:
        return 90;
    }

    private final Runnable updateTimeRunnable = new Runnable() {
        @Override
        public void run() {
            displayCurrentTime();
            int saturationLevel = getSaturationLevel();
            if (saturationLevel >= 90) {
                showNotification("냉장고를 털어주세요!", "포화도가 90%에 도달했습니다.");
            }
            handler.postDelayed(this, 100);
        }
    };

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void showNotification(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.but)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        builder.setContentIntent(pendingIntent);

        // Use NOTIFICATION_ID here
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void setCalendarHeaderTextColor(CalendarView calendarView, @ColorRes int colorRes) {
        int color = ContextCompat.getColor(this, colorRes);
        try {
            java.lang.reflect.Field field = calendarView.getClass().getDeclaredField("mHeaderTextColor");
            field.setAccessible(true);
            field.set(calendarView, color);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String currentTime = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
        timeTextView.setText(currentTime);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(updateTimeRunnable);
        super.onDestroy();
    }

    private void displayCurrentSaturation() {
        int saturation = 75;
        progressTextView.setText(saturation + "%");
    }
}
