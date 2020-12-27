package com.example.namesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String name;
    EditText nameInput;
    public static TextView output;
    Button submitButton;
    Button playBtn;
    TextView TEST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.nameInput);
        output = (TextView) findViewById(R.id.output);
        TEST = (TextView) findViewById(R.id.TEST);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString().toLowerCase();

                String urlToUse = "https://chandels.com/namesetc/api.php?name="+name+"&key=FREE-KEY&size=large";
                fechData process = new fechData();
                process.execute(urlToUse);
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void playFile(View v){

        name = nameInput.getText().toString().toLowerCase();
        String newName = name.substring(0, 1).toUpperCase() + name.substring(1);

        MediaPlayer mediaPlayer = new MediaPlayer();
        try{
            mediaPlayer.setDataSource("https://chandels.com/namesetc//pronunciations/"+newName+".mp3");
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    if(mp.isPlaying() && mp != null){
                        TEST.setText("There is a pronunciation for this name");
                    } else{
                        TEST.setText("There is no pronunciation for this name yet");
                    }
                }
            });
            mediaPlayer.prepareAsync();
            TEST.setText("There is no pronunciation for this name yet");
        }catch (IOException e){
       e.printStackTrace();
        }
    }
}