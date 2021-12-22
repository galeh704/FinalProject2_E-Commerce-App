package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.finalproject2_e_commerce_app.utils.FashionAdapter;
import com.google.android.material.tabs.TabLayout;

public class KategoriDetailActivity extends AppCompatActivity {

    TabLayout tab_fashion;
    ViewPager2 pager_fashion;
    FashionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_detail);
        tab_fashion = findViewById(R.id.tab_fashion);
        pager_fashion = findViewById(R.id.pager_fashion);


        FragmentManager fm = getSupportFragmentManager();
        adapter = new FashionAdapter(fm , getLifecycle());
        pager_fashion.setAdapter(adapter);




        tab_fashion.addTab(tab_fashion.newTab().setText("Men's"));
        tab_fashion.addTab(tab_fashion.newTab().setText("Women's"));
        tab_fashion.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#ffffff")));


        tab_fashion.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager_fashion.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager_fashion.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tab_fashion.selectTab(tab_fashion.getTabAt(position));
            }
        });
    }
}