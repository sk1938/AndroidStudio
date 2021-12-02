package com.example.mywriteread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead, btnWrite;
        DatePicker dp;

        btnRead = (Button)findViewById(R.id.btnRead);
        btnWrite = (Button)findViewById(R.id.btnWrite);
        dp = (DatePicker) findViewById(R.id.datePicker1);

        dp.init(2021, 11, 3, (datePicker, i, i1, i2) -> {
            //년 월 일 로 파일명 만듬 "20211205.txt"
            //파일을 읽어서 editview에 보이도록함.
            //없으면 toast로 없다고 출력
            String fileName = ""+i
                    +((i1<10)? ("0" +i1):i1)
                    +((i2<10)?("0"+i2) : i2) + ".txt";
            fileRead(fileName);
        });

        btnWrite.setOnClickListener(v ->{

        });

        btnWrite.setOnClickListener(v -> {
            try {
                int year =  dp.getYear();
                int month = dp.getMonth();
                String fileName = String.valueOf(year);
                FileOutputStream outFs = openFileOutput(""+ year +"년" + month + "월",
                        Context.MODE_PRIVATE);
                String str = "쿡북 안드로이드";
                outFs.write(str.getBytes());
                outFs.close();
                Toast.makeText(getApplicationContext(), "file.txt가 생성됨",
                        Toast.LENGTH_SHORT).show();
            } catch (IOException e) { }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    inFs.close();
                }catch (IOException e){
                }
            }
        });

        }
    private void fileRead(String filename){
        try{
            FileInputStream inFs = openFileInput(filename);
            byte[] txt = new byte[30];
            inFs.read(txt);
            String str = new String(txt);
            //editview
            inFs.close();
        } catch (IOException e){
            Toast.makeText(getApplicationContext(), "파일없음", Toast.LENGTH_SHORT).show();
        }
    }
}