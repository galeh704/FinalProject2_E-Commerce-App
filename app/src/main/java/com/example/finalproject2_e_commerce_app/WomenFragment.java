package com.example.finalproject2_e_commerce_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class WomenFragment extends Fragment {
    FrameLayout women_tshirt,women_pants,women_formal,women_outwear,women_shoes;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_women, container, false);

        women_formal = v.findViewById(R.id.women_formals);
        women_outwear = v.findViewById(R.id.women_outwear);
        women_pants = v.findViewById(R.id.women_pants);
        women_shoes = v.findViewById(R.id.women_shoes);
        women_tshirt = v.findViewById(R.id.women_tshirt);

        women_tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori2 = "women_tshirt";
                Intent tshirt = new Intent( getActivity(), UserBarangActivity.class).putExtra("women_tshirt",kategori2);
                startActivity(tshirt);
            }
        });
        women_shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori5 = "women_shoes";
                Intent shoes = new Intent( getActivity(), UserBarangActivity.class).putExtra("women_shoes",kategori5);
                startActivity(shoes);
            }
        });
        women_pants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori4 = "women_pants";
                Intent pants = new Intent( getActivity(), UserBarangActivity.class).putExtra("women_pants",kategori4);
                startActivity(pants);
            }
        });
        women_outwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori3 = "women_outwear";
                Intent outwear = new Intent( getActivity(), UserBarangActivity.class).putExtra("women_outwear",kategori3);
                startActivity(outwear);
            }
        });
        women_formal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = "women_formal";
                Intent formal = new Intent( getActivity(), UserBarangActivity.class).putExtra("women_formal",kategori);
                startActivity(formal);
            }
        });
        return v;
    }
}