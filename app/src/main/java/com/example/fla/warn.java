package com.example.fla;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class warn extends AppCompatActivity {
    Connection connect;
    String ConnectionResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warn);
    }


    public void GetTextFromSQL(View v)
    {
        TextView tx0= (TextView) findViewById(R.id.textView);
        TextView tx1= (TextView) findViewById(R.id.textView1);
        TextView tx2=(TextView) findViewById(R.id.textView2);
        TextView tx3=(TextView) findViewById(R.id.textView3);
        TextView tx4=(TextView) findViewById(R.id.textView4);
        TextView tx5=(TextView) findViewById(R.id.textView5);
        TextView tx6=(TextView) findViewById(R.id.textView6);
        TextView tx7=(TextView) findViewById(R.id.textView7);
        TextView tx8=(TextView) findViewById(R.id.textView8);
        TextView tx9=(TextView) findViewById(R.id.textView9);
        TextView tx10=(TextView) findViewById(R.id.textView10);
        TextView tx11=(TextView) findViewById(R.id.textView11);


        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connection();
            if (connect!=null)
            {
                String query = "SELECT * FROM Test WHERE user = 'alp' ";
                Statement st=connect.createStatement();
                ResultSet rs= st.executeQuery(query);

                while (rs.next())
                {
                    tx0.setText(rs.getString(1));
                    tx1.setText(rs.getString(2));
                    tx2.setText(rs.getString(3));
                    tx3.setText((rs.getString(4)));
                    tx4.setText((rs.getString(5)));
                    tx5.setText((rs.getString(6)));
                    tx6.setText(rs.getString(7));
                    tx7.setText(rs.getString(8));
                    tx8.setText(rs.getString(9));
                    tx9.setText(rs.getString(10));
                    tx10.setText(rs.getString(11));
                    tx11.setText(rs.getString(12));



                }
            }
            else
            {
                ConnectionResult="Check Connection";
            }
        }
        catch (Exception ex)
        {
            Log.e("error",ex.getMessage());
        }

    }

    public void backToMainPage(View view)
    {
        Intent intent = new Intent(warn.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}