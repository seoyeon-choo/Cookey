package kr.ac.duksung.cookey_bottom;

import android.os.Bundle;
import android.widget.CalendarView;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.widget.TextView;

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
