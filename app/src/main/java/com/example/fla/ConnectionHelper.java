package com.example.fla;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    @SuppressLint("NewApi")
    public Connection connection(){

        String ip="20.52.36.216";
        String db="dbpi";
        String user="root";
        String password="NN9sPG3Vfe5E7j";
        String port="3306";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection= null;
        String ConnectionURL = null;


        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL= "jdbc:jtds:sqlserver://"+ ip +":"+port+";databasename="+db+";user="+user+";password="+password+";";
            connection= DriverManager.getConnection(ConnectionURL);
        }

        catch (Exception ex) {
            Log.e("Error",ex.getMessage());
        }
        return connection;
    }

}

