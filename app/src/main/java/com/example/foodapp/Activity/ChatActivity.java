package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.foodapp.Adapter.ChatAdapter;
import com.example.foodapp.Doman.Chat;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    EditText editchat;
    Button btnsend;
    RecyclerView recyclerView;
    ChatAdapter chatAdapter;
    List<Chat> chatListl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initview();
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        chatListl = new ArrayList<>();
        chatAdapter = new ChatAdapter();

        chatAdapter.setData(chatListl);
        recyclerView.setAdapter(chatAdapter);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendchat();
            }
        });
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
                Intent intent = new Intent(ChatActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChatActivity.this,CartActivity.class));
                btncart.setBackgroundColor(R.drawable.backgroundcart);
            }
        });
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChatActivity.this,ProfileActivity.class));;
            }
        });
        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChatActivity.this,ChatActivity.class));
            }
        });
    }

    private void sendchat() {
        String strMesage = editchat.getText().toString().trim();
        if(TextUtils.isEmpty(strMesage)){
            return;
        }
        chatListl.add(new Chat(strMesage));
        chatAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(chatListl.size()-1);
        editchat.setText("");
    }

    private void initview() {
        editchat = findViewById(R.id.ideditchat);
        btnsend  = findViewById(R.id.btnsend);
        recyclerView = findViewById(R.id.recyclerview);
    }
}