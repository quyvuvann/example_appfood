package com.example.foodapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Doman.Chat;
import com.example.foodapp.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolderChat>{

    List<Chat> chatList;

    public ChatAdapter() {

    }

    public void setData(List<Chat> chatList){
        this.chatList = chatList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderChat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mess,parent,false);
        return new ViewHolderChat(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChat holder, int position) {
        Chat chat = chatList.get(position);
        if(chat== null){
            return;
        }
        holder.txtchat.setText(chat.getMess());
    }

    @Override
    public int getItemCount() {
        if(chatList != null){
             return chatList.size();
        }
        return 0;
    }

    public class ViewHolderChat extends RecyclerView.ViewHolder {
        TextView txtchat;
        public ViewHolderChat(@NonNull View itemView) {
            super(itemView);
            txtchat = itemView.findViewById(R.id.txtchat);
        }
    }
}
