package com.example.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Button btnSel, btnIns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        List<Map<String, String>> list;

        //메모
        String[] data = new String[]{""};
        list = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "홍길동");
        map.put("addr", "대구");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "홍길동");
        map.put("addr", "대구");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "홍길동");
        map.put("addr", "대구");
        list.add(map);

        MyAdapter adapter = new MyAdapter(list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getApplicationContext(), list.get(i).get("name"), Toast.LENGTH_LONG).show();
        });
    }
}