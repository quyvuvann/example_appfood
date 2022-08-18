package com.example.foodapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Doman.FoodDoman;
import com.example.foodapp.Helper.ManagementCart;
import com.example.foodapp.Interface.ChangeNumberItemsListener;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.List;

public class CartAdaper extends RecyclerView.Adapter<CartAdaper.viewAdapterCart>{
    ArrayList<FoodDoman> foodDomanList;
    Context context;
    ChangeNumberItemsListener changeNumberItemsListener;
    ManagementCart managementCart;

    public CartAdaper(ArrayList<FoodDoman> foodDomanList, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.foodDomanList = foodDomanList;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public viewAdapterCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new viewAdapterCart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewAdapterCart holder, int position) {

            FoodDoman foodDoman = foodDomanList.get(position);
            if(foodDoman == null){
                return;
            }
            holder.txtttitle.setText(foodDoman.getTiltle());
            holder.feeEachItem.setText("$" + foodDoman.getFee());
            holder.totalEachItems.setText("$" + Math.round((foodDoman.getNumberIntCart()) * (foodDoman.getFee())));
            holder.num.setText(String.valueOf(foodDoman.getNumberIntCart()));

            int drawableRecouce = holder.itemView.getContext().getResources().getIdentifier(foodDoman.getImgage(),"drawable",holder.itemView.getContext().getPackageName());
            Glide.with(holder.itemView.getContext()).load(drawableRecouce).into(holder.image);
            holder.plusItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    managementCart.plusnumberfood(foodDomanList, position, new ChangeNumberItemsListener() {
                        @Override
                        public void change() {
                            notifyDataSetChanged();
                            changeNumberItemsListener.change();
                        }
                    });
                }
            });
            holder.minusItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    managementCart.minusnumberfood(foodDomanList, position, new ChangeNumberItemsListener() {
                        @Override
                        public void change() {
                            notifyDataSetChanged();
                            changeNumberItemsListener.change();
                        }
                    });
                }
            });
    }

    @Override
    public int getItemCount() {
        if(foodDomanList != null){
            return foodDomanList.size();
        }
        return 0;
    }

    public class viewAdapterCart extends RecyclerView.ViewHolder {
        TextView txtttitle,feeEachItem;
        ImageView image,plusItem,minusItem;
        TextView totalEachItems,num;
        public viewAdapterCart(@NonNull View itemView) {
            super(itemView);
            txtttitle = itemView.findViewById(R.id.idtitlecart);
            image = itemView.findViewById(R.id.imgcart);
            feeEachItem = itemView.findViewById(R.id.idtxteachitemcart);
            totalEachItems = itemView.findViewById(R.id.idtxttotalitemcart);
            plusItem  = itemView.findViewById(R.id.idimgpluscart);
            minusItem = itemView.findViewById(R.id.idimgminuscart);
            num = itemView.findViewById(R.id.idtxtnumcart);
        }
    }
}
