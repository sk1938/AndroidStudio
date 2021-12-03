package com.example.mydiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listDiary;
    Button btnWriteForm;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(getApplicationContext());
        listDiary = findViewById(R.id.listDiary);
        MemoDAO dao =new MemoDAO();
        ArrayList<DiaryVO> list = dao.selectAll(dbHelper);


        //listview 초기화 adapter 지정 - > 아이템 클릭 이벤트
        listDiary.setAdapter(new DiaryAdapter(list));
        //아이템 클릭 이벤트 : 수정, 삭제
        listDiary.setOnItemClickListener((adapterView, view, i, l) -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
            dialog.setTitle("확인")
                    .setPositiveButton("수정", (dialogInterface, i1) ->{
                        //intent 만들어서 activity 이동
                        //list = MemoDAO.selectAll(dbHelper);
//                        ((DiaryAdapter)listDiary.getAdapter()).setData(MemoDAO.selectAll(dbHelper));
//                        ((DiaryAdapter)listDiary.getAdapter()).notifyDataSetChanged();
                    })
                    .setNegativeButton("삭제", (dialogInterface, i1) ->{
                        MemoDAO.delete(dbHelper, "");
                        list.remove(i);
                        ((DiaryAdapter)listDiary.getAdapter()).notifyDataSetChanged();
                    })
                    .create()
                    .show();
        });
        //쓰기버튼 이벤트 지정 : writeActivity로 이동
        btnWriteForm = findViewById(R.id.btnWriteForm);
        btnWriteForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
            }
        });
    }
}