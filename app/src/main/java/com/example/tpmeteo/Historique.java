package com.example.tpmeteo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Historique extends AppCompatActivity {
    BD bd;
    TextView TVHisVille;
    TextView TVHisTemp;
    TextView TVHisCond;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historique);
        bd= new BD(this);
        TVHisVille = findViewById(R.id.HisVille);
        TVHisTemp = findViewById(R.id.HisTemp);
        TVHisCond = findViewById(R.id.HisCond);
    }



}
