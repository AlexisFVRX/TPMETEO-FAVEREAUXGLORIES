package com.example.tpmeteo;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Historique extends AppCompatActivity {
    BD bd;
    TextView TVHisVille;
    TextView TVHisTemp;
    TextView TVHisCond;
    ArrayList<String>Ville;
    Cursor data ;
    Spinner SpinnerVille;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historique);
        bd= new BD(this);
        TVHisVille = findViewById(R.id.HisVille);
        TVHisTemp = findViewById(R.id.HisTemp);
        TVHisCond = findViewById(R.id.HisCond);
        Ville = new ArrayList<String>();
        SpinnerVille = findViewById(R.id.spinnerVille);
    }



}
