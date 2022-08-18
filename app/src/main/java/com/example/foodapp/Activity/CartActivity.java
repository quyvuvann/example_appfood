package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.foodapp.Adapter.CartAdaper;
import com.example.foodapp.Helper.ManagementCart;
import com.example.foodapp.Interface.ChangeNumberItemsListener;
import com.example.foodapp.R;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerViewcart;
    TextView txtitemstotal,txtdeliveryservices,txttax,txttotal,txtempty;
    ManagementCart managementCart;
    double tax;
    ScrollView scrollView;
    CartAdaper cartAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        managementCart  = new ManagementCart(this);

        initview();
        initList();
        bottomnavigation();
        caculateCart();
    }
    private void bottomnavigation() {
        LinearLayout btnhome = (LinearLayout) findViewById(R.id.idbtnhome);
        LinearLayout btncart = (LinearLayout) findViewById(R.id.idbtnCart);
        LinearLayout btnprofile = (LinearLayout) findViewById(R.id.idbtnprofilecart);
        LinearLayout btnchat = (LinearLayout) findViewById(R.id.idbtnchat);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,CartActivity.class));
                CartActivity.this.notifyAll();
                btncart.setBackgroundColor(R.drawable.backgroundcart);
            }
        });
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,ProfileActivity.class));;
            }
        });
        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,ChatActivity.class));
            }
        });
    }
    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewcart.setLayoutManager(linearLayoutManager);
        cartAdaper = new CartAdaper(managementCart.getListcart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                caculateCart();
            }
        });
        recyclerViewcart.setAdapter(cartAdaper);
        if(managementCart.getListcart().isEmpty()){
            txtempty.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            txtempty.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void caculateCart() {
        double percentTax = 0.2; //you can change this item tax price
        double delivery = 10;   //you can change this item you need price for delivery
        tax = Math.round((managementCart.getTotalFree() * percentTax) *100.0)/100.0;
        double total = Math.round((managementCart.getTotalFree() + tax + delivery)*100.0)/100.0;
        double itemstotal = Math.round(managementCart.getTotalFree() * 100.0)/100.0;
        txttotal.setText("$" + total);
        txtitemstotal.setText("$" + itemstotal);
        txttax.setText("$" + tax);
        txtdeliveryservices.setText("$"+  delivery);
    }

    private void initview() {
        recyclerViewcart = findViewById(R.id.idrecyclercart);
        txtitemstotal = findViewById(R.id.iditemstotal);
        txtdeliveryservices = findViewById(R.id.iddeliveryservices);
        txttax = findViewById(R.id.idtax);
        txttotal = findViewById(R.id.idtotal);
        txtempty = findViewById(R.id.idempty);
        scrollView = findViewById(R.id.idcrollviewcart);
    }
}