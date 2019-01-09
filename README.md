# SQLiteDatabaseHelper
Databse Purpose Uses

## Developed
[![Sandip](https://avatars1.githubusercontent.com/u/31722942?v=4&u=18643bfaaba26114584d27693e9891db26bcb582&s=39) Sandip](https://github.com/SandipLayek27)  
# ★ Gradle Dependency
Add Gradle dependency in the build.gradle file of your application module (app in the most cases) :
First Tab:

```sh
allprojects{
    repositories{
        jcenter()
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

AND

```sh
dependencies {
	implementation 'com.github.SandipLayek27:SQLDatabaseHelper:1.3'
}
```

# ★ Features are
1. JSONArray to LOCAL DATABASE Storage [THIS LIBRARY CAN AUTOMATICALLY CREATE DATABASE, CREATE TABLE AND INSERT DATA SUCCESSFULLY].
2. Insert Data.
3. Fetch all  from Local Database (JSONArray Formated).
4. Fetch data from Database using Id (JSONObject Formated).
5. Fetch data from Database using Key & Value Dynamic Serching Technology(String and Integer both case).(JSONArray Formated)
6. Update data using id.(Integer)
7. Update data using id. [VARIOUS TYPE DATA PASSING] i,e. Updated data should be Integer Type and String Type both.
8. Update data using key & value(String and Integer both case).
9. Update data using key & value(String and Integer both case).
[VARIOUS TYPE DATA PASSING] i,e. Updated data should be Integer Type and String Type both.
10. Delete data from table using Id.
11. Delete data from table using key & value(String and Integer both case).
12. Drop table.


★ HELPER FORMAT FOR DUMMY DATA.
```
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
*******************************************************
public JSONObject formattedUpdatedData(){
JSONObject jsonObject = new JSONObject();
try {
    jsonObject.put("address","BANKURA");
    jsonObject.put("name","SANDIP");
} catch (JSONException e) {
    e.printStackTrace();
}
return jsonObject;
}
*******************************************************
public JSONObject formattedUpdatedDataVeriousType(){
JSONObject jsonObject = new JSONObject();
try {
    jsonObject.put("address","BANKURA");
    jsonObject.put("pincode",712345);
} catch (JSONException e) {
    e.printStackTrace();
}
return jsonObject;
}
```

# ★ Uses of above Features
* 1. JSONArray to LOCAL DATABASE Storage.
```sh
  //FETCH JSONArray DUMMY DATA
  JSONArray jsonArray = fetchDummyData();

  //CALL LIBRARY FUNCTION [PASS:- DATABASE NAME, TABLE NAME & JSONARRAY]
  SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonArray);
  if(sqLiteHelperTableData.createFullStructuredTable()){
      Toast.makeText(this, "SUCCESSFULLY CREATED", Toast.LENGTH_SHORT).show();   
  }else{
      Toast.makeText(this, "SOMETHING WRONG", Toast.LENGTH_SHORT).show();
  }
        
```
* 2. Insert Data.
```sh
//FETCH JSONArray DUMMY DATA
JSONArray jsonArray = fetchDummyData();

//CREATE FULL STRUCTURED TABLE
SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonArray);
if(sqLiteHelperTableData.insert()){
    Toast.makeText(this, "SUCCESSFULLY INSERTED", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "SOMETHING WRONG", Toast.LENGTH_SHORT).show();
}
        
```

* 3 Fetch all  from Local Database (JSONArray Formated).
```
SQLiteHelper sqLiteHelperFetch = new SQLiteHelper(MainActivity.this,"DBMaster","master");
JSONArray jsonArrayData = sqLiteHelperFetch.fetchAll();
if(jsonArrayData != null){
    Toast.makeText(this, ""+jsonArrayData.toString(), Toast.LENGTH_SHORT).show();
}
```

* 4 Fetch data from Database using Id (JSONObject Formated).
```
SQLiteHelper sqLiteHelperFetchById = new SQLiteHelper(MainActivity.this,"DBMaster","master",1);
JSONObject jsonObject = sqLiteHelperFetchById.fetchById();
if(jsonObject != null){
    Toast.makeText(this, ""+jsonObject.toString(), Toast.LENGTH_SHORT).show();
}
```

* 5 Fetch data from Database using Key & Value Dynamic Serching Technology(String and Integer both case)
```
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","name","SANDIP");
JSONArray jsonArrayData = sqLiteHelperFetchByKeyValue.fetchByKeyValue();
if(jsonArrayData != null){
    Toast.makeText(this, ""+jsonArrayData.toString(), Toast.LENGTH_SHORT).show();
}

SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","pincode",722101);
JSONArray jsonArrayData = sqLiteHelperFetchByKeyValue.fetchByKeyValue();
if(jsonArrayData != null){
    Toast.makeText(this, ""+jsonArrayData.toString(), Toast.LENGTH_SHORT).show();
}
```
* 6 Update data using Id.(Integer).
```
JSONObject jsonObject = formattedUpdatedData();
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,1);
if(sqLiteHelperFetchByKeyValue.updateDataById()){
    Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
}
```
* 7 Update data using id. [VARIOUS TYPE DATA PASSING] 
```
JSONObject jsonObject = formattedUpdatedDataVeriousType();
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,1);
if(sqLiteHelperFetchByKeyValue.updateDataById()){
    Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
}
```
* 8 Update data using key & value(String and Integer both case).
```
JSONObject jsonObject = formattedUpdatedData();
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,"pincode",722101);
if(sqLiteHelperFetchByKeyValue.updateDataByKey()){
    Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
}

JSONObject jsonObject = formattedUpdatedData();
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,"mobile","1234567890");
if(sqLiteHelperFetchByKeyValue.updateDataByKey()){
    Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
}
```

* 9 Update data using key & value(String and Integer both case)[VARIOUS TYPE DATA PASSING] .
```
JSONObject jsonObject = formattedUpdatedDataVeriousType();
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,"pincode",722121);
if(sqLiteHelperFetchByKeyValue.updateDataByKey()){
    Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
}

JSONObject jsonObject = formattedUpdatedDataVeriousType();
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,"mobile","1234567890");
if(sqLiteHelperFetchByKeyValue.updateDataByKey()){
    Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
}
```

* 10 Delete data from table using Id.
```
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",1);
if(sqLiteHelperFetchByKeyValue.deleteDataById()){
    Toast.makeText(this, "Delete Data Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
}
```
* 11 Delete data from table using key & value matching(String and Integer both case).
```
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","address","DIGHA");
if(sqLiteHelperFetchByKeyValue.deleteDataByKeyValue()){
    Toast.makeText(this, "Delete Data Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
}

SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master","pincode",722121);
if(sqLiteHelperFetchByKeyValue.deleteDataByKeyValue()){
    Toast.makeText(this, "Delete Data Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
}
```
* 12 Drop Table
```
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master");
if(sqLiteHelperFetchByKeyValue.dropTable()){
    Toast.makeText(this, "Delete Table Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Delete Table Failed", Toast.LENGTH_SHORT).show();
}
```
