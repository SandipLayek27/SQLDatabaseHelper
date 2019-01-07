package com.example.sqlitehelper;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class SQLiteHelper {

    Context context;
    String tableName="";
    String dataBaseName="";
    private SQLiteDatabase db;
    HashMap<String,String>hashMapData = null;
    JSONArray jsonArray = null;


    //CREATE DATABASE, TABLE AND INSERT DATA CASE
    public SQLiteHelper(Context context,String dataBaseName, String tableName, JSONArray jsonArray) {
        this.context = context;
        this.dataBaseName = dataBaseName;
        this.jsonArray = jsonArray;
        this.tableName = tableName;
    }

    //FETCH ALL DATA FROM DATABASE
    public SQLiteHelper(Context context,String dataBaseName, String tableName){
        this.context = context;
        this.dataBaseName = dataBaseName;
        this.tableName = tableName;
    }


    public boolean createFullStructuredTable(){

        if(dataBaseName.equalsIgnoreCase("")){
            Toast.makeText(context, "Database Name Required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(tableName.equalsIgnoreCase("")){
            Toast.makeText(context, "Table Name Required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(jsonArray.length() <= 0){
            Toast.makeText(context, "Data Must be Required", Toast.LENGTH_SHORT).show();
            return false;
        }
        try{
            if(createDatabase()){
                if(createTable()){
                    if(insertData()){
                        Toast.makeText(context, "SUCCESSFULLY DATA INSERTED", Toast.LENGTH_SHORT).show();
                        return true;
                    }else{
                        Toast.makeText(context, "DATA INSERT FAILURE", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }else {
                    Toast.makeText(context, "FAILED TO CREATE TABLE", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else{
                Toast.makeText(context, "DATABASE NOT CREATED", Toast.LENGTH_SHORT).show();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public JSONArray fetchAll(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        Cursor c;
        createDatabase();
        String SELECT_SQL = "SELECT * FROM master";
        c = db.rawQuery(SELECT_SQL, null);
        int columnCount = c.getColumnCount();
        if(c.moveToFirst()){
            while(!c.isAfterLast()){
                jsonObject = new JSONObject();
                for(int i =0; i<columnCount; i++){
                    try{
                        switch (c.getType(i))  {
                            case Cursor.FIELD_TYPE_FLOAT:
                                jsonObject.put(c.getColumnName(i),c.getFloat(i));
                                break;
                            case Cursor.FIELD_TYPE_INTEGER:
                                jsonObject.put(c.getColumnName(i),c.getInt(i));
                                break;
                            case Cursor.FIELD_TYPE_STRING:
                                jsonObject.put(c.getColumnName(i),c.getString(i));
                                break;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        return null;
                    }
                }
                //int i =0;
                jsonArray.put(jsonObject);
                c.moveToNext();
            }
            c.close();
        }else {
            return null;
        }
        return jsonArray;
    }


    //START METHODS SQLLITE DATABASE HANDLING
    public boolean createDatabase(){
        try{
            if(dataBaseName.equalsIgnoreCase("")){
                Toast.makeText(context, "Database Name Required", Toast.LENGTH_SHORT).show();
                return false;
            }
            db=context.openOrCreateDatabase(dataBaseName, Context.MODE_PRIVATE, null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean createTable(){
        String synOne = "CREATE TABLE IF NOT EXISTS "+tableName;
        String synTwo = synOne+"(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,";

        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject(0);
            Iterator<String> iter = jsonObject.keys();
            String keyPart = "";
            while (iter.hasNext()) {
                keyPart = iter.next();
                Object objDataVal = jsonObject.get(keyPart);
                if(objDataVal instanceof Integer){
                    synTwo = synTwo+HelperClass.fetchDataWithType(keyPart,"INTEGER");
                }else if( objDataVal instanceof Long ){
                    synTwo = synTwo+HelperClass.fetchDataWithType(keyPart,"LONGBLOB");
                }else if( objDataVal instanceof Boolean){
                    synTwo = synTwo+HelperClass.fetchDataWithType(keyPart,"BOOLEAN");
                }else if( objDataVal instanceof Float){
                    synTwo = synTwo+HelperClass.fetchDataWithType(keyPart,"FLOAT");
                }else{
                    synTwo = synTwo+HelperClass.fetchDataWithType(keyPart,"VARCHAR");
                }
                synTwo =synTwo +",";
            }
            synTwo = HelperClass.formattedQuery(synTwo)+");";
            try {
                db.execSQL(synTwo);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertData(){
        try{
            if(dataBaseName.equalsIgnoreCase("")){
                Toast.makeText(context, "Database Name Required", Toast.LENGTH_SHORT).show();
                return false;
            }
            if(tableName.equalsIgnoreCase("")){
                Toast.makeText(context, "Table Name Required", Toast.LENGTH_SHORT).show();
                return false;
            }
            if(jsonArray.length() <= 0){
                Toast.makeText(context, "Data Must be Required", Toast.LENGTH_SHORT).show();
                return false;
            }
            String finalQuery ="";

            try{
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                Iterator<String> iter = jsonObject.keys();
                String keyPart = "(";
                while (iter.hasNext()) {
                    keyPart = keyPart + iter.next() + ",";
                }
                keyPart = HelperClass.formattedQuery(keyPart);
                keyPart = keyPart + ")";

                String query1 = "INSERT INTO "+tableName+" "+keyPart+" VALUES ";
                String data = "";
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    Iterator<String> iter1 = jsonObject1.keys();
                    data = data+"(";
                    String keypartData ="";
                    while (iter1.hasNext()) {
                        keypartData = iter1.next();
                        Object objDataVal = jsonObject1.get(keypartData);
                        if(objDataVal instanceof Integer || objDataVal instanceof Long ||objDataVal instanceof Boolean || objDataVal instanceof Float){
                            data = data + jsonObject1.getString(keypartData) +",";
                        }else{
                            data = data +"'"+jsonObject1.getString(keypartData)+"'" +",";
                        }
                    }
                    data = HelperClass.formattedQuery(data);
                    data = data+"),";
                }
                data = HelperClass.formattedQuery(data);

                String query2 = query1+data;

                finalQuery = query2+";";
                db.execSQL(finalQuery);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
