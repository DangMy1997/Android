package com.example.tuan02_m2_bai02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtUser, txtPass;
    CheckBox cb;
    Button btnLogin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPass = findViewById(R.id.txtPassword);
        txtUser = findViewById(R.id.txtUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        cb = findViewById(R.id.cbSave);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb.isChecked())
                    Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn chưa được lưu", Toast.LENGTH_SHORT).show();
            }
        });

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb.isChecked())
                    Toast.makeText(MainActivity.this, "Đã lưu thông tin", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Không lưu thông tin", Toast.LENGTH_SHORT).show();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Xác nhận");
                builder.setMessage("Bạn có muốn thoát không?");
                builder.setCancelable(false);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Tiếp tục công việc.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }

        });
    }
}
