package com.example.fla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Connection connect;
    String ConnectionResult="";

    public CardView elder, warn, info, sos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elder = (CardView) findViewById(R.id.c1);
        warn = (CardView) findViewById(R.id.c2);
        info = (CardView) findViewById(R.id.c4);
        sos = (CardView) findViewById(R.id.c3);

        elder.setOnClickListener(this);
        warn.setOnClickListener(this);
        info.setOnClickListener(this);
        sos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
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

    public void GetTextFromSQL(View v) {

        TextView tx12 = (TextView) findViewById(R.id.textView12);

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connection();
            if (connect != null) {
                String query = "SELECT * FROM configuration_properties where id='Copy'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    tx12.setText(rs.getString(4));


                }
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {
            Log.e("error", ex.getMessage());
        }

    }

}



