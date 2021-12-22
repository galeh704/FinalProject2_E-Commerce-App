package com.example.finalproject2_e_commerce_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class MenFragment extends Fragment {





    public MenFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FrameLayout men_tshirt,men_formal,men_shoes,men_pants,men_outwear;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View v = inflater.inflate(R.layout.fragment_men, container, false);
      men_tshirt = v.findViewById(R.id.men_tshirt);
      men_formal = v.findViewById(R.id.men_formal);
      men_outwear = v.findViewById(R.id.men_outwear);
      men_pants = v.findViewById(R.id.men_pants);
      men_shoes = v.findViewById(R.id.men_shoes);

      men_tshirt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String kategori2 = "men_tshirt";
              Intent tshirt = new Intent( getActivity(), UserBarangActivity.class).putExtra("men_tshirt",kategori2);
              startActivity(tshirt);
          }
      });
      men_shoes.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String kategori5 = "shoes";
              Intent shoes = new Intent( getActivity(), UserBarangActivity.class).putExtra("shoes",kategori5);
              startActivity(shoes);
          }
      });
      men_pants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori4 = "pants";
                Intent pants = new Intent( getActivity(), UserBarangActivity.class).putExtra("pants",kategori4);
                startActivity(pants);
            }
        });
      men_outwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori3 = "outwear";
                Intent outwear = new Intent( getActivity(), UserBarangActivity.class).putExtra("outwear",kategori3);
                startActivity(outwear);
            }
        });
      men_formal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = "men_formal";
                Intent formal = new Intent( getActivity(), UserBarangActivity.class).putExtra("men_formal",kategori);
                startActivity(formal);
            }
        });
      return v;
    }

}