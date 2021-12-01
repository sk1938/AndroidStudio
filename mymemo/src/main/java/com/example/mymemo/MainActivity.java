package com.example.mymemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.InputFilter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtResult;
    Button btnSel, btnIns;
    ListView lv;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            data.getIntExtra("code", 0);
            Toast.makeText(getApplicationContext(), "등록되었습니다", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIns = findViewById(R.id.btnIns);
        btnSel = findViewById(R.id.btnSel);
        lv = findViewById(R.id.lv);
        //메모
        String[] data = new String[]{""};
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "홍길동"); map.put("addr", "대구");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "홍길동"); map.put("addr", "대구");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "홍길동"); map.put("addr", "대구");
        list.add(map);
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                list,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "addr"},
                new int[]{android.R.id.text1,android.R.id.text2});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getApplicationContext(), list.get(i).get("name"), Toast.LENGTH_LONG).show();
        });
        btnSel.setOnClickListener(v ->{

        });
    }
}