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
import android.widget.GridView;

import com.example.finalproject2_e_commerce_app.list.Product;
import com.example.finalproject2_e_commerce_app.utils.FashionAdapter;
import com.example.finalproject2_e_commerce_app.utils.GadgetAdapter;
import com.example.finalproject2_e_commerce_app.utils.UserProductAdapter;
import com.google.android.material.tabs.TabLayout;

public class KategoriGadgetActivity extends AppCompatActivity {
    UserProductAdapter adapter;
    Product product;
    GridView gridView;
    String lalala ="https://vacillating-feedbac.000webhostapp.com/readsmartphone.php";
    TabLayout tab_gadget;
    ViewPager2 pager_gadget;
    GadgetAdapter adapter2;
    FrameLayout laptop,smartphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_gadget);

        laptop = findViewById(R.id.laptop);
        smartphone = findViewById(R.id.smartphone);
        smartphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String smartphone = "smartphone";
                Intent tshirt = new Intent( KategoriGadgetActivity.this, UserBarangActivity.class).putExtra("smartphone",smartphone);
                startActivity(tshirt);
            }
        });
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String laptop = "laptop";
                Intent tshirt = new Intent( KategoriGadgetActivity.this, UserBarangActivity.class).putExtra("laptop",laptop);
                startActivity(tshirt);
            }
        });


        /*
        tab_gadget = findViewById(R.id.tab_gadget);
        pager_gadget = findViewById(R.id.pager_gadget);

        FragmentManager fm = getSupportFragmentManager();
        adapter2 = new GadgetAdapter(fm , getLifecycle());
        pager_gadget.setAdapter(adapter2);

        tab_gadget.addTab(tab_gadget.newTab().setText("Smartphone"));
        tab_gadget.addTab(tab_gadget.newTab().setText("Laptop"));
        tab_gadget.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#ffffff")));

        tab_gadget.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager_gadget.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager_gadget.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tab_gadget.selectTab(tab_gadget.getTabAt(position));
            }
        });

         */
    }
}