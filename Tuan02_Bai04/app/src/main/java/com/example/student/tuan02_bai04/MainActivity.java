package com.example.student.tuan02_bai04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtName, txtCMND, txtBS;
    CheckBox cbDB, cbDS, cbDC;
    RadioButton rdTC, rdCD, rdDH;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtBS = findViewById(R.id.txtBS);
        txtCMND = findViewById(R.id.txtCMND);
        cbDB = findViewById(R.id.cbDB);
        cbDC = findViewById(R.id.cbDC);
        cbDS = findViewById(R.id.cbDS);
        rdCD = findViewById(R.id.rdCD);
        rdDH = findViewById(R.id.rdDH);
        rdTC = findViewById(R.id.rdTC);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = txtName.getText().toString();
                String CMND = txtCMND.getText().toString();
                String BS = txtBS.getText().toString();

                if(Name.isEmpty())
                    Toast.makeText(MainActivity.this, "Name is null!", Toast.LENGTH_SHORT).show();
                else if(CMND.isEmpty())
                    Toast.makeText(MainActivity.this, "CMND is null!", Toast.LENGTH_SHORT).show();
                else if(checkRegex(Name,CMND)){
                    if(!cbDB.isChecked() && !cbDC.isChecked() && !cbDS.isChecked())
                        Toast.makeText(MainActivity.this, "Chưa chọn sở thích", Toast.LENGTH_SHORT).show();
                    //else xử lý submit
                }
            }
        });

    }

    public boolean checkRegex(String name, String cmnd){
        if(!name.matches("^[a-z A-Z]{3,50}$")){
            Toast.makeText(this, "Tên dài ít 3 - 50 kí tự!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!cmnd.matches("[0-9]{9}")){
            Toast.makeText(this, "CMND là số 9 ký tự!", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }
}
