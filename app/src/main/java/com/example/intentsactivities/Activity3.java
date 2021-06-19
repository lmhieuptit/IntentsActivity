package com.example.intentsactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    Button submit,cancel;
    EditText backToActivity1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        submit = (Button)findViewById(R.id.btnSubmit);
        cancel = (Button)findViewById(R.id.btnCancel);

        backToActivity1 =(EditText)findViewById(R.id.edBackToActivity1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backToActivity1.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this,"Please enter some Text", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String surName= backToActivity1.getText().toString();

                    Intent intent = new Intent();
                    intent.putExtra("surName", surName);

                    setResult(RESULT_OK,intent);

                    Activity3.this.finish();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });
    }
}