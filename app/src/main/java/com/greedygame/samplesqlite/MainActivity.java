package com.greedygame.samplesqlite;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler myDb;
    ListView list;
   // ArrayAdapter<String> adapter;
    public FloatingActionButton plus;
   // private Context context;
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHandler(this);

        list= (ListView) findViewById(R.id.screenlist);
        plus= (FloatingActionButton) findViewById(R.id.fab);

        adapter = new MyCustomAdapter(this,android.R.layout.simple_list_item_1,);
        adapter.addItems(myDb.getAllFood());
        list.setAdapter(adapter);
     //   EditText input = new EditText(context);

      //  context = this;
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
//        adapter.addAll(myDb.getAllFood());
//        list.setAdapter(adapter);





        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), AddFood.class);
                startActivity(intent);
            }
        });
        }

    }
