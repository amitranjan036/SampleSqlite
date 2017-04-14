package com.greedygame.samplesqlite;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.input;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler myDb;
    ListView list;
    ArrayAdapter<String> adapter;
    private String m_Text = "";
    public FloatingActionButton plus;
    private Context context;
    private AlertDialog builder;

    // ArrayList<Food> foodArrayList = new ArrayList<Food>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHandler(this);

        list= (ListView) findViewById(R.id.screenlist);
        plus= (FloatingActionButton) findViewById(R.id.fab);
        builder = new AlertDialog.Builder()
        EditText input = new EditText(context);
//        input.setInputType(InputType.TYPE_CLASS_TEXT );

        context = this;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        adapter.addAll(myDb.getAllFood());
        list.setAdapter(adapter);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                builder.setTitle("Add Food Name");


//            builder = new AlertDialog.Builder(context).setTitle("Add Food Name").setView().setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    m_Text = input.getText().toString();
//                }
//            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.cancel();
//                }
//            }).show();

            }
        });

        }

    }
