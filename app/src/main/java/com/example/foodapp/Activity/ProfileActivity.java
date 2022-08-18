package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp.R;

public class ProfileActivity extends AppCompatActivity {
    LinearLayout linearuser,linearemail,linearchangepassword,linearsignout;
    TextView txtusername;
    ImageView imgprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initview();
        bottomnavigation();
        linearsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setTitle("Sign out !");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Are you sure want sign out? ?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ProfileActivity.this,IntroActivity.class));
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        linearuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View vewInflater = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.dialoguse, (ViewGroup) v,false);
                final EditText input = (EditText)vewInflater.findViewById(R.id.edit_username);

                TextView txtuser  = findViewById(R.id.txtusername);
                String txtusercu = txtuser.getText().toString();
                input.setText(txtusercu);
                new AlertDialog.Builder(ProfileActivity.this)
                        .setTitle("Edit username")
                        .setView(vewInflater)
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String newName = input.getText().toString();
                                txtusername.setText(newName);
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }

        });
        linearemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Email của bạn là vuvanquy@gamil.com", Toast.LENGTH_SHORT).show();
            }
        });
        linearchangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    View vewInflater = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.dialog_changepassword, (ViewGroup) v,false);
                    final EditText input = (EditText)vewInflater.findViewById(R.id.edit_password);
                    new AlertDialog.Builder(ProfileActivity.this)
                            .setTitle("Edit change password !!")
                            .setView(vewInflater)
                            .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String newName = input.getText().toString();
                                    txtusername.setText(newName);
                                    dialogInterface.dismiss();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).show();

            }
        });
    }



    private void bottomnavigation() {
        LinearLayout btnhome = (LinearLayout) findViewById(R.id.idbtnhome);
        LinearLayout btncart = (LinearLayout) findViewById(R.id.idbtnCart);
        LinearLayout btnprofile = (LinearLayout) findViewById(R.id.idbtnprofilecart);
        LinearLayout btnchat = (LinearLayout) findViewById(R.id.idbtnchat);


        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,CartActivity.class));
                btncart.setBackgroundColor(R.drawable.backgroundcart);
            }
        });
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,ProfileActivity.class));;
            }
        });
        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,ChatActivity.class));
            }
        });
    }
    private void initview() {
        linearuser = findViewById(R.id.iusername);
        linearemail = findViewById(R.id.idemail);
        linearchangepassword = findViewById(R.id.idpasword);
        linearsignout = findViewById(R.id.idsingout);
        txtusername = findViewById(R.id.txtusername);
        imgprofile = findViewById(R.id.imgprofile);
    }
}