package com.example.interactiveapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
    ImageView imageView;
    Random mRandom;
    int[] mPictures = {
            R.drawable.beach,
            R.drawable.bike,
            R.drawable.football,
            R.drawable.museum,
            R.drawable.park,
            R.drawable.restaurant,
            R.drawable.running,
            R.drawable.shop,
            R.drawable.swimming,
            R.drawable.walking,
    };
    int mCurrentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.picnic);
        mRandom = new Random();
    }

    @Override
    protected void onSaveInstanceState( Bundle outState) {
        outState.putInt(BUNDLE_CURRENT_INDEX, mCurrentIndex);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
        }

        if (mCurrentIndex != -1) {
            showImage();
        }
    }

    public void random(View view){
        if(mCurrentIndex < 10){
            mCurrentIndex = mRandom.nextInt(10);
            showImage();
        }

    }
    public void showImage(){
        Drawable picnicDrawable = ContextCompat.getDrawable(this, mPictures[mCurrentIndex]);
        imageView.setImageDrawable(picnicDrawable);
    }
    public void next(View view){
        if(mCurrentIndex == 9 ) {
            mCurrentIndex = -1;
            mCurrentIndex++;
            showImage();
        }else{
            mCurrentIndex++;
            showImage();

        }
    }
    public void back(View view){
        if(mCurrentIndex == 0) {
            mCurrentIndex = 10;
            mCurrentIndex = mCurrentIndex - 1;
            showImage();
        }else{
            mCurrentIndex = mCurrentIndex - 1;
            showImage();
        }

    }


}