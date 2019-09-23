package com.example.tuan02_m2_bai04;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private TextView txtName, lbKQ;
    private Button btn;
    private ListView lvXem;
    private ArrayList<String> list;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        lbKQ = findViewById(R.id.lbKQ);
        btn = findViewById(R.id.btn);

        list = new ArrayList<>();

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        lvXem.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                if(name.isEmpty()){
                    txtName.setError("Tên không để rỗng");
                }else {
                    list.add(name);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        lvXem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lbKQ.setText("Position: " + i + " - Value: " + adapterView.getList);
            }
        });
    }
}
