package com.example.tuan02_bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtA,txtB,lbKQ, lbError;
    Button btnTong,btnHieu, btnTich, btnThuong, btnUCLN, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtB = findViewById(R.id.txtA);
        txtA = findViewById(R.id.txtB);
        lbKQ = findViewById(R.id.lbKQ);
        lbError = findViewById(R.id.lbError);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUCLN = findViewById(R.id.btnUCLN);
        btnThoat = findViewById(R.id.btnThoat);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbKQ.setText(Integer.toString(Tong()));
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbKQ.setText(Integer.toString(Hieu()));
            }
        });

        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbKQ.setText(Integer.toString(Tich()));
            }
        });

        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbKQ.setText(Float.toString(Thuong()));
            }
        });

        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbKQ.setText(Float.toString(UCLN()));
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public boolean isInteger(String a, String b){
        if(a.isEmpty()) {
            lbError.setText("A is null!");
        }else if(b.isEmpty()){
            lbError.setText("B is null!");
        }else if(!a.matches("\\d*")){
            lbError.setText("A is not integer!");
        }else if(!b.matches("\\d*")){
            lbError.setText("B is not integer!");
        }else{
            lbError.setText("");
            return true;
        }
        return false;
    }

    public int Tong (){
        String a = txtA.getText().toString();
        String b = txtB.getText().toString();
        if(!isInteger(a,b)){
            return 0;
        }else{
            return Integer.parseInt(a) + Integer.parseInt(b);
        }
    }

    public int Hieu (){
        String a = txtA.getText().toString();
        String b = txtB.getText().toString();
        if(!isInteger(a,b)){
            return 0;
        }else{
            return Integer.parseInt(a) - Integer.parseInt(b);
        }
    }

    public int Tich (){
        String a = txtA.getText().toString();
        String b = txtB.getText().toString();
        if(!isInteger(a,b)){
            return 0;
        }else{
            return Integer.parseInt(a) * Integer.parseInt(b);
        }
    }

    public float Thuong (){
        String a = txtA.getText().toString();
        String b = txtB.getText().toString();
        if(!isInteger(a,b)){
            return 0;
        }else{
            return ((float)Integer.parseInt(a)) / ((float)Integer.parseInt(b));
        }
    }

    public int UCLN (){
        String a = txtA.getText().toString();
        String b = txtB.getText().toString();
        if(!isInteger(a,b)){
            return 0;
        }else{
            return gcd(Integer.parseInt(a),Integer.parseInt(b));
        }
    }

    int gcd(int a, int b){
        // Nếu a = 0 => ucln(a,b) = b
        // Nếu b = 0 => ucln(a,b) = a
        if (a == 0 || b == 0){
            return a + b;
        }
        while (a != b){
            if (a > b){
                a -= b; // a = a - b
            }else{
                b -= a;
            }
        }
        return a; // return a or b, bởi vì lúc này a và b bằng nhau
    }

}
