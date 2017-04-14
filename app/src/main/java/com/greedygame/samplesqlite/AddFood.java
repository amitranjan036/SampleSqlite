package com.greedygame.samplesqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by nikhil on 12/4/17.
 */

public class AddFood extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_add);

        EditText foodName = (EditText) findViewById(R.id.foodName);
        Button okButton = (Button) findViewById(R.id.button1);
        Button cancelButton = (Button) findViewById(R.id.button2);






}
}
