package com.example.mydialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1, button2,button3,button4;

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        String[] city = new String[]{"대구", "서울", "부산"};
        button1.setOnClickListener(v ->{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("제목")
                    .setMessage("alert ")
                    .setPositiveButton("수정", (dialogInterface, i)->{
                        Log.d("alert","수정버튼");
                    })
                    .setNegativeButton("삭제", (di, i) ->{
                        Log.d("alert","삭제버튼");
                    })
                    .create()
                    .show();
        });
        ArrayList selectedItmes = new ArrayList<Integer>();
        button2.setOnClickListener(v->{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMultiChoiceItems(city, null,(dialog,which,isChecked)->{
                if(isChecked){
                    selectedItmes.add(which);
                }else if (selectedItmes.contains(which)){
                    selectedItmes.remove(which);
                }
            })
                    .setPositiveButton("확인", (dialog, id) ->{
                        //선택된 값들을 city 배열에서 찾아서 출력
                        //city.stream(city).filter().map(s->System.out::print);
                        for(Object i:selectedItmes){
                            int pos = ((Integer)i).intValue();
                            Log.d("alert",city[pos]);
                        }
                    })
                    .create()
                    .show();
        });
        button3.setOnClickListener(v->{ customModal(); });
        button4.setOnClickListener(v->{});
    }
    private void customModal(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(R.layout.activity_login)
                .create()
                .show();
    }
}