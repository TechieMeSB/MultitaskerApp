package com.srishti.multitaskerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity2 extends AppCompatActivity {

    Button butn1,butn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        butn1=(Button)findViewById(R.id.butn1);
        butn2=(Button)findViewById(R.id.butn2);

        butn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(MainActivity2.this,"Part 'A' Apps ",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                Intent intent=new Intent(MainActivity2.this,PartAActivity.class);
                startActivity(intent);
            }
        });

        butn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(MainActivity2.this,"Part 'B' Apps ",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                Intent intent=new Intent(MainActivity2.this,PartBActivity.class);
                startActivity(intent);
            }
        });

    }
}