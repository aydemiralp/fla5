package com.example.fla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView  elder , warn , info , sos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elder=(CardView) findViewById(R.id.c1);
        warn =(CardView) findViewById(R.id.c2);
        info=(CardView) findViewById(R.id.c4);
        sos=(CardView) findViewById(R.id.c3);

        elder.setOnClickListener(this);
        warn.setOnClickListener(this);
        info.setOnClickListener(this);
        sos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.c1:
                i = new Intent(this, elder.class);
                startActivity(i);
                break;
            case R.id.c2:
                i = new Intent(this, com.example.fla.warn.class);
                startActivity(i);
                break;
            case R.id.c4:
                i = new Intent(this, info.class);
                startActivity(i);
                break;
            case R.id.c3:
                i = new Intent(this, sos.class);
                startActivity(i);
                break;
            default:


        }

}

}