package com.example.mylist;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {
    RecyclerView RecycleView;


    ArrayList<MemoVO> list;
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ArrayList<MemoVO> list;
        list = new ArrayList<MemoVO>();
        MemoVO memoVO = new MemoVO();
        memoVO.setTitle("홍길동");
        memoVO.setContent("java content");
        list.add(memoVO);
        memoVO = new MemoVO();
        memoVO.setTitle("홍길동");
        memoVO.setContent("java content");
        list.add(memoVO);
        memoVO = new MemoVO();
        memoVO.setTitle("홍길동");
        memoVO.setContent("java content");
        list.add(memoVO);

        RecycleView = findViewById(R.id.RecycleView);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecycleView.setLayoutManager(layoutManager);
        RecycleView.setAdapter(new MyRecycleAdapter(list));
        RecycleView.setOnClickListener(view -> {
            AlterDialog.Builder builder = new AlterDialog.Builder(getApplicationContext());
            builder.setMessage("아이템이 선택됨").create();
        });
    }
}