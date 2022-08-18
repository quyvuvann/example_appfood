package com.example.foodapp.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.foodapp.Doman.Account;
import com.example.foodapp.Helper.Database;
import com.example.foodapp.R;

public class Dangki extends Fragment {
    EditText editusername,editpassword,editemail;
    Button btnresgister;
    ProgressBar process;
    Handler handler;
    View view;
    MainActivity mainActivity;
    Database database;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dangki, container, false);
        mainActivity = (MainActivity) getActivity();
        editusername  = view.findViewById(R.id.editusername);
        editpassword = view.findViewById(R.id.editpassword);
        editemail = view.findViewById(R.id.editemail);
        btnresgister = view.findViewById(R.id.btnresgister);
        database = new Database(getActivity());
        btnresgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = editusername.getText().toString().trim();
                String password  = editpassword.getText().toString().trim();
                String email  = editemail.getText().toString().trim();
                int phanquyen = 1;

                Account account = new Account(username,password,email,phanquyen);
                if(username.equals("") && password.isEmpty() && email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                    Toast.makeText(mainActivity, "Nhâp đủ thông tin và đúng email !!!", Toast.LENGTH_LONG).show();
                }
                else{
                    database.addUsername(account);
                    Toast.makeText(mainActivity, "Đăng kí thành công !", Toast.LENGTH_SHORT).show();
                    editusername.setText("");
                    editpassword.setText("");
                    editemail.setText("");
                }
            }
        });
        return view ;
    }
}