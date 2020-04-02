package com.example.sherry.sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ShowList extends AppCompatActivity {

    ProductDBHandler Pro;
   ListView obj;
//    final ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
         obj = (ListView) findViewById(R.id.showList);
       // Log.i("",Product.getArray().get(2));
        Pro = new ProductDBHandler(this, null, null, 1);
       // Pro.getArray();
        String data = Pro.get();
        String[] lelo =data.split("\n");
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lelo);
        obj.setAdapter(arrayAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //super.onBackPressed();
    }
}
