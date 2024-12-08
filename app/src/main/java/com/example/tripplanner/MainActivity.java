package com.example.tripplanner;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tripplanner.Fragment.BookmarkFragment;
import com.example.tripplanner.Fragment.HomeFragment;
import com.example.tripplanner.Fragment.MyPlanFragment;
import com.example.tripplanner.Fragment.ProfileFragment;
import com.example.tripplanner.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navi = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, new HomeFragment()).commit();

        navi.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.homeFragment:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.searchFragment:
                        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, new SearchFragment()).commit();
                        break;
                    case R.id.bookmarkFragment:
                        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, new BookmarkFragment()).commit();
                        break;
                    case R.id.myPlanFragment:
                        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, new MyPlanFragment()).commit();
                        break;
                    case R.id.profileFragment:
                        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, new ProfileFragment()).commit();
                        break;
                }
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, selectedFragment).commit();
                }
                return true;
            }
        });
    }
}