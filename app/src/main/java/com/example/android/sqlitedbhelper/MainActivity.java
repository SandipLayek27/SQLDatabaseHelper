package com.example.android.sqlitedbhelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sqlitehelper.SQLiteHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /* FOR IMAGE FILE UPLOAD TO DATABASE CASE START */
//    Button captureBtn,saveBtn,updateBtn;
//    ImageView iv;
//    private static final int CAMERA_REQUEST = 1888;
//    String selectedPath="";
//    byte[] blobFormatedData;
    /* FOR IMAGE FILE UPLOAD TO DATABASE CASE END */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // IMAGE SAVE SECTION STARTS HERE
        // FIND IDS FOR IMAGE VIEW AND CAPTURE AND SAVE BUTTON
        captureBtn = findViewById(R.id.captureBtn);
        saveBtn = findViewById(R.id.saveBtn);
        updateBtn = findViewById(R.id.updateBtn);
        iv = findViewById(R.id.iv);

        // IMAGE CAPTURE CODE
        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
        // INSERT DATA WITH IMAGE CODE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // LOAD DATA WITH IMAGE
                JSONArray jsonArray = fetchDummyDataWithFile();

                SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonArray);
                if(sqLiteHelperTableData.createFullStructuredTable()){
                    Toast.makeText(MainActivity.this, "SUCCESSFULLY CREATED", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "SOMETHING WRONG", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // UPDATE IMAGE USING ID
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master");
                if(sqLiteHelperTableData.updateFileUsingId(1,"image",blobFormatedData)){
                    Toast.makeText(MainActivity.this, "SUCCESSFULLY UPDATED", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "SOMETHING WRONG", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // FETCH SINGLE ROW DATA WITH IMAGE AND ALSO PARSE IMAGE TO BITMAP AND SET IT TO IMAGE VIEW
        SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",1);
        JSONObject jsonObject1 = sqLiteHelperTableData.fetchById();
        byte[] image = new byte[0];
        try {
            image = (byte[]) jsonObject1.get("image");
            Bitmap bmp= BitmapFactory.decodeByteArray(image, 0 , image.length);
            iv.setImageBitmap(bmp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // GET IMAGE FROM DB AND SET TO IMAGE VIEW
        SQLiteHelper sqLiteHelperTableData1 = new SQLiteHelper(MainActivity.this,"DBMaster","master");
        Bitmap bitmap = sqLiteHelperTableData1.getImageUsingId(2,"image");
        iv.setImageBitmap(bitmap);
        // IMAGE SAVE SECTION END HERE
        */

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //FETCH DUMMY DATA
        //JSONArray jsonArray = fetchDummyData();

        //CREATE FULL STRUCTURED TABLE
       /* SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonArray);
        if(sqLiteHelperTableData.createFullStructuredTable()){
            Toast.makeText(this, "SUCCESSFULLY CREATED", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "SOMETHING WRONG", Toast.LENGTH_SHORT).show();
        }*/

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //FETCH DUMMY DATA
        //JSONArray jsonArray = fetchDummyData();

        //INSERT TABLE
        /*SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonArray);
        if(sqLiteHelperTableData.insert()){
            Toast.makeText(this, "SUCCESSFULLY INSERTED", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "SOMETHING WRONG", Toast.LENGTH_SHORT).show();
        }*/

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
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
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","address","KOLKATA");
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
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //UPDATE TABLE DATA USING ID(INTEGER)
        /*JSONObject jsonObject = formattedUpdatedData();
        SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,1);
        if(sqLiteHelperFetchByKeyValue.updateDataById()){
            Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
        }*/

        //UPDATE TABLE DATA USING ID. VARIOUS DATA TYPE PASSING
        /*JSONObject jsonObject = formattedUpdatedDataVeriousType();
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

        //UPDATE TABLE DATA USING KEY VALUE [VARIOUS DATA TYPE PASSING]
        /*JSONObject jsonObject = formattedUpdatedDataVeriousType();
        SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,"pincode",722121);
        if(sqLiteHelperFetchByKeyValue.updateDataByKey()){
            Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
        }*/

        /*JSONObject jsonObject = formattedUpdatedDataVeriousType();
        SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,"mobile","1234567890");
        if(sqLiteHelperFetchByKeyValue.updateDataByKey()){
            Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
        }*/
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //DELETE DATA FROM DATABASE USING ID
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",1);
        if(sqLiteHelperFetchByKeyValue.deleteDataById()){
            Toast.makeText(this, "Delete Data Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
        }*/

        //DELETE DATA FROM DATABASE USING KEY VALUE MATCHING
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","name","ARUNAVA");
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
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //DROP TABLE FROM DATABASE
        /*SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master");
        if(sqLiteHelperFetchByKeyValue.dropTable()){
            Toast.makeText(this, "Delete Table Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Delete Table Failed", Toast.LENGTH_SHORT).show();
        }*/
    }
    /*
    public JSONArray fetchDummyData(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","SANDIP");
            jsonObject.put("address","BANKURA");
            jsonObject.put("pincode",722101);
            jsonObject.put("mobile","8927281743");
            jsonObject.put("age",11);
            jsonArray.put(jsonObject);

            jsonObject = new JSONObject();
            jsonObject.put("name","ARUNAVA");
            jsonObject.put("address","KOLKATA");
            jsonObject.put("pincode",722121);
            jsonObject.put("mobile","1234567890");
            jsonObject.put("age",10);
            jsonArray.put(jsonObject);

            jsonObject = new JSONObject();
            jsonObject.put("name","MUGDHO");
            jsonObject.put("address","KOLKATA");
            jsonObject.put("pincode",722121);
            jsonObject.put("mobile","9876543210");
            jsonObject.put("age",5);
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
            jsonObject.put("name","NIRAJ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JSONObject formattedUpdatedDataVeriousType(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("address","DIGHA");
            jsonObject.put("age",30);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    */

    /*
    // IMAGE PURPOSE USES
    public JSONArray fetchDummyDataWithFile(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","SANDIP");
            jsonObject.put("address","BANKURA");
            jsonObject.put("pincode",722101);
            jsonObject.put("mobile","8927281743");
            jsonObject.put("age",11);
            jsonObject.put("image",blobFormatedData);
            jsonArray.put(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    // HOLD CAMERA CAPTURE DATA START
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(photo);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            String path = MediaStore.Images.Media.insertImage(getContentResolver(), photo, "IMG_" + System.currentTimeMillis(), null);
            Uri uri = Uri.parse(path);
            if (getContentResolver() != null) {
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    path = cursor.getString(idx);
                    blobFormatedData = readFile(path);
                    cursor.close();
                }
            }
        }
    }


    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }
    */
}
