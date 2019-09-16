package com.example.tuan02_bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtName, txtSL, txtTT, lbTKH, lbTKHV, lbTDT;
    Button btnTT, btnTiep, btnTK;
    CheckBox cbVip;

    public int isTiep = 0;

    ArrayList<KhachHang> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtSL = findViewById(R.id.txtSL);
        txtTT = findViewById(R.id.txtTT);
        lbTDT = findViewById(R.id.lbTDT);
        lbTKH = findViewById(R.id.lbTKH);
        lbTKHV = findViewById(R.id.lbTKHV);
        btnTT = findViewById(R.id.btnTT);
        btnTiep = findViewById(R.id.btnT);
        btnTK = findViewById(R.id.btnTK);
        cbVip = findViewById(R.id.cbVIP);

        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString(), sl = txtSL.getText().toString();
                if(name.isEmpty())
                    Toast.makeText(MainActivity.this, "Chưa nhập tên!", Toast.LENGTH_SHORT).show();
                else if (sl.isEmpty())
                    Toast.makeText(MainActivity.this, "Chưa nhập số lượng!", Toast.LENGTH_SHORT).show();
                else if(!name.matches("^[a-z A-Z]{3,50}$"))
                    Toast.makeText(MainActivity.this, "Tên từ 3-50 ký tự chữ!", Toast.LENGTH_SHORT).show();
                else if(!sl.matches("[0-9]{1,}"))
                    Toast.makeText(MainActivity.this, "Số lượng sách là số dương!", Toast.LENGTH_SHORT).show();
                else if(Integer.parseInt(sl) <= 0)
                    Toast.makeText(MainActivity.this, "Số lượng lớn hơn 0!", Toast.LENGTH_SHORT).show();
                else{
                    txtTT.setText(Integer.toString(Integer.parseInt(sl)*20000));
                    isTiep = 1;
                }
            }
        });

        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTiep == 0){
                    Toast.makeText(MainActivity.this, "Chưa có tổng tiền của khách hàng!", Toast.LENGTH_SHORT).show();
                }else{
                    if(cbVip.isChecked())
                        list.add(new KhachHang(txtName.getText().toString(),Integer.parseInt(txtTT.getText().toString()),true));
                    else
                        list.add(new KhachHang(txtName.getText().toString(),Integer.parseInt(txtTT.getText().toString()),false));
                    txtName.setText("");
                    txtSL.setText("");
                    txtTT.setText("");
                    cbVip.setChecked(false);
                }
            }
        });

        btnTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int tongDT = 0, tongKHV = 0;
                for (int i = 0 ; i < list.size(); i++){
                    if(list.get(i).isVip())
                        tongKHV++;
                    tongDT += list.get(i).getTt();
                }

                lbTDT.setText(Integer.toString(tongDT));
                lbTKH.setText(Integer.toString(list.size()));
                lbTKHV.setText(Integer.toString(tongKHV));
            }
        });
    }
}
