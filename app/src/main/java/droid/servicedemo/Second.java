package droid.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mht on 16-Oct-17.
 */

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.one++;

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Hi", "Hi "+MainActivity.one);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject);

        Intent intent = new Intent(this, ServiceDemo.class);
        intent.putExtra("one", ""+ MainActivity.one);
        intent.putExtra("array", ""+ jsonArray.toString());
        startService(intent);
    }
}
