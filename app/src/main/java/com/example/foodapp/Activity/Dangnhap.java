package com.example.foodapp.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.foodapp.Helper.Database;
import com.example.foodapp.R;

public class Dangnhap extends Fragment {
    EditText editusername,editpassword;
    Button btnLogin;
    ProgressBar process;
    Handler handler;
    View view;
    MainActivity mainActivity;
    Database database;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_dangnhap, container, false);
        mainActivity = (MainActivity) getActivity();
        editusername  = view.findViewById(R.id.editusername);
        editpassword = view.findViewById(R.id.editpassword);
        btnLogin = view.findViewById(R.id.btnlogin);
        process = view.findViewById(R.id.process);
        handler = new Handler();
        database = new Database(getContext());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String username  = editusername.getText().toString().trim();
                        String password  = editpassword.getText().toString().trim();

                        Cursor cursor = database.getdata();

                        while (cursor.moveToNext()){
                            String dataUsername = cursor.getString(1);
                            String dataPassword  =  cursor.getString(2);

                            if(dataUsername.equalsIgnoreCase(username) && !dataUsername.equals("") && dataPassword.equalsIgnoreCase(password) && !dataPassword.equals("")){

                                int phanquyen = cursor.getInt(4);
                                int id = cursor.getInt(0);
                                String email = cursor.getString(3);
                                String usernameshow = cursor.getString(1);

                                Intent intent  =new Intent(mainActivity,IntroActivity.class);

                                intent.putExtra("phanquyen",phanquyen);
                                intent.putExtra("id",id);
                                intent.putExtra("email",email);
                                intent.putExtra("username",usernameshow);

                                startActivity(intent);

                                mainActivity.finish();

                            }
                            else{
                                Toast.makeText(mainActivity, "Login Fail !!!", Toast.LENGTH_SHORT).show();
                                process.setVisibility(View.GONE);
                            }
                        }
                        cursor.moveToFirst();
                        cursor.close();

                    }
                },2500);
            }
        });
        btnLogin.setTranslationY(300);
        btnLogin.setAlpha(0);
        btnLogin.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();

        return view;
    }
}