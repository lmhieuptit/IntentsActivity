package com.example.intentsactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName, passWord;
    Button login;
    String name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.edUserName);
        passWord = (EditText)findViewById(R.id.edPassword);

        login = (Button)findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!userName.getText().toString().trim().equals("sa")&&!passWord.getText().toString().trim().equals("sa"))
                {
                    Toast.makeText(MainActivity.this,"Sai tai khoan hoac mat khau",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,Activity1.class);

                    //intent.putExtra("toActivity2",name);

                    startActivity(intent);
                }
            }
        });
    }
}