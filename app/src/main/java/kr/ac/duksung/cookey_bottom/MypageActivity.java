package kr.ac.duksung.cookey_bottom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MypageActivity extends AppCompatActivity {

    private FloatingActionButton addButton;

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
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // button3를 클릭하면 activity_frequentfood.xml을 보여주는 액티비티로 이동
//                Intent intent = new Intent(MypageActivity.this, .class);
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
    }
}
