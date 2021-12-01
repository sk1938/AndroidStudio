package com.example.mylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecycleActivity extends AppCompatActivity {
    RecyclerView RecycleView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

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

        RecycleView = findViewById(R.id.RecycleView);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecycleView.setLayoutManager(layoutManager);
        RecycleView.setAdapter(new MyRecycleAdapter(list));
    }
}