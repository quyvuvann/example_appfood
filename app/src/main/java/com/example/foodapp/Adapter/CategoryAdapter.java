package com.example.foodapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Doman.CategoryDomain;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolderAdapter> {
    ArrayList<CategoryDomain> categoryAdapterlist;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryAdapterlist) {
        this.categoryAdapterlist = categoryAdapterlist;
    }

    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new ViewHolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        CategoryDomain categoryDomain = categoryAdapterlist.get(position);
        holder.txtnamecategory.setText(categoryDomain.getTitle());
        String imgurl;
        switch (position){
            case 0:{
                imgurl = "cat_1";
                break;
            }
            case 1:{
                imgurl = "cat_2";
                break;
            }
            case 2:{
                imgurl = "cat_3";
                break;
            }
            case 3:{
                imgurl = "cat_4";
                break;
            }
            case 4:{
                imgurl = "cat_5";
                break;
            }
            default:
                imgurl = "cat_1";
                break;
        }
        int drawbleResoure = holder.itemView.getContext().getResources().getIdentifier(imgurl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawbleResoure).into(holder.imgcategory);
    }

    @Override
    public int getItemCount() {
        if(categoryAdapterlist != null){
            return categoryAdapterlist.size();
        }
        return 0;
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder{
        ImageView imgcategory;
        TextView txtnamecategory;
        LinearLayout linearLayoutcategory;
        public ViewHolderAdapter(@NonNull View itemView) {
            super(itemView);
            imgcategory = itemView.findViewById(R.id.idimgviewcart);
            txtnamecategory = itemView.findViewById(R.id.idtxtname);
            linearLayoutcategory = itemView.findViewById(R.id.idlinealayoutcategory);
        }
    }
}
