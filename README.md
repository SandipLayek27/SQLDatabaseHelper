# SQLDatabaseHelper
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
	        implementation 'com.github.SandipLayek27:SQLDatabaseHelper:1.0'
}
```

# ★ Features are
1. JSONArray to LOCAL DATABASE Storage [THIS LIBRARY CAN AUTOMATICALLY CREATE DATABASE, CREATE TABLE AND INSERT DATA SUCCESSFULLY].

# ★ Uses of above Features
* 1. JSONArray to LOCAL DATABASE Storage.
```sh
  //CREATE JSON ARRAY FORMAT
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

  //CALL LIBRARY FUNCTION [PASS:- DATABASE NAME, TABLE NAME & JSONARRAY]
  SQLiteHelper sqLiteHelperTableData = new SQLiteHelper(MainActivity.this,"DBMaster","master",jsonArray);
  if(sqLiteHelperTableData.createFullStructuredTable()){
      Toast.makeText(this, "SUCCESSFULLY CREATED", Toast.LENGTH_SHORT).show();   
  }else{
      Toast.makeText(this, "SOMETHING WRONG", Toast.LENGTH_SHORT).show();
  }
        
```

