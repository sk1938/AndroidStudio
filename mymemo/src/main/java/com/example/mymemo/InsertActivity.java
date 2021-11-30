package com.example.mymemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    EditText txtName, txtId, txtNumber, txtAge;
    Button btnOneSel, btnIns, btnDelete, btnUpdate, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        txtName = findViewById(R.id.txtName);
        txtId = findViewById(R.id.txtId);
        txtNumber = findViewById(R.id.txtNumber);
        txtAge = findViewById(R.id.txtAge);
        btnOneSel = findViewById(R.id.btnOneSel);
        btnIns = findViewById(R.id.btnIns);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnList = findViewById(R.id.btnList);

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext()); //DB, TAB
        btnIns.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String name = txtName.getText().toString();
            String number = txtNumber.getText().toString();
            String age = txtAge.getText().toString();
            String sqlInsert = "INSERT INTO emp" +
                    "(name, age, mobile) VALUES( '" + name + "', '" + number + "', '" + age + "')";
            db.execSQL(sqlInsert);
        });
        btnDelete.setOnClickListener(v -> {
            String id = txtId.getText().toString();
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("emp", "_id=?", new String[]{id});
            db.close();
        });
        btnOneSel.setOnClickListener(v -> {
            String id = txtId.getText().toString();
            String name = txtName.getText().toString();
            String number = txtNumber.getText().toString();
            String age = txtAge.getText().toString();
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String sql = "";
        });

        btnUpdate.setOnClickListener(v -> {

            SQLiteDatabase db = dbHelper.getWritableDatabase(); //db연결
            //ContentValues 이게뭔지알아낼것 = vo 같은 역할을 함.
            ContentValues contentValues = new ContentValues();
            String id = txtId.getText().toString();
            contentValues.put("name", txtName.getText().toString());
            contentValues.put("age", txtAge.getText().toString());
            contentValues.put("mobile", txtNumber.getText().toString());
            db.update("emp", contentValues,"_id=?", new String[]{id});
        });

        btnList.setOnClickListener(v->{

        });

    }
}