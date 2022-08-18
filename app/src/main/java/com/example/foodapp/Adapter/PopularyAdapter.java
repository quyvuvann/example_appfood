package com.example.foodapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Activity.ShowDetailActivity;
import com.example.foodapp.Doman.FoodDoman;
import com.example.foodapp.R;

import java.util.List;

public class PopularyAdapter extends RecyclerView.Adapter<PopularyAdapter.ViewHolderPopular> {
    List<FoodDoman> foodDomanList;

    public PopularyAdapter(List<FoodDoman> foodDomanList) {
        this.foodDomanList = foodDomanList;
    }

    @NonNull
    @Override
    public ViewHolderPopular onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular,parent,false);
        return new ViewHolderPopular(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPopular holder, int position) {
            FoodDoman foodDoman = foodDomanList.get(position);
            if(foodDoman == null){
                return;
            }
            holder.titlepopular.setText(foodDoman.getTiltle());
            holder.feepopular.setText(String.valueOf(foodDoman.getFee()));
        int drawbleResoure = holder.itemView.getContext().getResources().getIdentifier(foodDoman.getImgage(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawbleResoure).into(holder.imgpopular);
        holder.addpopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object",foodDoman);
                holder.itemView.getContext().startActivity(intent);
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

    public class ViewHolderPopular extends RecyclerView.ViewHolder {
        TextView titlepopular,feepopular;
        ImageView imgpopular,addpopular;
        public ViewHolderPopular(@NonNull View itemView) {
            super(itemView);
            titlepopular = itemView.findViewById(R.id.txttitlepopular);
            feepopular = itemView.findViewById(R.id.idtxtmoney);
            imgpopular = itemView.findViewById(R.id.idimgviewpopular);
            addpopular  =itemView.findViewById(R.id.idimgcong);
        }
    }
}
