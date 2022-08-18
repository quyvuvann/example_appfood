package com.example.foodapp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.foodapp.Doman.FoodDoman;
import com.example.foodapp.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    public Context context;
    public TinyDB tinyDB;
    public ManagementCart(Context context) {
        this.context = context;
    }

    public ManagementCart(Context context, TinyDB tinyDB) {
        this.context = context;
        this.tinyDB = tinyDB;
    }
    public void InsertFood(FoodDoman item){
        tinyDB = new TinyDB(context);
        ArrayList<FoodDoman> arrayListfoodDoman = getListcart();
        boolean exitsAlrealy = false;
        int n =0;
        for(int i = 0;i<arrayListfoodDoman.size();i++){
            if(arrayListfoodDoman.get(i).getTiltle().equals(item.getTiltle())){
                exitsAlrealy = true;
                n = i;
                break;
            }
        }
        if(exitsAlrealy){
            arrayListfoodDoman.get(n).setNumberIntCart(item.getNumberIntCart());
        }else{
            arrayListfoodDoman.add(item);
        }

        tinyDB.putListObject("Cartlist",arrayListfoodDoman);
        Toast.makeText(context, "Add to your cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDoman> getListcart() {
        tinyDB = new TinyDB(context);
        return tinyDB.getListObject("Cartlist");
    }
    public void minusnumberfood(ArrayList<FoodDoman> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        tinyDB = new TinyDB(context);
        if(listfood.get(position).getNumberIntCart()==1){
            listfood.remove(position);
        }else{
            listfood.get(position).setNumberIntCart(listfood.get(position).getNumberIntCart()-1);
        }
        tinyDB.putListObject("Cartlist",listfood);
        changeNumberItemsListener.change();
    }
    public void plusnumberfood(ArrayList<FoodDoman> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        tinyDB = new TinyDB(context);
        listfood.get(position).setNumberIntCart(listfood.get(position).getNumberIntCart()+1);

        tinyDB.putListObject("Cartlist",listfood);
        changeNumberItemsListener.change();
    }
    public Double getTotalFree(){
        ArrayList<FoodDoman> listfood2 = getListcart();
        double fee = 0;
        for(int i= 0;i<listfood2.size();i++){
            fee = fee+ (listfood2.get(i).getFee() * listfood2.get(i).getNumberIntCart());
        }
        return fee;
    }
}
