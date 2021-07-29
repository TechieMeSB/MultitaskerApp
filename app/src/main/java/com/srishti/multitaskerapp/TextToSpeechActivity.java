package com.srishti.multitaskerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.Locale;

public class TextToSpeechActivity extends AppCompatActivity {
    EditText tts;
    Button bn,bn1;
    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

    tts=(EditText)findViewById(R.id.tts);
    bn=(Button)findViewById(R.id.bn);
    bn1=(Button)findViewById(R.id.bn1);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        actionBar.setTitle("Text to Speech");

    textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if(status!=TextToSpeech.ERROR){
                textToSpeech.setLanguage(Locale.UK);
            }
        }
    });
        bn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tts.setText("");
        }
    });
}
    public void textToSpeech(View view){
        String text=tts.getText().toString();
        FancyToast.makeText(TextToSpeechActivity.this,text,FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}