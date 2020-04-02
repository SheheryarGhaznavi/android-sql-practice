package com.example.sherry.sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText name;
    TextView list;
    Button add, delete;
    ProductDBHandler Products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        list = (TextView) findViewById(R.id.list);
        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        Products = new ProductDBHandler(this, null, null, 1);
      //  Products.getArray();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product(name.getText().toString());
                Products.add(product);
                print();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Products.delete(name.getText().toString());
                print();
            }
        });


    }



    public void print()
    {
        String data = Products.get();
        list.setText(data);
      //  Products.getArray();
      //  list.setText(" ");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ShowList.class);
        startActivity(intent);
        //super.onBackPressed();
    }
}
