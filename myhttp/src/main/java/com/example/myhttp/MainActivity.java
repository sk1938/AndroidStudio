package com.example.myhttp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button button, btnIns;
    TextView textView;
    EditText txtId, txtName, txtPassWord, txtRole;

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       button = findViewById(R.id.button);
       btnIns = findViewById(R.id.button);
       textView = findViewById(R.id.textView);
       txtId = findViewById(R.id.txtId);
       txtName = findViewById(R.id.txtName);
       txtPassWord = findViewById(R.id.txtPassWord);
       txtRole = findViewById(R.id.txtRole);

        RequestQueue queue = Volley.newRequestQueue(this);

        btnIns.setOnClickListener(v->{
            String url = "http://10.0.2.2/userInsert";
            StringRequest request = new StringRequest(Request.Method.POST, url, s->{
                textView.setText(s);
            }, e->{}){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("id", "아");
                    map.put("name", "이");
                    map.put("password", "1234");
                    map.put("role", "Admin");
                    return map;
                }
            };
            queue.add(request);
        });

       button.setOnClickListener(v->{
           //String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20211130";
           String id = txtId.getText().toString();
           String url = "http://10.0.2.2/users?/id=" + user.id;
           //s -> 매개변수 e -> 에러 정보가 담겨있는 에러 객체
           StringRequest request = new StringRequest(url, s->{
               //이름과 패스워드만 표시 .Map or UserVO로 파싱
                Map<Object, String> map = gson.fromJson(url, Map.class);
               textView.setText(map.get("name"));
               textView.setText(map.get("password"));
           }, e->{
               Log.d("request",e.toString());
           });
           queue.add(request);
       });

    }
}