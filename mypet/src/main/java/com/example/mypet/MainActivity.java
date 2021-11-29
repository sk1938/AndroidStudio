package com.example.mypet;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chkAgree;
    TextView Text1;
    TextView Text2;

    RadioButton RdoDog,RdoCat,RdoRabbit;
    ImageView ImgPet;
    //button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkAgree = findViewById(R.id.chkAgree);
        RdoDog = findViewById(R.id.RdoDog);
        RdoCat = findViewById(R.id.RdoCat);
        RdoRabbit = findViewById(R.id.RdoRabbit);
        ImgPet = findViewById(R.id.ImgPet);
        Text1 = findViewById(R.id.Text1);
        Text2 = findViewById(R.id.Text2);

        View.OnClickListener handler = v->{
            //if 또는 switch로 radio 버튼에 따라서 이미지 변경
            switch (v.getId()){
                case R.id.RdoCat: ImgPet.setImageResource(R.drawable.dog2); break;
                case R.id.RdoDog: ImgPet.setImageResource(R.drawable.boxer); break;
                case R.id.RdoRabbit: ImgPet.setImageResource(R.drawable.dog); break;
            }
        };
        RdoDog.setOnClickListener(handler);
        RdoCat.setOnClickListener(handler);
        RdoRabbit.setOnClickListener(handler);
    }
}