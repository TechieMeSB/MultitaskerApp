package com.srishti.multitaskerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.srishti.multitaskerapp.PartB.MediaPlayerActivity;
import com.srishti.multitaskerapp.PartB.MeetingSchedulerActivity;

public class PartBActivity extends AppCompatActivity {

    Button butn1,butn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_b);
        butn1=(Button)findViewById(R.id.bb1);
        butn2=(Button)findViewById(R.id.bb2);

        butn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(PartBActivity.this,"Play your favourite song ",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                Intent intent=new Intent(PartBActivity.this, MediaPlayerActivity.class);
                startActivity(intent);
            }
        });

        butn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(PartBActivity.this,"Schedule your Meeting",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                Intent intent=new Intent(PartBActivity.this, MeetingSchedulerActivity.class);
                startActivity(intent);
            }
        });
    }
}