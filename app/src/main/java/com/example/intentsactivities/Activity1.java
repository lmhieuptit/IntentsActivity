package com.example.intentsactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {
    Button toActivity2, toActivity3;
    EditText textToActivity2;
    TextView textFromActivity3;
    final int ACTIVITY3 =3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        toActivity2 = (Button)findViewById(R.id.btnToActivity2);
        toActivity3 = (Button)findViewById(R.id.btnToActivity3);

        textToActivity2 = (EditText)findViewById(R.id.edToActivity2);
        textFromActivity3 = (TextView) findViewById(R.id.tvFromActivity3);

        toActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toActivity2.getText().toString().trim()=="")
                {
                    Toast.makeText(Activity1.this,"Please insert some Text",Toast.LENGTH_SHORT).show();
                }else{
                    String name = toActivity2.getText().toString();

                    Intent intent=new Intent();
                    intent.setClass(Activity1.this,Activity2.class);

                    intent.putExtra("toActivity2",name);

                    startActivity(intent);
                }
            }
        });
        toActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Activity1.this,Activity3.class);

                //startActivity(intent);

//                startActivity(intent);
                startActivityForResult(intent,ACTIVITY3);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ACTIVITY3)
        {
            if(resultCode==RESULT_OK)
            {
                String dataReceive = data.getStringExtra("surName");
                textFromActivity3.setText(dataReceive);
            }
            else if (resultCode==RESULT_CANCELED)
            {
                textFromActivity3.setText("Nothing received!");

            }

        }
    }

}