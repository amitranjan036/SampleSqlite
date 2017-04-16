package com.greedygame.samplesqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by nikhil on 12/4/17.
 */

public class AddFood extends AppCompatActivity{

    private View.OnClickListener buttonListener;
    DatabaseHandler myDb;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_add);

        myDb = new DatabaseHandler(this);

        final EditText foodName = (EditText) findViewById(R.id.foodName);
        Button okButton = (Button) findViewById(R.id.button1);
        Button cancelButton = (Button) findViewById(R.id.button2);

        buttonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.button2:
                in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
                    break;

                case R.id.button1:
                    myDb.insertData(foodName.getText().toString());
                    in = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in);
                    break;
            }
        }
    };

        cancelButton.setOnClickListener(buttonListener);
        okButton.setOnClickListener(buttonListener);
}
}
