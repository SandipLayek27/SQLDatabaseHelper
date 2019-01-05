package com.example.android.sqlitedbhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CREATE FULL STRUCTURED TABLE
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","SANDIP");
            jsonObject.put("address","BANKURA");
            jsonObject.put("pincode",722101);
            jsonObject.put("mobile","8927281743");
            jsonArray.put(jsonObject);

            jsonObject = new JSONObject();
            jsonObject.put("name","ARUNAVA");
            jsonObject.put("address","KOLKATA");
            jsonObject.put("pincode",722121);
            jsonObject.put("mobile","7070696997");
            jsonArray.put(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonArray);
        sqLiteHelperTableData.createFullStructuredTable();
    }
}
