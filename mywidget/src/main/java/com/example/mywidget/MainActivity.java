package com.example.mywidget;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    Button btnplus,btnMin,btnMul,btnDiv;
    EditText txtNum1, txtNum2; //
    TextView tv; //보여주는곳

//, View btnAdd
    //on 액티비티가 생성될때
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_cal);
        //버튼찾아주기
        btnplus = findViewById(R.id.btn);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        tv = findViewById(R.id.textView2);
        btnMin = findViewById(R.id.btnMin);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        //이벤트선언 이벤트리스너

        //익명클래스(클래스 선언과 생성을 동시에)
        //람다식 (하나의 추상메서드만 있는 인터페이스 인 경우)
        btnplus.setOnClickListener(v -> {
            //계산 editText 입력값들을 더해서 textview
            String txt = txtNum1.getText().toString();
            String txt2 = txtNum2.getText().toString();
            int result = Integer.parseInt(txt) + Integer.parseInt(txt2);
            tv.setText(String.valueOf(result));
        });
        btnMin.setOnClickListener(v -> {
            //계산 editText 입력값들을 더해서 textview
            String txt = txtNum1.getText().toString();
            String txt2 = txtNum2.getText().toString();
            int result = Integer.parseInt(txt) - Integer.parseInt(txt2);
            tv.setText(String.valueOf(result));
        });
        btnMul.setOnClickListener(v -> {
            //계산 editText 입력값들을 더해서 textview
            String txt = txtNum1.getText().toString();
            String txt2 = txtNum2.getText().toString();
            int result = Integer.parseInt(txt) * Integer.parseInt(txt2);
            tv.setText(String.valueOf(result));
        });
        btnDiv.setOnClickListener(v -> {
            //계산 editText 입력값들을 더해서 textview
            String txt = txtNum1.getText().toString();
            String txt2 = txtNum2.getText().toString();
            int result = Integer.parseInt(txt) / Integer.parseInt(txt2);
            tv.setText(String.valueOf(result));
        });

//        View.OnClickListener handler = v ->{
//            int n1 = Integer.parseInt(txtNum1.getText().toString());
//            int n2 = Integer.parseInt(txtNum2.getText().toString());
//            int result = 0;
//            switch (v.getId()){
//                case R.id.btnDiv: result = n1 + n2; break;
//                case R.id.btnMin: result = n1 - n2; break;
//            }
//        };
    }
    //event
    //1.Activity 인터페이스 상속받고 오버라이딩
    //2. setOn(this
//    class ClickHandler implements View.OnClickListener{
//        @Override
//        public void onClick(View view) {
//            System.out.println("클릭됨");
//            Toast.makeText(null, "클릭됨", Toast.LENGTH_LONG).show();
//
//        }
//    }
}

