package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.foodapp.Adapter.CategoryAdapter;
import com.example.foodapp.Adapter.PopularyAdapter;
import com.example.foodapp.Doman.CategoryDomain;
import com.example.foodapp.Doman.FoodDoman;
import com.example.foodapp.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerViewCategory,recyclerViewPopular;
    CategoryAdapter categoryAdapter;
    PopularyAdapter popularyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerViewCategory();
        recyclerViewPopular();
        bottomnavigation();
    }

    private void bottomnavigation() {
        LinearLayout btnhome = (LinearLayout) findViewById(R.id.idbtnhome);
        LinearLayout btncart = (LinearLayout) findViewById(R.id.idbtnCart);
        LinearLayout btnprofile = (LinearLayout) findViewById(R.id.idbtnprofilecart);
        LinearLayout btnchat = (LinearLayout) findViewById(R.id.idbtnchat);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,CartActivity.class));
                btncart.setBackgroundColor(R.drawable.backgroundcart);
            }
        });
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
            }
        });
        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ChatActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopular = findViewById(R.id.idrecyclerPopular);
        recyclerViewPopular.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDoman> arrayListPopular = new ArrayList<>();
        arrayListPopular.add(new FoodDoman("Pepperori pizza","pizza1","slices peperori, mozzare chelse,fresh oregano ,ground black peper, pizza sauce",13.0,10,20,1000));
        arrayListPopular.add(new FoodDoman("Chesse Burger","burger","slices peperori, mozzare chelse,fresh oregano ,ground black peper, pizza sauce",15.20,4,10,1500));
        arrayListPopular.add(new FoodDoman("Vegetable pizza","pizza3","slices peperori, mozzare chelse,fresh oregano ,ground black peper, pizza sauce",11.0,3,16,900));
        arrayListPopular.add(new FoodDoman("Pepperori pizza","pizza1","slices peperori, mozzare chelse,fresh oregano ,ground black peper, pizza sauce",13.0,10,20,1000));
        arrayListPopular.add(new FoodDoman("Pepperori pizza","pizza3","slices peperori, mozzare chelse,fresh oregano ,ground black peper, pizza sauce",13.0,10,20,1000));
        popularyAdapter = new PopularyAdapter(arrayListPopular);
        recyclerViewPopular.setAdapter(popularyAdapter);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory = findViewById(R.id.idrecyclerCategories);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> categoryDomains = new ArrayList<>();
        categoryDomains.add(new CategoryDomain("Pizaa","cat_1"));
        categoryDomains.add(new CategoryDomain("Burger","cat_2"));
        categoryDomains.add(new CategoryDomain("Hotdog","cat_3"));
        categoryDomains.add(new CategoryDomain("Drink","cat_4"));
        categoryDomains.add(new CategoryDomain("Donut","cat_5"));
        categoryAdapter = new CategoryAdapter(categoryDomains);
        recyclerViewCategory.setAdapter(categoryAdapter);

    }
}