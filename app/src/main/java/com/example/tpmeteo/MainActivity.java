package com.example.tpmeteo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    Context context;
    EditText editTextVille;
    TextView textView;
    TextView textView2;
    TextView TVtmin;
    TextView TVtmax;
    TextView test;
    BD bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        editTextVille = findViewById(R.id.ETville2);
        textView = findViewById(R.id.textViewCond);
        textView2 = findViewById(R.id.textViewtemp);
        TVtmin = findViewById(R.id.TVtmin);
        TVtmax = findViewById(R.id.TVtmax);
        bd= new BD(this);

    }

    public void click(View v) {
        String url = "https://www.prevision-meteo.ch/services/json/" + editTextVille.getText();
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jObj = new JSONObject(response);
                            JSONObject jObjCurrent = jObj.getJSONObject("current_condition");

                            JSONObject jObjCurrent2 = jObj.getJSONObject("fcst_day_0");
                            String tmin = jObjCurrent2.getString("tmin");
                            String tmax = jObjCurrent2.getString("tmax");

                            String tmp = jObjCurrent.getString("tmp");
                            String condition = jObjCurrent.getString("condition");
                            String icon = jObjCurrent.getString("icon");

                            textView.setText(condition);
                            textView2.setText(tmp + "°");
                            TVtmin.setText(tmin + "°");
                            TVtmax.setText(tmax + "°");
                            ImageView imageView = findViewById(R.id.imageView);
                            Picasso.get().load(icon).into(imageView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);

        bd.insertData(editTextVille.getText().toString(), textView2.getText().toString(), textView.getText().toString());
    }
    public void PageHistorique (View view){
        Intent intent1 = new Intent(this, Historique.class);
        startActivity(intent1);
    }
}
