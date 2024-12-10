package com.example.tripplanner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tripplanner.fragment.BookmarkFragment;
import com.example.tripplanner.fragment.HomeFragment;
import com.example.tripplanner.fragment.MyPlanFragment;
import com.example.tripplanner.fragment.ProfileFragment;
import com.example.tripplanner.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navi = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new HomeFragment()).commit();

        navi.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.homeFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new HomeFragment()).commit();
                } else if (itemId == R.id.searchFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new SearchFragment()).commit();
                } else if (itemId == R.id.bookmarkFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new BookmarkFragment()).commit();
                } else if (itemId == R.id.myPlanFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new MyPlanFragment()).commit();
                } else if (itemId == R.id.profileFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new ProfileFragment()).commit();
                }
                return true;
            }
        });
    }
}