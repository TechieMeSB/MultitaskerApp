package com.srishti.multitaskerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import com.shashank.sony.fancytoastlib.FancyToast;

public class PartAActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_a);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(PartAActivity.this,"Calculator App",FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                Intent intent=new Intent(PartAActivity.this,CalculatorActivity.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(PartAActivity.this,"Counter App ",FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                Intent intent=new Intent(PartAActivity.this,CounterActivity.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(PartAActivity.this,"Wallpaper Setter App ",FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                Intent intent=new Intent(PartAActivity.this,WallpaperActivity.class);
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(PartAActivity.this,"XML JSON Parser App",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true).show();
                Intent intent=new Intent(PartAActivity.this,ParserActivity.class);
                startActivity(intent);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(PartAActivity.this,"Text to Speech App",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true).show();
                Intent intent=new Intent(PartAActivity.this, TextToSpeechActivity.class);
                startActivity(intent);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(PartAActivity.this,"Phone Dialer App",FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                Intent intent=new Intent(PartAActivity.this,CallSaveActivity.class);
                startActivity(intent);
            }
        });
    }
}