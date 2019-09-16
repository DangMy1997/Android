package com.example.tuan02_bai03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtInput, lbKQ;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
        lbKQ = findViewById(R.id.lbKQ);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbKQ.setText(chuyenDoi(txtInput.getText().toString()));
            }
        });
    }

    public boolean isYear(String year){
        if(year.isEmpty()){
            Toast.makeText(this, "Năm đang rỗng!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!year.matches("[0-9]{1,4}")){
            Toast.makeText(this, "Năm là số > 0 và < 9999", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    public String chuyenDoi(String year){
        String kq = null, can = null, chi = null;
        if(isYear(year)){
            switch (Integer.parseInt(year) % 10) {
                case 0:
                    can = "Canh";
                    break;
                case 1:
                    can = "Tân";
                    break;
                case 2:
                    can = "Nhâm";
                    break;
                case 3:
                    can = "Quý";
                    break;
                case 4:
                    can = "Giáp";
                    break;
                case 5:
                    can = "Ất";
                    break;
                case 6:
                    can = "Bính";
                    break;
                case 7:
                    can = "Đinh";
                    break;
                case 8:
                    can = "Mậu";
                    break;
                case 9:
                    can = "Kỷ";
                    break;
            }

            // Xác định Chi
            switch (Integer.parseInt(year) % 12) {
                case 0:
                    chi = "Thân";
                    break;
                case 1:
                    chi = "Dậu";
                    break;
                case 2:
                    chi = "Tuất";
                    break;
                case 3:
                    chi = "Hợi";
                    break;
                case 4:
                    chi = "Tý";
                    break;
                case 5:
                    chi = "Sửu";
                    break;
                case 6:
                    chi = "Dần";
                    break;
                case 7:
                    chi = "Mẹo";
                    break;
                case 8:
                    chi = "Thìn";
                    break;
                case 9:
                    chi = "Tỵ";
                    break;
                case 10:
                    chi = "Ngọ";
                    break;
                case 11:
                    chi = "Mùi";
                    break;
            }
            kq = can + " " + chi;
        }
        return kq;
    }
}
