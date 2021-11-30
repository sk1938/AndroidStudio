package com.example.mymemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtResult;
    Button btnSel, btnInsert;

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
        txtResult = findViewById(R.id.txtResult);
        btnSel = findViewById(R.id.btnSel);

        btnInsert = findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
            startActivity(intent);
        });

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext()); //DB, TAB


        btnSel.setOnClickListener(v -> {

            ArrayList<String> list = new ArrayList<String>();
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String sql = "select * from emp";

            Cursor cursor = db.rawQuery(sql, null);

            while (cursor.moveToNext()) {
                list.add(cursor.getString(0));
                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
                list.add(cursor.getString(3));
            }
            txtResult.setText(list.toString());
            db.close();
        });
    }
}