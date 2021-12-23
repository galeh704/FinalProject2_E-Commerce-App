package com.example.finalproject2_e_commerce_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject2_e_commerce_app.list.Product;
import com.example.finalproject2_e_commerce_app.utils.UserProductAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;


public class SmartphoneFragment extends Fragment {
    public static ArrayList<Product> arrayGridProduct = new ArrayList<>();
    UserProductAdapter adapter;
    Product product;
    GridView gridView;
    String lalala ="https://vacillating-feedbac.000webhostapp.com/readsmartphone.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_smartphone, container, false);
        gridView = v.findViewById(R.id.grid_barang);
        adapter = new UserProductAdapter(requireContext(), arrayGridProduct);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                startActivity(new Intent(getActivity(),DetailProductActivity.class).putExtra("position",item));
            }
        });
        arrayGridProduct.clear();
        retrieveData();
        return v;
    }
    private void retrieveData(){
        StringRequest request = new StringRequest(Request.Method.POST, lalala,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        arrayGridProduct.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            Log.e("anyText", response);
                            JSONArray jsonArray = jsonObject.getJSONArray("product");

                            if (sucess.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String idProduct = object.getString("idProduct");
                                    String namaProduct = object.getString("namaProduct");
                                    String harga = object.getString("harga");
                                    String stock = object.getString("stock");
                                    String deskripsi = object.getString("deskripsi");
                                    String kategori = object.getString("kategori");
                                    String gambar = object.getString("gambarProduct");
                                    String url = "https://vacillating-feedbac.000webhostapp.com/Images/"+ gambar;

                                    product = new Product(idProduct,namaProduct, harga, stock, deskripsi, kategori, url);
                                    arrayGridProduct.add(product);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(requireContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        requestQueue.add(request);
    }
}
