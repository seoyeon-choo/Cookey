package kr.ac.duksung.cookey_bottom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CalendarView;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.widget.TextView;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);
        timeTextView = findViewById(R.id.timeTextView);

        // Set the header text color programmatically
        setCalendarHeaderTextColor(calendarView, android.R.color.primary_text_light);

        // Display the current time
        displayCurrentTime();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // BottomNavigationView의 아이템 클릭 리스너 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.refrigerator) {
                    // 냉장고 페이지로 이동
                    // 이동할 페이지의 액티비티를 지정
                } else if (item.getItemId() == R.id.cook) {
                    // 냉장고 털기 페이지로 이동
                    // 이동할 페이지의 액티비티를 지정
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
        // 현재 시간을 받아옴
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault()); // 24시간 형식
        String currentTime = sdf.format(calendar.getTime());

        // 받아온 현재 시간을 TextView에 표시
        timeTextView.setText(currentTime);
    }
}
