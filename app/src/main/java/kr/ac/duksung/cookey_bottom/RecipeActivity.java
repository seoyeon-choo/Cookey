package kr.ac.duksung.cookey_bottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class RecipeActivity extends AppCompatActivity {

    Toolbar toolbar;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;

    private FloatingActionButton addButton;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        fragment4 = new Fragment4();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container2, fragment4).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("쿠키 추천 털기"));
        tabs.addTab(tabs.newTab().setText("임박 재료 털기"));
        tabs.addTab(tabs.newTab().setText("모든 재료 털기"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭: " +position);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                } else if (position == 2) {
                    selected = fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //쿡키 버튼을 누를 때 메인 페이지로 돌아가기
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finish the current activity (MypageActivity) and start MainActivity
                Intent intent = new Intent(RecipeActivity.this, MainActivity.class);
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
                    startActivity(new Intent(RecipeActivity.this, LookActivity.class));
                } else if (item.getItemId() == R.id.cook) {
                    // 냉장고 털기 페이지로 이동
                    startActivity(new Intent(RecipeActivity.this, RecipeActivity.class));
                } else if (item.getItemId() == R.id.cart) {
                    // 원터치 주문 페이지로 직접 URL로 이동
                    String url = "https://www.kurly.com/main";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else if (item.getItemId() == R.id.my) {
                    // 마이페이지로 이동
                    startActivity(new Intent(RecipeActivity.this, MypageActivity.class));
                }
                return true;
            }
        });

    }
}