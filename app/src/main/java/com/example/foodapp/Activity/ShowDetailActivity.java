package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Doman.FoodDoman;
import com.example.foodapp.Helper.ManagementCart;
import com.example.foodapp.R;

public class ShowDetailActivity extends AppCompatActivity {
    LinearLayout addtocart;
    TextView txttiltle,txtfee,txtnumber,txtdescription,txttotalprice,txtstar,txttime,txtcalo;
    ImageView imgminus,imgplus,imgfood;
    FoodDoman foodDoman;
    int number = 1;
    ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCart = new ManagementCart(this);
        initview();
        getBundel();
    }

    private void getBundel() {
        foodDoman  = (FoodDoman) getIntent().getSerializableExtra("object");
        int drawabledResoure = this.getResources().getIdentifier(foodDoman.getImgage(),"drawable",this.getPackageName());
        Glide.with(this).load(drawabledResoure).into(imgfood);
        txttiltle.setText(foodDoman.getTiltle());
        txtfee.setText("$" + foodDoman.getFee());
        txtdescription.setText(foodDoman.getDescription());
        txtnumber.setText(String.valueOf(number));
        txtcalo.setText(foodDoman.getCalories() + " calories");
        txtstar.setText(String.valueOf(foodDoman.getStart()));
        txttime.setText(foodDoman.getTime() + " minutes");
        imgplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 1;
                txtnumber.setText(String.valueOf(number));
                txttotalprice.setText(String.valueOf(number * foodDoman.getFee()));
            }
        });
        imgminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number >1){
                    number = number - 1;
                }
                txtnumber.setText(String.valueOf(number));
                txttotalprice.setText(String.valueOf(number * foodDoman.getFee()));
            }
        });
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodDoman.setNumberIntCart(number);
                managementCart.InsertFood(foodDoman);
            }
        });
    }

    private void initview() {
        addtocart = findViewById(R.id.idaddtocartdetail);
        txttiltle = findViewById(R.id.idtitledetail);
        txtfee = findViewById(R.id.idtxtpricedetail);
        txtnumber = findViewById(R.id.txtnumdetai);
        imgminus = findViewById(R.id.idtxtminusdetail);
        imgplus = findViewById(R.id.idtxtplusdetail);
        imgfood = findViewById(R.id.idimgfoodddetail);
        txtdescription = findViewById(R.id.txtdescriptiondetail);
        txtcalo = findViewById(R.id.txtcaloriesdetail);
        txtstar = findViewById(R.id.idtxtstardetail);
        txttotalprice = findViewById(R.id.idtextpricetotaldetail);
        txttime = findViewById(R.id.idtxttimedetail);
    }
}