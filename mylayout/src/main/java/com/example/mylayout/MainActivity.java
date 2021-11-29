package com.example.mylayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridLayout linear;
    int startNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById((R.id.linear));
        List numList = Arrays.asList(1,2,3,4,6,7,8,9,10,11,12,13,14,15,16);


        View.OnClickListener handler = v -> {
            ((Button)v).getText();

            //Toast.makeText(this, "클릭됨", Toast.LENGTH_LONG).show();
            //클릭한 버튼의 text(숫자값)을 읽어서 startNum 과 같다면
                //StartNum++
                //버튼의 text를 reset
            //16번까지 도착했으면 게임완료 toast
            if(Integer.parseInt(((Button) v).getText().toString()) == startNum){
                startNum++;
                ((Button)v).setText("");
            }
            if(startNum == 16){
                Toast.makeText(this, "게임완료", Toast.LENGTH_LONG).show();
            }
        };

        //남은것 16개의 숫자들을 랜덤한 위치에서 클릭하면 나오게하기 셔플이용
        //클릭하면 숫자가 1234 까지밖에안사라짐
        // 시작버튼 눌러야 시작되게 할것

        //1차원배열 16개의 임의의 순서로
        for(int i = 1; i<=16; i++){
            
            Button btn = new Button(this);
            btn.setText(String.valueOf(i));
            linear.addView(btn);
            btn.setOnClickListener(handler);
        }
    }
}