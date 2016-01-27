package com.kru.pag.gamepaperrockscissors;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //Explicit
    private ImageView paperImageView, rockImageView,
            scissorImageView, playImageViwe, androidImageView;
    private TextView showtextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind widget
        bindwidget();

        //Paper Controller
        paperController();
        //Rock Controller
        rockController();
        //ScissorController
        scissorController();
    }// Main Method

    private void scissorController() {
        scissorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRandomPicture(3);
                changePlay(3);

            }
        });
    }

    private void rockController() {
        rockImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRandomPicture(2);
                changePlay(2);

            }
        });
    }

    private void paperController() {

        paperImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumber = 1;
                myRandomPicture(1);
                changePlay(intNumber);

            }
        });

    } // paperController

    private void myRandomPicture(int intUser){
        int intmyRandom = 0;
        Random objrandom = new Random();
        intmyRandom = objrandom.nextInt(3) +1;
        Log.d("Ran", "intmyRandom ==> " + intmyRandom);

        androidChange(intmyRandom);

        checkScore(intUser, intmyRandom);
    }

    private void checkScore(int intUser, int intmyRandom) {
        String strwin = "เฮ!! คุณชนะ";
        String strLost = "เฮ!! กูชนะ";
        String strDraw = "เอาใหม่ๆ";
        String strShow = null;

        //1 > กระดาษ, 2 > ค้อน 3, > กรรไกร
        switch (intUser){
            case 1: //กระดาษ
                switch (intmyRandom){
                    case 1://กระดาษ
                        strShow = strDraw;
                    case 2://ค้อน
                        strShow = strwin;
                    case 3://กรรไกร
                        strShow = strLost;
                }
                break;
            case 2: //ค้อน
                switch (intmyRandom){
                    case 1://กระดาษ
                        strShow = strLost;
                    case 2://ค้อน
                        strShow = strDraw;
                    case 3://กรรไกร
                        strShow = strwin;
                }
                break;
            case 3: //กรรไกร
                switch (intmyRandom){
                    case 1://กระดาษ
                        strShow = strwin;
                    case 2://ค้อน
                        strShow = strLost;
                    case 3://กรรไกร
                        strShow = strDraw;
                }
                break;
        }
        showtextView.setText(strShow);
    }

    private void androidChange(int intmyRandom) {
        int[] intSourceImage = new int[4];
        intSourceImage[0]=0;
        intSourceImage[1]=R.drawable.paper;
        intSourceImage[2]=R.drawable.rock;
        intSourceImage[3]=R.drawable.scissors;
        androidImageView.setImageResource(intSourceImage[intmyRandom]);
    }

    private void changePlay(int intNumber) {

        Log.d("test","ค่าที่รับได้ = " + intNumber);
        int intSound = R.raw.mosquito;
        switch (intNumber) {
            case 1:
                playImageViwe.setImageResource(R.drawable.paper);
                intSound = R.raw.cat;
                break;
            case 2:
                playImageViwe.setImageResource(R.drawable.rock);
                intSound = R.raw.elephant;
                break;
            case 3:
                playImageViwe.setImageResource(R.drawable.scissors);
                intSound = R.raw.mosquito;
                break;
        }// switch
        MediaPlayer imageMediaPlayer = MediaPlayer.create(getBaseContext(), intSound);
        imageMediaPlayer.start();
    }// changePlay



    private void bindwidget() {
        paperImageView = (ImageView) findViewById(R.id.imvPaper);
        rockImageView = (ImageView) findViewById(R.id.imvRock);
        scissorImageView = (ImageView) findViewById(R.id.imvScissors);
        playImageViwe = (ImageView) findViewById(R.id.imvPlayer);
        androidImageView = (ImageView) findViewById(R.id.imvAndroid);
        showtextView = (TextView) findViewById(R.id.txtShow);


    }
} // Main Class นี่คือคลาสหลักก
