package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(View.inflate(MainActivity.this, R.layout.alert, null));
                builder.show();
            }
        });
    }
    public void click_to_cancel (View V){
        Intent next = new Intent();
        next.setClass(this,MainActivity.class);
        startActivity(next);
    }

    //click_to_next
    public void click_to_next(View V)
    {
        Intent next = new Intent();
        next.setClass(this,MenuActivity.class);
        startActivity(next);
    }
    }
