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
	implementation 'com.github.SandipLayek27:SQLDatabaseHelper:1.1'
}
```

# ★ Features are
1. JSONArray to LOCAL DATABASE Storage [THIS LIBRARY CAN AUTOMATICALLY CREATE DATABASE, CREATE TABLE AND INSERT DATA SUCCESSFULLY].
2. Fetch all  from Local Database (JSONArray Formated).
3. Fetch data from Database using Id (JSONObject Formated).
4. Fetch data from Database using Key & Value Dynamic Serching Technology(String and Integer both case).(JSONArray Formated)
5. Update data using id.(Integer)
6. Update data using key & value(String and Integer both case).
7. Delete data from table using Id.
8. Delete data from table using key & value(String and Integer both case).


★ HELPER FORMAT FOR DUMMY DATA.
```
//INSERT DATA CASE JSON FORMAT
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

//UPDATE DATA CASE JSON FORMAT
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

* 2 Fetch all  from Local Database (JSONArray Formated).
```
SQLiteHelper sqLiteHelperFetch = new SQLiteHelper(MainActivity.this,"DBMaster","master");
JSONArray jsonArrayData = sqLiteHelperFetch.fetchAll();
if(jsonArrayData != null){
    Toast.makeText(this, ""+jsonArrayData.toString(), Toast.LENGTH_SHORT).show();
}
```

* 3 Fetch data from Database using Id (JSONObject Formated).
```
SQLiteHelper sqLiteHelperFetchById = new SQLiteHelper(MainActivity.this,"DBMaster","master",1);
JSONObject jsonObject = sqLiteHelperFetchById.fetchById();
if(jsonObject != null){
    Toast.makeText(this, ""+jsonObject.toString(), Toast.LENGTH_SHORT).show();
}
```

* 4 Fetch data from Database using Key & Value Dynamic Serching Technology(String and Integer both case)
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
* 5 Update data using Id.(Integer).
```
JSONObject jsonObject = formattedUpdatedData();
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonObject,1);
if(sqLiteHelperFetchByKeyValue.updateDataById()){
    Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Updating Failed", Toast.LENGTH_SHORT).show();
}
```
* 6 Update data using key & value(String and Integer both case).
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
* Delete data from table using Id.
```
SQLiteHelper sqLiteHelperFetchByKeyValue = new SQLiteHelper(MainActivity.this,"DBMaster","master",1);
if(sqLiteHelperFetchByKeyValue.deleteDataById()){
    Toast.makeText(this, "Delete Data Successfully", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
}
```
* Delete data from table using key & value matching(String and Integer both case).
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
