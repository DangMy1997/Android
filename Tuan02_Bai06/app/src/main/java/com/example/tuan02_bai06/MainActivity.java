package com.example.tuan02_bai06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lbKQ;
    ListView lv_Xem;
    String list[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbKQ = findViewById(R.id.lbKQ);
        lv_Xem = findViewById(R.id.lv_Xem);

        list = getResources().getStringArray(R.array.listName);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);

        lv_Xem.setAdapter(arrayAdapter);

        lv_Xem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lbKQ.setText("Position: " + i + " - Value: " + list[i]);
            }
        });

    }
}
