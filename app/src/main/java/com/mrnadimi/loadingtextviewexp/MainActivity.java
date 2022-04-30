package com.mrnadimi.loadingtextviewexp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mrnadimi.loadingtextview.LoadingTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadingTextView dotTextView = findViewById(R.id.dot);
        dotTextView.startTimer();
    }
}