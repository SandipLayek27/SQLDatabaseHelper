package com.example.android.sqlitedbhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlitehelper.SQLiteHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FETCH DUMMY DATA
        //JSONArray jsonArray = fetchDummyData();

        //CREATE FULL STRUCTURED TABLE
        /*SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonArray);
        if(sqLiteHelperTableData.createFullStructuredTable()){
            Toast.makeText(this, "SUCCESSFULLY CREATED", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "SOMETHING WRONG", Toast.LENGTH_SHORT).show();
        }*/


        //FETCH TABLE DATA
        /*SQLiteHelper sqLiteHelperFetch = new SQLiteHelper(MainActivity.this,"DBMaster","master");
        JSONArray jsonArrayData = sqLiteHelperFetch.fetchAll();
        if(jsonArrayData != null){
            Toast.makeText(this, ""+jsonArrayData.toString(), Toast.LENGTH_SHORT).show();
        }*/

        //FETCH TABLE DATA USING ID
        /*SQLiteHelper sqLiteHelperFetchById = new SQLiteHelper(MainActivity.this,"DBMaster","master",1);
        JSONObject jsonObject = sqLiteHelperFetchById.fetchById();
        if(jsonObject != null){
            Toast.makeText(this, ""+jsonObject.toString(), Toast.LENGTH_SHORT).show();
        }*/

        //FETCH TABLE DATA USING KEY VALUE(STRING)
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","name","SANDIP");
        JSONArray jsonArrayData = sqLiteHelperFetchByKeyValue.fetchByKeyValue();
        if(jsonArrayData != null){
            Toast.makeText(this, ""+jsonArrayData.toString(), Toast.LENGTH_SHORT).show();
        }*/


        //FETCH TABLE DATA USING KEY VALUE(INTEGER)
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","pincode",722121);
        JSONArray jsonArrayData = sqLiteHelperFetchByKeyValue.fetchByKeyValue();
        if(jsonArrayData != null){
            Toast.makeText(this, ""+jsonArrayData.toString(), Toast.LENGTH_SHORT).show();
        }*/

        //UPDATE TABLE DATA USING ID(INTEGER)
        /*JSONObject jsonObject = formattedUpdatedData();
        SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,1);
        if(sqLiteHelperFetchByKeyValue.updateDataById()){
            Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
        }*/

        //UPDATE TABLE DATA USING KEY VALUE
        /*JSONObject jsonObject = formattedUpdatedData();
        SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,"pincode",722101);
        if(sqLiteHelperFetchByKeyValue.updateDataByKey()){
            Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
        }*/

        /*JSONObject jsonObject = formattedUpdatedData();
        SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,"mobile","1234567890");
        if(sqLiteHelperFetchByKeyValue.updateDataByKey()){
            Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
        }*/

        //DELETE DATA FROM DATABASE USING ID
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",1);
        if(sqLiteHelperFetchByKeyValue.deleteDataById()){
            Toast.makeText(this, "Delete Data Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
        }*/

        //DELETE DATA FROM DATABASE USING KEY VALUE MATCHING
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","address","DIGHA");
        if(sqLiteHelperFetchByKeyValue.deleteDataByKeyValue()){
            Toast.makeText(this, "Delete Data Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
        }*/

        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","pincode",722121);
        if(sqLiteHelperFetchByKeyValue.deleteDataByKeyValue()){
            Toast.makeText(this, "Delete Data Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
        }*/

        //DROP TABLE FROM DATABASE
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master");
        if(sqLiteHelperFetchByKeyValue.dropTable()){
            Toast.makeText(this, "Delete Table Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Delete Table Failed", Toast.LENGTH_SHORT).show();
        }*/
    }


    public JSONArray fetchDummyData(){
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
            jsonObject.put("mobile","1234567890");
            jsonArray.put(jsonObject);

            jsonObject = new JSONObject();
            jsonObject.put("name","MUGDHO");
            jsonObject.put("address","KOLKATA");
            jsonObject.put("pincode",722121);
            jsonObject.put("mobile","9876543210");
            jsonArray.put(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public JSONObject formattedUpdatedData(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("address","DIGHA");
            jsonObject.put("name","RAMU");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


}
