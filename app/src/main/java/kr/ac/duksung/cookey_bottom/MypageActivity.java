package kr.ac.duksung.cookey_bottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MypageActivity extends AppCompatActivity {

    private FloatingActionButton addButton;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        // button2(자주 찾는 재료 버튼)
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // button2를 클릭하면 activity_frequentfood.xml을 보여주는 액티비티로 이동
                Intent intent = new Intent(MypageActivity.this, FrequentfoodActivity.class);
                startActivity(intent);
            }
        });

//        // button5(저장한 레시피 버튼)
//        Button button5 = findViewById(R.id.button5);
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // button3를 클릭하면 activity_frequentfood.xml을 보여주는 액티비티로 이동
//                Intent intent = new Intent(MypageActivity.this, SaveActivity.class);
//                startActivity(intent);
//            }
//        });

        // button6(리마인더 버튼)
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // button6를 클릭하면 activity_reminder.xml을 보여주는 액티비티로 이동
                Intent intent = new Intent(MypageActivity.this, ReminderActivity.class);
                startActivity(intent);
            }
        });

        //쿡키 버튼을 누를 때 메인 페이지로 돌아가기
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finish the current activity (MypageActivity) and start MainActivity
                Intent intent = new Intent(MypageActivity.this, MainActivity.class);
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
                    startActivity(new Intent(MypageActivity.this, LookActivity.class));
                } else if (item.getItemId() == R.id.cook) {
                    // 냉장고 털기 페이지로 이동
                    startActivity(new Intent(MypageActivity.this, RecipeActivity.class));
                } else if (item.getItemId() == R.id.cart) {
                    // 원터치 주문 페이지로 직접 URL로 이동
                    String url = "https://www.kurly.com/main";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
                return true;
            }
        });


    }
}
