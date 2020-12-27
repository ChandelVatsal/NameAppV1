package com.example.namesproject;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.view.Display;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fechData extends AsyncTask<String, Void, Void> {
    String data = "";
    String dataParsed;
    String singleParsed;
    String myOut;
    String myName;

    @Override
    protected Void doInBackground(String... urlToUse) {
        //Have to create a class for what the JSON will have

        try {
            URL url = new URL(urlToUse[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                data += line;
                line = bufferedReader.readLine();
            }

            Gson gson = new Gson();
            Human human = gson.fromJson(data, Human.class);
            myName = human.getName();
            String myGender = human.getGender();
            String myMeaning = human.getMeaning();
            String myOrigin = human.getOrigin();
            String myComments = human.getComments();
            myOut = "Name: "+myName + "\nGender: "+myGender+  "\nMeaning: "+myMeaning+"\nOrigin: "+myOrigin +"\nComments: "+myComments;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

            if(myName == null){
                MainActivity.output.setText("Name not found! Check to see if there is a typo. \nContact me to add the name \n(vatsalchandel@gmail.com)");
            }else {

                MainActivity.output.setText(this.myOut);
            }

    }

    }
