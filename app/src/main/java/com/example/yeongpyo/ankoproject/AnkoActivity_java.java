package com.example.yeongpyo.ankoproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yeongpyo.ankoproject.anko_UI.AnkoUIMaker;

public class AnkoActivity_java extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnkoUIMaker UImaker = new AnkoUIMaker(this);
        setContentView(UImaker.UiMake());
        UImaker.textview.setText( " Change Text " );
    }
}
