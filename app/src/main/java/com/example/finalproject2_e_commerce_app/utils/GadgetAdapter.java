package com.example.finalproject2_e_commerce_app.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalproject2_e_commerce_app.LaptopFragment;
import com.example.finalproject2_e_commerce_app.MenFragment;
import com.example.finalproject2_e_commerce_app.SmartphoneFragment;
import com.example.finalproject2_e_commerce_app.WomenFragment;

public class GadgetAdapter extends FragmentStateAdapter {

    public GadgetAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return new LaptopFragment();

        }
        return new SmartphoneFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
