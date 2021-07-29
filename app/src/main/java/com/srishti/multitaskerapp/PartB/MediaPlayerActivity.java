package com.srishti.multitaskerapp.PartB;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.srishti.multitaskerapp.R;

import java.util.concurrent.TimeUnit;

public class MediaPlayerActivity extends AppCompatActivity {
    ImageButton play,pause,back,forward;
    TextView songTime,startTime,songname;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;

    Handler handler=new Handler(Looper.myLooper());
    int etime=0,stime=0,otime=0,btime=5000,ftime=5000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        back = (ImageButton) findViewById(R.id.back);
        play = (ImageButton) findViewById(R.id.play);
        pause = (ImageButton) findViewById(R.id.pause);
        forward = (ImageButton) findViewById(R.id.forward);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        songname = (TextView) findViewById(R.id.tv2);
        songTime = (TextView) findViewById(R.id.songtime);
        startTime = (TextView) findViewById(R.id.startTime);
        seekBar.setClickable(false);
        pause.setEnabled(false);
        mediaPlayer = MediaPlayer.create(MediaPlayerActivity.this, R.raw.naadiyon);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        actionBar.setTitle("Media Player");


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplicationContext(), "Playing Song", Toast.LENGTH_SHORT).show();
                songname.setText("Nadiyon Paar");
                mediaPlayer.start();
                etime = mediaPlayer.getDuration();
                stime = mediaPlayer.getCurrentPosition();
                if (otime == 0) {
                    seekBar.setMax(etime);
                    otime = 1;
                }
                songTime.setText(String.format("%d min %d sec", TimeUnit.MILLISECONDS.toMinutes(etime),
                        TimeUnit.MILLISECONDS.toSeconds(etime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(etime))));
                startTime.setText(String.format("%d min %d sec", TimeUnit.MILLISECONDS.toMinutes(stime),
                        TimeUnit.MILLISECONDS.toSeconds(stime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(stime))));
                seekBar.setProgress(stime);
                handler.postDelayed(UpdateSong, 100);

                pause.setEnabled(true);
                play.setEnabled(false);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(getApplicationContext(), "Song Paused", FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                mediaPlayer.pause();
                pause.setEnabled(false);
                play.setEnabled(true);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((stime - btime) < 0) {
                    FancyToast.makeText(getApplicationContext(), "Cannot Jump Back", FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                } else {
                    mediaPlayer.seekTo(stime - btime);
                    FancyToast.makeText(getApplicationContext(), "Rewinding Song", Toast.LENGTH_SHORT,FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                }
                if (!play.isEnabled())
                    play.setEnabled(true);
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((stime + ftime) >= etime) {
                    FancyToast.makeText(getApplicationContext(), "Cannot Jump Forward", Toast.LENGTH_SHORT,FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                } else {
                    mediaPlayer.seekTo(stime + ftime);
                    FancyToast.makeText(getApplicationContext(), "Fast forwarding Song", Toast.LENGTH_SHORT,FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
                }
                if (!play.isEnabled())
                    play.setEnabled(true);
            }
        });


    }




    public  Runnable UpdateSong =new Runnable() {
        @Override
        public void run() {
            stime=mediaPlayer.getCurrentPosition();
            songTime.setText(String.format("%d min %d sec", TimeUnit.MILLISECONDS.toMinutes(etime),
                    TimeUnit.MILLISECONDS.toSeconds(etime)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(etime))));
            startTime.setText(String.format("%d min %d sec", TimeUnit.MILLISECONDS.toMinutes(stime),
                    TimeUnit.MILLISECONDS.toSeconds(stime)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(stime))));
            seekBar.setProgress(stime);
            handler.postDelayed(this,100);
        }
    };





}